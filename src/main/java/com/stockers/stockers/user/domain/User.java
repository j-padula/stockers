package com.stockers.stockers.user.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "User")
@NamedQuery(name = "User.findById", query = "Select u from User u where u.userId=?1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer userId = null;
    private String name;
    private String email;
    private String username;
    private String password;
    private ArrayList<String> roles;

}
