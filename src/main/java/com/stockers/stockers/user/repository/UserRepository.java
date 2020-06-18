package com.stockers.stockers.user.repository;

//Interfaz que define operaciones en base de datos

import com.stockers.stockers.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {


    User findByUserId(Integer userId);

    @Query("UPDATE User u SET u.password = :password WHERE u.userId = :userId")
    @Modifying
    void updatePassword(@Param("password") String password,@Param("userId") Integer userId);


}
