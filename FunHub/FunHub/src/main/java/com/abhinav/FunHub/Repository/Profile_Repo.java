package com.abhinav.FunHub.Repository;

import com.abhinav.FunHub.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Profile_Repo extends JpaRepository<Profile,Integer> {
    Profile findByUsername(String username);
}
