package com.usernotes.usernotes.Controllers;

import com.usernotes.usernotes.Domain.Note;
import com.usernotes.usernotes.Domain.User;
import com.usernotes.usernotes.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        List<User> hotels = this.userRepository.findAll();
        return hotels;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id){
        User user = this.userRepository.findById(id);
        return user;
    }

    @GetMapping("/{id}/notes")
    public List<Note> getNotes(@PathVariable("id") String id){
        List<Note> notes = this.userRepository.findById(id).getNotes();
        return notes;
    }
}
