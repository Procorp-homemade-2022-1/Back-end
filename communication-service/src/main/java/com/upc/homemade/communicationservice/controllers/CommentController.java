package com.upc.homemade.communicationservice.controllers;

import com.upc.homemade.communicationservice.entities.Comment;
import com.upc.homemade.communicationservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Comment> optionalComment = commentService.findById(id);
            if(optionalComment.isPresent()){
                return new ResponseEntity<Comment>(optionalComment.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Comment> save(@Valid @RequestBody Comment comment, BindingResult result){

        try {
            Comment commentCreate =  commentService.save(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body(commentCreate);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comment> update(@PathVariable("id") Long id, @RequestBody Comment comment){

        try {
            Optional<Comment> optionalComment = commentService.findById(id);
            if(optionalComment.isPresent()){
                Comment commentCreate = commentService.save(comment);
                return ResponseEntity.status(HttpStatus.CREATED).body(commentCreate);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Comment> deleteById(@PathVariable("id") Long id){

        try {
            Optional<Comment> optionalComment = commentService.findById(id);
            if(optionalComment.isPresent()){
                commentService.deleteById(id);
                return new ResponseEntity<Comment>(HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
