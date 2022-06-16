package com.upc.homemade.communicationservice.client;

import com.upc.homemade.communicationservice.model.Chef;
import com.upc.homemade.communicationservice.model.Homie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommsClientHystrixFallbackFactory implements CommsClient {
    @Override
    public ResponseEntity<Chef> fetchById(Long id){
        Chef chef = Chef.builder().address("none").age(null).dni(null).email("none").file("none").name("none").surname("none").phone(null).build();
        return ResponseEntity.ok(chef);
    }

    @Override
    public ResponseEntity<Homie> findById(Long id){
        Homie homie = Homie.builder().dni(null).email("none").name("none").phone(null).surname("none").build();
        return ResponseEntity.ok(homie);
    }
}
