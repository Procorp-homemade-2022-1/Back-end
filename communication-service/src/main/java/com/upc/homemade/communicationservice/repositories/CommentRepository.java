package com.upc.homemade.communicationservice.repositories;

import com.upc.homemade.communicationservice.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
