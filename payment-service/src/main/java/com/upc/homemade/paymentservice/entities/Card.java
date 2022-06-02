package com.upc.homemade.paymentservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "number")
    private Long number;
    @Column(name = "ccv", length = 3)
    private String ccv;
    @Column(name = "expiration")
    private String expiration;
    @Column(name = "owner")
    private String owner;
    @Column(name = "homie_id")
    private Long homieId;

}
