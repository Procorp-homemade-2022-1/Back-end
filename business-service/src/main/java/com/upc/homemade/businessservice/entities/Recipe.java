package com.upc.homemade.businessservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name="recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title", length = 40, nullable = false)
    private  String title;
    @Column(name = "description", length = 40, nullable = false)
    private  String description;
    @Column(name = "content", length = 400, nullable = false)
    private String content;
    @Column(name = "url_picture", length = 400, nullable = false)
    private String url_picture;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredients_id")
    private List<Ingredients> ingredientsIncluded = new ArrayList<>();
    //@Column(name = "menu_id")
   // private long menuId;


}
