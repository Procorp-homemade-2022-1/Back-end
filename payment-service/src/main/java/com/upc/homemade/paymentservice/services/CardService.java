package com.upc.homemade.paymentservice.services;

import com.upc.homemade.paymentservice.entities.Card;

import java.util.List;

public interface CardService extends CrudService<Card, Long>{
    Card getCardById(Long aLong);
    List<Card> getByHomieId(Long homieId) throws Exception;
}
