package com.upc.homemade.communicationservice.repositories;

import com.upc.homemade.communicationservice.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
