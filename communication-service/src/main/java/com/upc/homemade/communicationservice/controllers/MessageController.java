package com.upc.homemade.communicationservice.controllers;

import com.upc.homemade.communicationservice.entities.Message;
import com.upc.homemade.communicationservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Message> optionalMessage = messageService.findById(id);
            if(optionalMessage.isPresent()){
                return new ResponseEntity<Message>(optionalMessage.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Message> save(@Valid @RequestBody Message message, BindingResult result){
        try {
            Message messageCreate =  messageService.save(message);
            return ResponseEntity.status(HttpStatus.CREATED).body(messageCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable("id") Long id){

        try {
            Optional<Message> optionalMessage = messageService.findById(id);
            if(optionalMessage.isPresent()){
                messageService.deleteById(id);
                return new ResponseEntity<Message>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
