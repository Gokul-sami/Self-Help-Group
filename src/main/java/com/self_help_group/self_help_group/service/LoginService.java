package com.self_help_group.self_help_group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_help_group.self_help_group.domain.Login;
import com.self_help_group.self_help_group.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo rep;
    public Login log(String username, String password){
        Login user = rep.findByUsernameAndPassword(username, password);
        return user;
    }
}
