package com.spring.security.controllers;

import com.spring.security.persistence.DTO.userDTO;
import com.spring.security.persistence.entities.User;
import com.spring.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/all")
    private ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createUser(@RequestBody userDTO userRegistration) {
        Optional<User> newUser = userService.newUser(userRegistration);

        if (newUser.isPresent()) {
            return new ResponseEntity<>(newUser.get(), HttpStatus.CREATED);
        } else {
            // Puedes manejar el caso en el que no se pudo crear el usuario
            return new ResponseEntity<>("No se pudo crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
