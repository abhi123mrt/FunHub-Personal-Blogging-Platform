package com.abhinav.FunHub.Service;

import com.abhinav.FunHub.Model.Profile;

import com.abhinav.FunHub.Repository.Profile_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Profile_Service {

    @Autowired
    private Profile_Repo profileRepository;

    public Profile getProfile(String username) {
        Profile profile = profileRepository.findByUsername(username);
        if(profile == null){
            profile = new Profile(username, "", null);
            profileRepository.save(profile);
        }
        return profile;
    }

    public void updateBio(String username, String bio) {
        Profile profile = getProfile(username);
        profile.setBio(bio);
        profileRepository.save(profile);
    }

}
