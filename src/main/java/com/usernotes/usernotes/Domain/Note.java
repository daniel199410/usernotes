package com.usernotes.usernotes.Domain;

import com.usernotes.usernotes.Repository.UserRepository;
import com.usernotes.usernotes.service.UserService;
import org.springframework.data.annotation.Id;
import org.springframework.beans.factory.annotation.Autowired;


public class Note {

    @Id
    public String id;

    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private String title;
    private String description;
    private String username;

    public Note() {}

    public Note(String title, String description, String username) {
        this.description = description;
        this.title = title;
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("Note created");
    }

    public String getTitle(){
        return this.title;
    }

    public String getUsername(){
        return this.username;
    }

    public void update(Note note){
        this.description = note.description;
        this.title = note.title;
    }
}