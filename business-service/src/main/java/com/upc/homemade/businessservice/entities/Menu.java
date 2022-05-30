package com.upc.homemade.businessservice.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "menusIncluded")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Recipe> recipesIncluded = new HashSet<>();

}
