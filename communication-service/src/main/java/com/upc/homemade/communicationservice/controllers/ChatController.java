package com.upc.homemade.communicationservice.controllers;

import com.upc.homemade.communicationservice.entities.Chat;
import com.upc.homemade.communicationservice.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatController{
    @Autowired
    private ChatService chatService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chat> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Chat> optionalChat = chatService.findById(id);
            if(optionalChat.isPresent()){
                return new ResponseEntity<Chat>(optionalChat.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Chat> save(@Valid @RequestBody Chat chat, BindingResult result){

        try {
            Chat chatCreate =  chatService.save(chat);
            return ResponseEntity.status(HttpStatus.CREATED).body(chatCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Chat> update(@PathVariable("id") Long id, @RequestBody Chat chat) {
        try {
            Optional<Chat> optionalChat = chatService.findById(id);
            if (optionalChat.isPresent()) {
                Chat chatCreate = chatService.save(chat);
                return ResponseEntity.status(HttpStatus.OK).body(chatCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Chat> deleteById(@PathVariable("id") Long id){

        try {
            Optional<Chat> optionalChat = chatService.findById(id);
            if(optionalChat.isPresent()){
                chatService.deleteById(id);
                return new ResponseEntity<Chat>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
