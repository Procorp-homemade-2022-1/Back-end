package com.upc.homemade.securityservice.services.impls;

import com.upc.homemade.securityservice.client.CardClient;
import com.upc.homemade.securityservice.entities.Homie;
import com.upc.homemade.securityservice.model.Card;
import com.upc.homemade.securityservice.repositories.HomieRepository;
import com.upc.homemade.securityservice.services.HomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HomieServiceImplementation implements HomieService {
    @Autowired
    private HomieRepository homieRepository;

    @Autowired
    public CardClient cardClient; //Se coloca este client.
    @Transactional
    @Override
    public Homie save(Homie entity) throws Exception {
        return homieRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Homie> findAll() throws Exception {
        return homieRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Homie> findById(Long aLong) throws Exception {
        Homie homie =  homieRepository.findById(aLong).orElse(null);
        if (homie != null) {
            List<Card> cards = cardClient.getByHomieId(aLong).getBody();
            homie.setCards(cards);
        }
        return Optional.ofNullable(homie);
    }

    @Transactional
    @Override
    public Homie update(Homie entity) throws Exception {
        return homieRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        homieRepository.deleteById(aLong);
    }

    @Override
    public Homie getHomieById(Long homieId) {
        Homie homie = homieRepository.findById(homieId).orElse(null);
        if (homie != null) {
            List<Card> cards = cardClient.getByHomieId(homieId).getBody();
            homie.setCards(cards);

        }
        return homie;
    }
    @Override
    public Card getCard() {
        long a = 1;
        return (Card) cardClient.getByHomieId(a).getBody();

    }
}
