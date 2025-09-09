package com.abhinav.FunHub.Service;

import com.abhinav.FunHub.Config.CustomUserDetails;
import com.abhinav.FunHub.Model.Register;
import com.abhinav.FunHub.Repository.Register_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    Register_Repo register_repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Register user =register_repo .findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new CustomUserDetails(user);
    }
}
