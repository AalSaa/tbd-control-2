package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(int id) {
        return userRepository.findById(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.update(user);
    }

    public boolean deleteUserById(int id) {
        return userRepository.delete(id);
    }
}
