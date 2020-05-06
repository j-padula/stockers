package com.stockers.stockers.user.domain;

import com.stockers.stockers.purchase.domain.Purchase;
import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchase;
    public User(){

    }



}
