package com.spring.security.services.impl;

import com.spring.security.persistence.DTO.userDTO;
import com.spring.security.persistence.entities.User;
import com.spring.security.persistence.repositories.UserRepository;
import com.spring.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAllUsers(){

        return userRepository.findAll();
    }


    @Override
    public Optional<User> newUser(userDTO userdto) {
         User user = new User();
         user.setFirstName(userdto.getFirstname());
         user.setLastName(userdto.getLastname());
         user.setPhone(userdto.getPhone());
         user.setEmail(userdto.getEmail());
         user.setPassword(userdto.getPassword());
         return Optional.of(userRepository.save(user));
    }
}
