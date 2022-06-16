package com.upc.homemade.paymentservice.client;

import com.upc.homemade.paymentservice.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "billing-service", path = "/cards")
public interface CardClient {
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Card> fetchById(@PathVariable("id") Long id);
}
