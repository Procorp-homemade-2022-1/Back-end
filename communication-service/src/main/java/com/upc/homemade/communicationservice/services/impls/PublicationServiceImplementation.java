package com.upc.homemade.communicationservice.services.impls;

import com.upc.homemade.communicationservice.client.CommsClient;
import com.upc.homemade.communicationservice.entities.Publication;
import com.upc.homemade.communicationservice.exception.ResourceNotFoundException;
import com.upc.homemade.communicationservice.model.Chef;
import com.upc.homemade.communicationservice.repositories.PublicationRepository;
import com.upc.homemade.communicationservice.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImplementation implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    public CommsClient commsClient; //Se coloca este client.

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
        //return publicationRepository.findById(aLong);
        Publication publication =  publicationRepository.findById(aLong).orElse(null);
        if (publication != null) {
            Long CId = publication.getChefId();
            Chef chef = commsClient.fetchById(CId).getBody();
            publication.setChef(chef);
        }
        return Optional.ofNullable(publication);
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
    @Override
    public Publication getPublicationById(Long publicationid) {
        return publicationRepository.findById(publicationid).orElseThrow(() -> new ResourceNotFoundException("Publication", "Id", publicationid));
    }
}
