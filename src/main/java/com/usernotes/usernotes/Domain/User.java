package com.usernotes.usernotes.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class User {
    @Id
    private String id;
    @Indexed
    private String username;
    private String name;
    private String password;
    private List<Note> notes;

    public User(String username, String name, String password, List<Note> notes) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
