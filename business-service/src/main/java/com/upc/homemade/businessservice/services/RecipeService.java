package com.upc.homemade.businessservice.services;

import com.upc.homemade.businessservice.entities.Recipe;

import java.util.Optional;

public interface RecipeService extends CrudService<Recipe, Long> {
    Optional<Recipe> findByTitle(String title)throws Exception;
    Recipe getRecipeById(Long recipeId);
}
