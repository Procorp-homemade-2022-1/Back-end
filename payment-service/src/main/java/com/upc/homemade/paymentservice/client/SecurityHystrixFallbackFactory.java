package com.upc.homemade.paymentservice.client;

import com.upc.homemade.paymentservice.model.Homie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SecurityHystrixFallbackFactory implements SecurityClient {
    @Override
    public ResponseEntity<Homie> findById(Long id) {
        Homie homie = Homie.builder().dni(null).email("none").name("none").phone(null).surname("none").build();
        return ResponseEntity.ok(homie);
    }
}
