package com.self_help_group.self_help_group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.self_help_group.self_help_group.domain.Login;
import com.self_help_group.self_help_group.service.LoginService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService serv;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String getHomePage(@RequestParam String username, @RequestParam String password, Model model) {
        Login user = serv.log(username, password);
        if (user != null) {
            return "home";
        } else {
            model.addAttribute("error", "Login Failed");
            return "login";
        }
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/SignUp")
    public String getSignUpPage() {
        return "signUp";
    }

        @PostMapping("/SignUp")
    public String handleSignUp(@RequestParam String username, @RequestParam String password, Model model) {
        if (serv.findByUsername(username)) { // Check if the user already exists
            model.addAttribute("error", "User already exists. Please log in.");
            return "signUp"; // Return to the sign-up page with an error message
        } else {
            serv.save(username, password); // Save the new user
            model.addAttribute("message", "Sign-up successful! Please log in.");
            return "redirect:/login"; // Redirect to the login page
        }
    }
}
