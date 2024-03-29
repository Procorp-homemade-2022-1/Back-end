package com.upc.homemade.communicationservice.services;

import com.upc.homemade.communicationservice.entities.Chat;

import java.util.Optional;

public interface ChatService extends CrudService<Chat, Long>{
    Chat getChatById(Long aLong);
}
