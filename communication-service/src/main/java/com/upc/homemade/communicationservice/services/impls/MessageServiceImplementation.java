package com.upc.homemade.communicationservice.services.impls;

import com.upc.homemade.communicationservice.entities.Message;
import com.upc.homemade.communicationservice.repositories.MessageRepository;
import com.upc.homemade.communicationservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class MessageServiceImplementation implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    @Override
    public Message save(Message entity) throws Exception {
        return messageRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Message> findAll() throws Exception {
        return messageRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Message> findById(Long aLong) throws Exception {
        return messageRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Message update(Message entity) throws Exception {
        return messageRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        messageRepository.deleteById(aLong);

    }
}
