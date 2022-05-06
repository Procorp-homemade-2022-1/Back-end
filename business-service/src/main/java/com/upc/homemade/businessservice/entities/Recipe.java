package com.upc.homemade.businessservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Menu menu;

}
