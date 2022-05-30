package com.upc.homemade.paymentservice.controllers;

import com.upc.homemade.paymentservice.entities.Card;

import com.upc.homemade.paymentservice.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Card> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Card> optionalCard = cardService.findById(id);
            if(optionalCard.isPresent()) {
                return new ResponseEntity<Card>(optionalCard.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Card> save(@Valid @RequestBody Card Card, BindingResult result) {

        try {
            Card CardCreate = cardService.save(Card);
            return ResponseEntity.status(HttpStatus.CREATED).body(CardCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Card> update(@PathVariable("id") Long id, @RequestBody Card Card) {

        try {
            Optional<Card> optionalCard = cardService.findById(id);
            if (optionalCard.isPresent()) {
                Card CardCreate = cardService.save(Card);
                return ResponseEntity.status(HttpStatus.CREATED).body(CardCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Card> deleteById(@PathVariable("id") Long id) {


        try {
            Optional<Card> optionalCard = cardService.findById(id);
            if (optionalCard.isPresent()) {
                cardService.deleteById(id);
                return new ResponseEntity<Card>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
