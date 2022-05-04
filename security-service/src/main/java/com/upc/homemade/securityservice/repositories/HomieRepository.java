package com.upc.homemade.securityservice.repositories;

import com.upc.homemade.securityservice.entities.Homie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomieRepository extends JpaRepository<Homie, Long> {
}
