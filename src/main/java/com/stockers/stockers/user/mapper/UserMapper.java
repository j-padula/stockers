package com.stockers.stockers.user.mapper;

import com.stockers.stockers.user.domain.User;
import com.stockers.stockers.user.dto.PasswordDto;
import com.stockers.stockers.user.dto.UserDto;

public class UserMapper {
    public static UserDto modelToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
    public static User dtoToModel(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRoles(userDto.getRoles());
        return user;
    }
    public static User  passwordToUser (Integer userId, PasswordDto passwordDto){
        User user = new User();
        user.setUserId(userId);
        user.setPassword(passwordDto.getPassword());
        return user;
    }
}
