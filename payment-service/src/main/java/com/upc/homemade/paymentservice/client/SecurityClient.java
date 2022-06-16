package com.upc.homemade.paymentservice.client;

import com.upc.homemade.paymentservice.model.Homie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "security-service")
public interface SecurityClient {
    @GetMapping(path = "homies/id/{id}")
    public ResponseEntity<Homie> findById(@PathVariable("id") Long id);

}
