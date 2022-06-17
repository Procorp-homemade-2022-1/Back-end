package com.upc.homemade.communicationservice.services.impls;

import com.upc.homemade.communicationservice.entities.Comment;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.repositories.CommentRepository;
import com.upc.homemade.communicationservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
    }
}
