package com.upc.homemade.communicationservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String text;

    @Column(name = "date_of_message")
    private Date date = new Date();

    private String file;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "chat_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    //private Chat chat;
}