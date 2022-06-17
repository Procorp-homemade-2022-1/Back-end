package com.upc.homemade.billingservice.services;

import com.upc.homemade.billingservice.entities.Card;

import java.util.List;

public interface CardService extends CrudService<Card, Long>{
    Card getCardById(Long aLong);
    List<Card> getByHomieId(Long homieId) throws Exception;
}
