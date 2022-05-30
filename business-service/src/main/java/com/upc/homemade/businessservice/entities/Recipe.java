package com.upc.homemade.businessservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "recipe_menu",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Set<Menu> menusIncluded = new HashSet<>();


}
