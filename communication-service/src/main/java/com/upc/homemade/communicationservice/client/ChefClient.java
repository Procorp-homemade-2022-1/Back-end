package com.upc.homemade.communicationservice.client;

import com.upc.homemade.communicationservice.model.Chef;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "security-service", path = "/chefs")
public interface ChefClient {
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Chef> fetchById(@PathVariable("id") Long id);
}
