package com.abhinav.FunHub.Repository;

import com.abhinav.FunHub.Model.AddVlogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Addvlogs_repo extends JpaRepository<AddVlogs,Integer> {
    List<AddVlogs> findByTitleContainingIgnoreCase(String title);
    List<AddVlogs> findByUsernameContainingIgnoreCase(String username);

}

