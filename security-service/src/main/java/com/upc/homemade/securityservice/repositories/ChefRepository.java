package com.upc.homemade.securityservice.repositories;

import com.upc.homemade.securityservice.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef,Long>{

}
