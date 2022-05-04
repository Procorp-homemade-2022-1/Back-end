package com.upc.homemade.securityservice.services.impls;

import com.upc.homemade.securityservice.entities.Homie;
import com.upc.homemade.securityservice.exception.ResourceNotFoundException;
import com.upc.homemade.securityservice.repositories.HomieRepository;
import com.upc.homemade.securityservice.services.HomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HomieServiceImplementation implements HomieService {
    @Autowired
    private HomieRepository homieRepository;

    @Transactional
    @Override
    public Homie save(Homie entity) throws Exception {
        return homieRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Homie> findAll() throws Exception {
        return homieRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Homie> findById(Long aLong) throws Exception {
        return homieRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Homie update(Homie entity) throws Exception {
        return homieRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        homieRepository.deleteById(aLong);
    }

    @Override
    public Homie getHomieById(Long homieId) {
        return homieRepository.findById(homieId).orElseThrow(() -> new ResourceNotFoundException("Homie", "Id", homieId));
    }
}
