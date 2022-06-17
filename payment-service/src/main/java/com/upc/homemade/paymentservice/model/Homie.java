package com.upc.homemade.paymentservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Homie {
    private Long Id;
    private String name;
    private String surname;
    private Long dni;
    private Long phone;
    private String email;
}
