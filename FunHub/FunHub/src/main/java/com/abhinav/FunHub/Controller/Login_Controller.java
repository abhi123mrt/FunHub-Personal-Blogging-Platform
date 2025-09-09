package com.abhinav.FunHub.Controller;

import com.abhinav.FunHub.Service.Login_Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")

public class Login_Controller {
    @Autowired
    Login_Service login_service;

    @GetMapping
    public String showLoginpage() {
        return "login";
    }
    //add data

    @PostMapping

    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {

        String username = login_service.validateUser(email, password);
        if (username != null) {
            // Successful login
            // ✅ store username & email in session
            session.setAttribute("username", username);
            session.setAttribute("email", email);
            return "redirect:/profile";
        } else {
            // Login failed
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }
}
