package com.upc.homemade.paymentservice.entities;

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
}
