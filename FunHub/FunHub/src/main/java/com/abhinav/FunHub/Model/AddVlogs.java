package com.abhinav.FunHub.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddVlogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String vlogs;
    private String username;

    public AddVlogs(){

    }

    public AddVlogs(String title,String vlogs, String username) {
        this.title = title;
        this.vlogs = vlogs;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVlogs() {
        return vlogs;
    }

    public void setVlogs(String vlogs) {
        this.vlogs = vlogs;
    }

    @Override
    public String toString() {
        return "AddVlogs{" +
                "title='" + title + '\'' +
                ", vlogs='" + vlogs + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
