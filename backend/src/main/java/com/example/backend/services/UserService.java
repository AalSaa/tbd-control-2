package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import com.example.backend.exceptions.EntityNotFoundException;
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
       UserEntity user = userRepository.findById(id);
       if (user == null) {
           throw new EntityNotFoundException("User not found");
       }

       return user;
    }

    public UserEntity saveUser(UserEntity user) {
        UserEntity existingUser = userRepository.findByName(user.getName());
        if (existingUser != null) {
            throw new IllegalStateException("User already exists");
        }

        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user) {
        UserEntity possibleUser = userRepository.findById(user.getId());
        if (possibleUser == null) {
            throw new EntityNotFoundException("User not found");
        }
        UserEntity existingUser = userRepository.findByNameAndNotId(user.getName(), user.getId());
        if (existingUser != null) {
            throw new IllegalStateException("User already exists");
        }

        return userRepository.update(user);
    }

    public boolean deleteUserById(int id) {
        UserEntity possibleUser = userRepository.findById(id);
        if (possibleUser == null) {
            throw new EntityNotFoundException("User not found");
        }

        return userRepository.delete(id);
    }
}
