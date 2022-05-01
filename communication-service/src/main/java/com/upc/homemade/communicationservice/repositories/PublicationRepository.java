package com.upc.homemade.communicationservice.repositories;

import com.upc.homemade.communicationservice.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    //prueba
}
