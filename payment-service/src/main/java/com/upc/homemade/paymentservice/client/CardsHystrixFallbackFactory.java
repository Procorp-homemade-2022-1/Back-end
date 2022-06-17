package com.upc.homemade.paymentservice.client;

import com.upc.homemade.paymentservice.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsHystrixFallbackFactory implements CardClient {
    @Override
    public ResponseEntity<Card> fetchById(Long id) {
        Card card = Card.builder().homieId(null).ccv("none").expiration("none").number(null).owner("none").build();
        return ResponseEntity.ok(card);
    }
}
