package com.upc.homemade.communicationservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.entities.Comment;
import pe.edu.upc.repositories.CommentRepository;
import pe.edu.upc.services.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment save(Comment entity) throws Exception {
        return commentRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> findAll() throws Exception {
        return commentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comment> findById(Long aLong) throws Exception {
        return commentRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Comment update(Comment entity) throws Exception {
        return commentRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        commentRepository.deleteById(aLong);
    }
}
