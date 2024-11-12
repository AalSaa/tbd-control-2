package com.example.backend.services;

import com.example.backend.dtos.LoginDTO;
import com.example.backend.entities.UserEntity;
import com.example.backend.jwt.JwtUtil;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public String login(LoginDTO loginDTO) {
        UserEntity clientEntity = userRepository.findByName(loginDTO.getName());
        if (clientEntity == null) {
            throw new IllegalStateException("The name or password is incorrect");
        }
        if (!loginDTO.getPassword().equals(clientEntity.getPassword())) {
            throw new IllegalStateException("The email or password is incorrect");
        }

        return JwtUtil.createToken(loginDTO.getName());

    }
}
