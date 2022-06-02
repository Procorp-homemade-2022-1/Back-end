package com.upc.homemade.securityservice.services;

import com.upc.homemade.securityservice.entities.Homie;
import com.upc.homemade.securityservice.model.Card;

public interface HomieService extends CrudService<Homie, Long>{
    Homie getHomieById(Long aLong);

    Card getCard();
}
