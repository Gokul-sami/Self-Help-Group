package com.self_help_group.self_help_group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.self_help_group.self_help_group.domain.Login;
import com.self_help_group.self_help_group.service.LoginService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    private LoginService serv;
    @GetMapping("/")
    public String showLoginPage(@RequestParam String param) {
        return "login";
    }
    @GetMapping("/login")
    public String getMethodName(@RequestParam String username, @RequestParam String password, Model model) {
        Login user = serv.log(username, password);
        if(user != null){
            // model.addAttribute(attributeName:'message', attributeValue:'Login Successful');
            return "redirect:home";
        }
        else{
            // model.addAttribute(attributeName:'error', attributeValue:'Login Failed');
            return "redirect:login";
        }
    }
}
