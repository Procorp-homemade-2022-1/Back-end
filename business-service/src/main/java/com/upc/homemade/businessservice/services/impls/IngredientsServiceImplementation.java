package com.upc.homemade.businessservice.services.impls;

import com.upc.homemade.businessservice.entities.Ingredients;
import com.upc.homemade.businessservice.repositories.IngredientsRepository;
import com.upc.homemade.businessservice.services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImplementation implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Transactional
    @Override
    public Ingredients save(Ingredients entity) throws Exception {
        return ingredientsRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Ingredients> findAll() throws Exception {
        return ingredientsRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Ingredients> findById(Long aLong) throws Exception {
        return ingredientsRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Ingredients update(Ingredients entity) throws Exception {
        return ingredientsRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        ingredientsRepository.deleteById(aLong);
    }

    @Override
    public Optional<Ingredients> findByName(String name) throws Exception {
        return ingredientsRepository.findByName(name);
    }
}
