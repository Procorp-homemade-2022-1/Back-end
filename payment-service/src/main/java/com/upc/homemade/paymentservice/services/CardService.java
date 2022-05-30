package com.upc.homemade.paymentservice.services;

import com.upc.homemade.paymentservice.entities.Card;

public interface CardService extends CrudService<Card, Long>{
    Card getCardById(Long aLong);
}
