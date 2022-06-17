package com.upc.homemade.communicationservice.client;

import com.upc.homemade.communicationservice.model.Chef;
import com.upc.homemade.communicationservice.model.Homie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "security-service", fallback = CommsHystrixFallbackFactory.class)
public interface CommsClient {
    @GetMapping(path = "chefs/id/{id}")
    public ResponseEntity<Chef> fetchById(@PathVariable("id") Long id);

    @GetMapping(path = "homies/id/{id}")
    public ResponseEntity<Homie> findById(@PathVariable("id") Long id);
}
