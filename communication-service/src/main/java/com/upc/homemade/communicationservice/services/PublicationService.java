package com.upc.homemade.communicationservice.services;

import com.upc.homemade.communicationservice.entities.Publication;

public interface PublicationService extends CrudService<Publication, Long>{
    Publication getPublicationById(Long aLong);

}
