package com.spring.security.services;

import com.spring.security.persistence.DTO.userDTO;
import com.spring.security.persistence.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> findAllUsers();

    Optional<User> newUser(userDTO userRegistration);
}
