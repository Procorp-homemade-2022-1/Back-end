package com.upc.homemade.communicationservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upc.homemade.communicationservice.model.Chef;
import lombok.Data;


import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publications")
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chefId")
    private long chefId;

    @Column(name = "dateOfPublication")
    private Date date = new Date();

    @Column(length = 50, nullable = false)
    private String text;

    @Column(name = "likes")
    private Integer likes;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private Chef chef;

}