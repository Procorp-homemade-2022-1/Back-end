package com.upc.homemade.securityservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chefs")
@Data
public class Chef {
    //a
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "surname", length = 40, nullable = false)
    private String surname;
    @Column(name = "age", length = 400, nullable = false)
    private Integer age;
    @Column(name = "dni", nullable = false)
    private Long dni;
    @Column(name = "phone", length = 10, nullable = false)
    private Long phone;
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    @Column(name = "email", length = 40, nullable = false)
    private String email;
    @Column(name = "file", length = 400, nullable = false)
    private String file;
}
