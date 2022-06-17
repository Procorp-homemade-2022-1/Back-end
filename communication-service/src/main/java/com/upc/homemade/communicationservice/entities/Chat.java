package com.upc.homemade.communicationservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upc.homemade.communicationservice.model.Chef;
import com.upc.homemade.communicationservice.model.Homie;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chats")
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateOfChat")
    private Date date = new Date();

    @Column(name = "chefId")
    private long chefId;
    @Column(name = "homieId")
    private long homieId;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private List<Message> Messages = new ArrayList<>();


    @Transient
    private Homie homie;
    @Transient
    private Chef chef;

}
