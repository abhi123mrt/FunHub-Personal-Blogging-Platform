package com.abhinav.FunHub.Service;

import com.abhinav.FunHub.Model.Register;
import com.abhinav.FunHub.Repository.Register_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Register_Service {
    @Autowired
    private Register_Repo register_repo;
        public String AddDetails(Register register) {
            if (register_repo.existsByEmail(register.getEmail())) {
                return "Email already registered!";
            }
            register_repo.save(register);
            return "Registration successful!";
        }
}
