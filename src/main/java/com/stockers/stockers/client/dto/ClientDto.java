package com.stockers.stockers.client.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ClientDto {

    private Integer clientId;
    private String name;
    private String businessName;
    private String vatDeparture;
    private String address;
    private String postalCode;
    private String telephoneNumber;
    private String contactName;
    private String email;
    private String country;

}
