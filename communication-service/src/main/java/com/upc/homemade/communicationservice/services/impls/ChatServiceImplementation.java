package com.upc.homemade.communicationservice.services.impls;

import com.upc.homemade.communicationservice.client.CommsClient;
import com.upc.homemade.communicationservice.entities.Chat;
import com.upc.homemade.communicationservice.model.Chef;
import com.upc.homemade.communicationservice.model.Homie;
import com.upc.homemade.communicationservice.repositories.ChatRepository;
import com.upc.homemade.communicationservice.services.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ChatServiceImplementation implements ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    public CommsClient commsClient; //Se coloca este client.
    @Transactional
    @Override
    public Chat save(Chat entity) throws Exception {
        return chatRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Chat> findAll() throws Exception {
        return chatRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Chat> findById(Long aLong) throws Exception {
        //return chatRepository.findById(aLong);
        Chat chat =  chatRepository.findById(aLong).orElse(null);
        if (chat != null) {
            Long CId = chat.getChefId();
            Long HId = chat.getHomieId();
            Chef chef = commsClient.fetchById(CId).getBody();
            Homie homie = commsClient.findById(HId).getBody();
            chat.setChef(chef);
            chat.setHomie(homie);
        }
        return Optional.ofNullable(chat);
    }

    @Transactional
    @Override
    public Chat update(Chat entity) throws Exception {
        return chatRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        chatRepository.deleteById(aLong);
    }

    @Override
    public Chat getChatById(Long aLong) {
       return chatRepository.getById(aLong);
       }
}
