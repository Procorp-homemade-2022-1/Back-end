package com.upc.homemade.communicationservice.client;

import com.upc.homemade.communicationservice.model.Homie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "security-service", path = "/homies")
public interface HomieClient {
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Homie> fetchById(@PathVariable("id") Long id);
}
