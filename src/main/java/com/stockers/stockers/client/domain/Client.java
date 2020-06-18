package com.stockers.stockers.client.domain;

import com.stockers.stockers.purchase.domain.Purchase;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer clientId = null;
    private String name;
    private String businessName;
    private String vatDeparture;
    private String address;
    private String postalCode;
    private String telephoneNumber;
    private String contactName;
    private String email;
    private String country;



    public Client(){

    }

}
