package com.stockers.stockers.user.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "Client")
@NamedQuery(name = "Client.findById", query = "Select c from Client c where c.clientId=?1")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer clientId = null;
    private String name;
    private String businessName;
    private String vatDeparture;
    private String address;
    private String telephoneNumber;
    private String contactName;
    private String email;
    private String country;
    private ArrayList<String> clients;


}
