package com.upc.homemade.communicationservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.entities.Publication;
import pe.edu.upc.repositories.PublicationRepository;
import pe.edu.upc.services.PublicationService;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImplementation implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Transactional
    @Override
    public Publication save(Publication entity) throws Exception {
        return publicationRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Publication> findAll() throws Exception {
        return publicationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Publication> findById(Long aLong) throws Exception {
        return publicationRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Publication update(Publication entity) throws Exception {
        return publicationRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        publicationRepository.deleteById(aLong);
    }
}
