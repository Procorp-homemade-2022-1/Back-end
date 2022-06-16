package com.upc.homemade.paymentservice.services.impls;

import com.upc.homemade.paymentservice.entities.Card;
import com.upc.homemade.paymentservice.exception.ResourceNotFoundException;
import com.upc.homemade.paymentservice.repositories.CardRepository;

import com.upc.homemade.paymentservice.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImplementation implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Transactional
    @Override
    public Card save(Card entity) throws Exception {
        return cardRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Card> findAll() throws Exception {
        return cardRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Card> findById(Long aLong) throws Exception {
        return cardRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Card update(Card entity) throws Exception {
        return cardRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        cardRepository.deleteById(aLong);
    }
    @Override
    public Card getCardById(Long cardId) {

        return cardRepository.findById(cardId).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Id", cardId)
        );
    }

    @Override
    public List<Card> getByHomieId(Long homieId) throws Exception {
        return cardRepository.getByHomieId(homieId);
    }
}
