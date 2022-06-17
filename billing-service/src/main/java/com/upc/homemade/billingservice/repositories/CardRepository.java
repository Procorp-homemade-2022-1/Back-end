package com.upc.homemade.billingservice.repositories;

import com.upc.homemade.billingservice.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> getByHomieId(Long homieId) throws Exception;
}
