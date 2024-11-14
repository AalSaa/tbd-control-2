package com.example.backend.controllers;

import com.example.backend.entities.UserEntity;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<UserEntity> putUser(@RequestBody UserEntity user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("success", userService.deleteUserById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
