package com.upc.homemade.communicationservice.controllers;

import com.upc.homemade.communicationservice.entities.Chat;
import com.upc.homemade.communicationservice.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
