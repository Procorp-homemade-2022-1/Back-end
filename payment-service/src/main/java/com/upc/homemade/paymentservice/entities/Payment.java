package com.upc.homemade.paymentservice.entities;

import com.upc.homemade.paymentservice.model.Card;
import com.upc.homemade.paymentservice.model.Homie;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "status")
    private String status;
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "amount")
    private float amount;
    @Column(name = "dateOfPayment")
    private Date date = new Date();
    @Column(name="user_id")
    private Long userId;
    @Column(name="card_id")
    private Long cardId;


    @Transient
    private Homie homie;
    @Transient
    private Card card;
}
