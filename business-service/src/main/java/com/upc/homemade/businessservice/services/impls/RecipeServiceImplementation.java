package com.upc.homemade.businessservice.services.impls;

import com.upc.homemade.businessservice.entities.Recipe;
import com.upc.homemade.businessservice.repositories.RecipeRepository;
import com.upc.homemade.businessservice.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImplementation implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Transactional
    @Override
    public Recipe save(Recipe entity) throws Exception {
        return recipeRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recipe> findAll() throws Exception {
        return recipeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Recipe> findById(Long aLong) throws Exception {
        return recipeRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Recipe update(Recipe entity) throws Exception {
        return recipeRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        recipeRepository.deleteById(aLong);
    }

    @Override
    public Optional<Recipe> findByTitle(String title) throws Exception {
        return recipeRepository.findByTitle(title);
    }
}
