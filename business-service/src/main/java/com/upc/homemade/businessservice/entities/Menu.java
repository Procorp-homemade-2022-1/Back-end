package com.upc.homemade.businessservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Menus")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "dateOfRecipe")
    private Date dateOfRecipe;
    /*
     @Column(name = "fecha_publicacion",length = 40, nullable = false)
    private String fechaPublicacion;
     */


}
