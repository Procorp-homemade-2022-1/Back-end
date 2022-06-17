package com.upc.homemade.securityservice.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upc.homemade.securityservice.model.Card;


import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "billing-service", fallback = CardsHystrixFallbackFactory.class)
public interface CardClient {
    @GetMapping( "cards/homie-id/{homieId}")
    public ResponseEntity<List<Card>> getByHomieId(@PathVariable("homieId") Long homieId);
}
