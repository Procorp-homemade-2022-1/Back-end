package com.upc.homemade.communicationservice.services.impls;

import com.upc.homemade.communicationservice.entities.Chat;
import com.upc.homemade.communicationservice.repositories.ChatRepository;
import com.upc.homemade.communicationservice.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImplementation implements ChatService {
    @Autowired
    private ChatRepository chatRepository;

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
        return chatRepository.findById(aLong);
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
