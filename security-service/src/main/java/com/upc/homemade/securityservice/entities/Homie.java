package com.upc.homemade.securityservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "homies")
@Data
public class Homie {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "surname", length = 40, nullable = false)
    private String surname;
    @Column(name = "dni", nullable = false)
    private Long dni;
    @Column(name = "phone", length = 10, nullable = false)
    private Long phone;
    @Column(name = "email", length = 40, nullable = false)
    private String email;
}
