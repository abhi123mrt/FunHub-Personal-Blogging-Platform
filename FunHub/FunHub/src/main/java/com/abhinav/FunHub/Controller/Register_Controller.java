package com.abhinav.FunHub.Controller;

import com.abhinav.FunHub.Model.Register;
import com.abhinav.FunHub.Service.Register_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("register")
public class Register_Controller {
    @Autowired
    private Register_Service register_service;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }
    @PostMapping("/add")
    public String CreateUserDetail(@RequestParam("username") String username,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model) {

        Register register = new Register();
        register.setUsername(username);
        register.setEmail(email);
        register.setPassword(password);

        String message = register_service.AddDetails(register);

        if (message.equals("Email already registered!")) {
            model.addAttribute("message", message);
            return "register"; // stay on register.html
        }


        return "redirect:/login?registered=true";
    }
}
