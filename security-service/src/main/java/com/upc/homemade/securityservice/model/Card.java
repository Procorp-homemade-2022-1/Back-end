package com.upc.homemade.securityservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    private Long Id;
    private Long number;
    private String ccv;
    private String expiration;
    private String owner;
    private Long homieId;
}
