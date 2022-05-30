package com.upc.homemade.businessservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.*;


@Entity
@Table(name = "Menus")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "dateOfRecipe")
    private Date dateOfRecipe;
    /*
     @Column(name = "fecha_publicacion",length = 40, nullable = false)
    private String fechaPublicacion;
     */

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private List<Recipe> recipesIncluded = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.dateOfRecipe = new Date();
    }
}
