package com.upc.homemade.businessservice.repositories;

import com.upc.homemade.businessservice.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    Optional<Ingredients> findByName(String name);
}
