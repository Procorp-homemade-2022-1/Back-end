package com.upc.homemade.paymentservice.services.repositories;

import com.upc.homemade.paymentservice.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> getByHomieId(Long homieId) throws Exception;
}
