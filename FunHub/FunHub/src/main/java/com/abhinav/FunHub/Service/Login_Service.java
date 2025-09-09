package com.abhinav.FunHub.Service;

import com.abhinav.FunHub.Model.Register;
import com.abhinav.FunHub.Repository.Register_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_Service {
   @Autowired
    Register_Repo register_repo;

    public String validateUser(String email, String password) {
        Register user = register_repo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user.getUsername();
        }
        return null;
    }
}
