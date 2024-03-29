package com.spring.security.services;

import com.spring.security.services.models.dtos.LoginDTO;
import com.spring.security.persistence.entities.User;
import com.spring.security.services.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String, String> login(LoginDTO loginRequest) throws Exception;
    public ResponseDTO register(User user) throws Exception;
}
