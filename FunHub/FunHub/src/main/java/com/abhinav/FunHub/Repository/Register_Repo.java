package com.abhinav.FunHub.Repository;

import com.abhinav.FunHub.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Register_Repo extends JpaRepository<Register,Integer> {
    boolean existsByEmail(String email);
    Register findByEmail(String email);
}
