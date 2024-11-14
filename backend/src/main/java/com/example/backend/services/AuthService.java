package com.example.backend.services;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.dtos.LoginDTO;
import com.example.backend.entities.UserEntity;
import com.example.backend.jwt.JwtUtil;
import com.example.backend.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
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

    public UserEntity register(UserEntity user) {
        UserEntity existingUser = userRepository.findByName(user.getName());
        if (existingUser != null) {
            throw new IllegalStateException("User already exists");
        }

        return userRepository.save(user);
    }

    public void verifyToken(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JWT")) {
                    try {
                        String token = cookie.getValue();
                        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
                        return;
                    } catch (JWTVerificationException e) {
                        throw new IllegalStateException("Invalid JWT");
                    }
                }
            }
            throw new IllegalStateException("JWT not found");
        }
        throw new IllegalStateException("Cookies not found");
    }
}
