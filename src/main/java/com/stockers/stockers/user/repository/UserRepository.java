package com.stockers.stockers.user.repository;

//Interfaz que define operaciones en base de datos

import com.stockers.stockers.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


    User findByUserId(Integer userId);



}
