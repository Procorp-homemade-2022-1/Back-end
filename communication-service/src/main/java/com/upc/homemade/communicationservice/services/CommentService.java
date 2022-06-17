package com.upc.homemade.communicationservice.services;

import com.upc.homemade.communicationservice.entities.Comment;

public interface CommentService extends CrudService<Comment, Long>{
    Comment getCommentById(Long along);
}
