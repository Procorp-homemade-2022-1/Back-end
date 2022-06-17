package com.upc.homemade.securityservice.client;

import com.upc.homemade.securityservice.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardsHystrixFallbackFactory implements CardClient {
    @Override
    public ResponseEntity<List<Card>> getByHomieId(Long homieId) {
        List<Card> card = new ArrayList<>();
        return ResponseEntity.ok(card);
    }
}
