package com.self_help_group.self_help_group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.self_help_group.self_help_group.domain.Login;
import com.self_help_group.self_help_group.service.LoginService;
// import com.self_help_group.self_help_group.service.RegisterUser;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService serv;
    @Autowired
    // private RegisterUser reg;
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String getHomePage(@RequestParam String username, @RequestParam String password, Model model) {
        Login user = serv.log(username, password);
        if(user != null){
            // model.addAttribute(attributeName:'message', attributeValue:'Login Successful');
            return "home";
        }
        else{
            // model.addAttribute(attributeName:'error', attributeValue:'Login Failed');
            return "redirect:/login";
        }
    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/SignUp")
    public String getHomePageFromSingUp() {
        return "signUp";
    }
    @PostMapping("/SignUp")
    public String getHomePageFromSignUp(@RequestParam String username, @RequestParam String password, Model model) {
        // Login user = reg.save(username, password);
        // if(user != null){
        //     // model.addAttribute(attributeName:'message', attributeValue:'Login Successful');
        //     return "home";
        // }
        // else{
        //     // model.addAttribute(attributeName:'error', attributeValue:'Login Failed');
        //     return "redirect:/login";
        // }
        return "home";
    }
}
