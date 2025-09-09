package com.abhinav.FunHub.Controller;

import com.abhinav.FunHub.Config.CustomUserDetails;
import com.abhinav.FunHub.Model.Profile;
import com.abhinav.FunHub.Model.AddVlogs;
import com.abhinav.FunHub.Service.Addvlogs_Service;

import com.abhinav.FunHub.Service.Profile_Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class Profile_Controller {

    @Autowired
    private Profile_Service profileService;

    @Autowired
    private Addvlogs_Service addvlogs_service;
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // clears all session attributes
        return "redirect:/login";
    }

@GetMapping("/profile")
public String profilePage( Model model, Authentication authentication) {
    if (authentication == null || !authentication.isAuthenticated()) {
        return "redirect:/login"; // force login first
    }
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    String username = userDetails.getFullUsername();



    Profile profile = profileService.getProfile(username);
    List<AddVlogs> userVlogs = addvlogs_service.getVlogsByUser(username);

    model.addAttribute("username", username);
    model.addAttribute("bio", profile.getBio());
    model.addAttribute("profileImage", profile.getProfileImage());
    model.addAttribute("userVlogs", userVlogs);
    model.addAttribute("vlogsCount", userVlogs.size());

    return "profile";
}

    @PostMapping("/profile/updateBio")
    public String updateBio(@RequestParam String username, @RequestParam String bio) {
        profileService.updateBio(username, bio);
        return "redirect:/profile?username=" + username;
    }


}
