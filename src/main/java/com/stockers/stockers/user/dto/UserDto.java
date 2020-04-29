package com.stockers.stockers.user.dto;


import lombok.Data;

import java.util.ArrayList;

@Data
public class UserDto {
    private Integer userId;
    private String name;
    private String email;
    private String username;
    private String password;
    private ArrayList<String> roles;

}
