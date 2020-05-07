package com.stockers.stockers.user.service;

//Definicion de los servicios de usuario

import com.stockers.stockers.user.domain.User;
import com.stockers.stockers.user.dto.UserDto;

import java.util.List;


public interface UserService {

    User create(User user);

    User update(User user);

    void delete(User user);

    User findById(Integer userId);

    List<User> findAll();

}
