package com.stockers.stockers.user.service.impl;

import com.stockers.stockers.user.domain.User;
import com.stockers.stockers.user.repository.UserRepository;
import com.stockers.stockers.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Metodo para guardar usuario en db

    @Transactional
    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    //Metodo para actualizar usuario

    @Transactional
    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    @Override
    public int updatePassword(User user){
        int modify = this.userRepository.updatePassword(user.getPassword(), user.getUserId());
        return modify;
    }

    //Metodo para eliminar usuario
    @Transactional
    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    //Metodo para consultar usuario
    @Transactional
    @Override
    public User findById(Integer userId) {
        return this.userRepository.findByUserId(userId);

    }

    @Transactional
    @Override
    public List<User> findAll() {
        List<User> users = this.userRepository.findAll();
        return users;
    }
}
