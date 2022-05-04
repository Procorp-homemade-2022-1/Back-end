package com.upc.homemade.securityservice.services.impls;

import com.upc.homemade.securityservice.entities.Chef;
import com.upc.homemade.securityservice.exception.ResourceNotFoundException;
import com.upc.homemade.securityservice.repositories.ChefRepository;
import com.upc.homemade.securityservice.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImplementation implements ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Transactional
    @Override
    public Chef save(Chef entity) throws Exception {
        return chefRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Chef> findAll() throws Exception {
        return chefRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Chef> findById(Long aLong) throws Exception {
        return chefRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Chef update(Chef entity) throws Exception {
        return chefRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        chefRepository.deleteById(aLong);
    }

    @Override
    public Chef getChefById(Long chefId) {
        return chefRepository.findById(chefId).orElseThrow(() -> new ResourceNotFoundException("Chef", "Id", chefId));
    }

}
