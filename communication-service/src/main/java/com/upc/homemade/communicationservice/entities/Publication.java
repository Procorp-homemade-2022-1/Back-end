package com.upc.homemade.communicationservice.entities;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "publications")
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateOfPublication")
    private Date date;

    @Column(length = 50, nullable = false)
    private String text;

    private Integer likes;
}