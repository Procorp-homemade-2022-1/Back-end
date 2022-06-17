package com.upc.homemade.communicationservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chef {
    private Long Id;
    private String name;
    private String surname;
    private Integer age;
    private Long dni;
    private Long phone;
    private String address;
    private String email;
    private String file;
}
