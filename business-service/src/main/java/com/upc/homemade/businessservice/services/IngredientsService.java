package com.upc.homemade.businessservice.services;

import com.upc.homemade.businessservice.entities.Ingredients;

import java.util.Optional;

public interface IngredientsService extends CrudService<Ingredients, Long>{
    Optional<Ingredients> findByName(String name)throws Exception;
    Ingredients getIngredientsById(Long aLong);

}
