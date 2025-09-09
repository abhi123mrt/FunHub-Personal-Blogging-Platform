package com.abhinav.FunHub.Service;

import com.abhinav.FunHub.Model.AddVlogs;
import com.abhinav.FunHub.Repository.Addvlogs_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class Addvlogs_Service {
    @Autowired
    private Addvlogs_repo addvlogs_repo;
    public void createvlog(String title,String vlogs, String username) {
        AddVlogs vlog = new AddVlogs(title,vlogs, username);
        addvlogs_repo.save(vlog);
    }

    public List<AddVlogs> getVlogsByUser(String username) {
        return addvlogs_repo.findByUsernameContainingIgnoreCase(username);
    }

    public List<AddVlogs> getAllVlogs() {
        return addvlogs_repo.findAll();
    }


    public List<AddVlogs> searchVlogs(String query) {
        List<AddVlogs> results = new ArrayList<>();

        // Search by Title
        results.addAll(addvlogs_repo.findByTitleContainingIgnoreCase(query));

        // Search by Username
        results.addAll(addvlogs_repo.findByUsernameContainingIgnoreCase(query));

        return results;
    }
}
