package com.upc.homemade.paymentservice.services.impls;

import com.upc.homemade.paymentservice.client.CardClient;
import com.upc.homemade.paymentservice.client.SecurityClient;
import com.upc.homemade.paymentservice.entities.Payment;
import com.upc.homemade.paymentservice.exception.ResourceNotFoundException;
import com.upc.homemade.paymentservice.model.Card;
import com.upc.homemade.paymentservice.model.Homie;
import com.upc.homemade.paymentservice.repositories.PaymentRepository;
import com.upc.homemade.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImplementation implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    public CardClient cardClient; //Se coloca este client.
    @Autowired
    public SecurityClient securityClient;

    @Transactional
    @Override
    public Payment save(Payment entity) throws Exception {
        return paymentRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Payment> findAll() throws Exception {
        return paymentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Payment> findById(Long aLong) throws Exception {
        //return paymentRepository.findById(aLong);
        Payment payment =  paymentRepository.findById(aLong).orElse(null);
        if (payment != null) {
            Long UId = payment.getUserId();
            Long CId = payment.getCardId();
            Homie homie = securityClient.findById(UId).getBody();
            Card card = cardClient.fetchById(CId).getBody();
            payment.setHomie(homie);
            payment.setCard(card);
        }
        return Optional.ofNullable(payment);
    }

    @Transactional
    @Override
    public Payment update(Payment entity) throws Exception {
        return paymentRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        paymentRepository.deleteById(aLong);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
    }
}
