package com.upc.homemade.communicationservice.controllers;

import com.upc.homemade.communicationservice.entities.Publication;
import com.upc.homemade.communicationservice.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Publication> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Publication> optionalPublication = publicationService.findById(id);
            if(optionalPublication.isPresent()){
                return new ResponseEntity<Publication>(optionalPublication.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Publication> save(@Valid @RequestBody Publication publication, BindingResult result){
        try {
            Publication publicationCreate =  publicationService.save(publication);
            return ResponseEntity.status(HttpStatus.CREATED).body(publicationCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Publication> update(@PathVariable("id") Long id, @RequestBody Publication publication){
        try {
            Optional<Publication> optionalPublication = publicationService.findById(id);
            if(optionalPublication.isPresent()){
                Publication publicationCreate = publicationService.save(publication);
                return ResponseEntity.status(HttpStatus.OK).body(publicationCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Publication> deleteById(@PathVariable("id") Long id){
        try {
            Optional<Publication> optionalPublication = publicationService.findById(id);
            if(optionalPublication.isPresent()){
                publicationService.deleteById(id);
                return new ResponseEntity<Publication>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
