package com.abhinav.FunHub.Controller;

import com.abhinav.FunHub.Model.AddVlogs;
import com.abhinav.FunHub.Service.Addvlogs_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("AddVlogs")
public class Addvlogs_Controlle {
    @Autowired
    private Addvlogs_Service addvlogs_service;

    //page add html
    @GetMapping("/add")
    public String showAddVlogForm(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "addvlogs";
    }


    //logic for create a vlog
    @PostMapping("/create")
    public String addvlogs(@RequestParam String title,@RequestParam String vlogs, @RequestParam String username, Model model){
        addvlogs_service.createvlog(title,vlogs, username);
        model.addAttribute("message", "Vlog added successfully!");
        return "redirect:/profile?username=" + username;
    }

    //seen a vlog

    @GetMapping("/user/{username}")
    public String getUserVlogs(@PathVariable String username, Model model) {
        // Fetch vlogs by user
        List<AddVlogs> vlogs = addvlogs_service.getVlogsByUser(username);

        // Add data to the model
        model.addAttribute("username", username);
        model.addAttribute("vlogs", vlogs);

        return "yourvlogs";
    }

    @GetMapping("/search")
    public String searchVlogs(@RequestParam(value = "query", required = false) String query, Model model) {
        List<AddVlogs> vlogs;

        if (query != null && !query.isEmpty()) {
            vlogs = addvlogs_service.searchVlogs(query);
        } else {
            vlogs = addvlogs_service.getAllVlogs();
        }

        model.addAttribute("vlogs", vlogs);
        model.addAttribute("searchQuery", query);
        return "search-results";
    }


}
