package com.self_help_group.self_help_group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.self_help_group.self_help_group.domain.Resolution;
import com.self_help_group.self_help_group.domain.Login;
import com.self_help_group.self_help_group.service.LoginService;
import com.self_help_group.self_help_group.service.ResolutionService;

import jakarta.servlet.http.Cookie;

@Controller
public class LoginController {
    @Autowired
    private LoginService serv;
    @Autowired
    private ResolutionService servres;
    private Login user = new Login();

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String getHomePage(@RequestParam String username, @RequestParam String password, Model model, jakarta.servlet.http.HttpServletResponse response) {
        Login user = serv.log(username, password);
        if (user != null) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/home";
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
    public String handleSignUp(@RequestParam String username, @RequestParam String password, Model model, jakarta.servlet.http.HttpServletResponse response) {
        if (serv.isUserExists(username)) { 
            model.addAttribute("alertMessage", "User already exists. Please log in.");
            return "signUp"; 
        } else {
            serv.save(username, password);
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(12 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/home"; 
        }
    }

    @GetMapping("/home")
    public String getHomePage(Model model, jakarta.servlet.http.HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    model.addAttribute("username", cookie.getValue());
                    break;
                }
            }
        }
        else{
            model.addAttribute("error", "No cookies found.");
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model, jakarta.servlet.http.HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = cookies[7].getValue();
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("/notifications")
    public String getNotifications() {
        return "notifications"; 
    }

    @GetMapping("/ledger")
    public String getLedger() {
        return "ledger"; 
    }

    @GetMapping("/resolution")
    public String getResolution(Model model, jakarta.servlet.http.HttpServletRequest request) {
        List<?> resolutions = servres.getAllResolutions();
        model.addAttribute("resolutions", resolutions);
        return "resolution"; 
    }

    @PostMapping("/resolution")
    public String addResolution(@RequestBody Resolution resolutionData, Model model) {
        System.out.println("Received Resolution: " + resolutionData);

        Resolution resObj = (Resolution) servres.addResolution(
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getRes_name(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getDescription(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getRes_date(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getRes_start_time(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getRes_end_time(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getResTopics(),
            ((com.self_help_group.self_help_group.domain.Resolution) resolutionData).getResMembers()
        );

        model.addAttribute("resolution", resObj);
        System.out.println("Resolution added successfully!");
        return "resolution";
    }

    @GetMapping("/monthly-savings")
    public String getMonthySavings() {
        return "monthly-savings"; 
    }

    @GetMapping("/monthly-details")
    public String getMonthlyDetails() {
        return "monthly-details"; 
    }

    @GetMapping("/logout")
    public String getLogoutPage() {
        return "login"; 
    }
}
