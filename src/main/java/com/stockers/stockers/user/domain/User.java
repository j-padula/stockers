package com.stockers.stockers.user.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stockers.stockers.purchase.domain.Purchase;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer userId = null;
    private String name;
    private String email;
    private String username;
    private String password;
    private ArrayList<String> roles;



    public User(){

    }



}
