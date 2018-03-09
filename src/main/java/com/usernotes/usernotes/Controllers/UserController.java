package com.usernotes.usernotes.Controllers;

import com.usernotes.usernotes.Domain.User;
import com.usernotes.usernotes.service.NoteService;
import com.usernotes.usernotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
final class UserController {

    @Autowired
    private final UserService service;

    @Autowired
    private final NoteService noteService;

    @Autowired
    UserController(UserService service, NoteService noteService) {
        this.service = service;
        this.noteService = noteService;
    }

    @PostMapping()
    String create(@RequestBody @Valid User UserEntry) {
        if(service.findUserByUsername(UserEntry.getUsername()) != null)
            throw new IllegalArgumentException("The user already exists");
        return service.create(UserEntry).toString();
    }

    @DeleteMapping("/{username}")
    String delete(@PathVariable("username") String username) throws IllegalArgumentException{
        try{
            noteService.deleteByUsername(username);
            return service.delete(username).toString();
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("User not found");
        }
    }

    @GetMapping()
    List<User> getAll() {
        return service.readAll();
    }

    @GetMapping("/{userName}")
    String getUserByUsername(@PathVariable("username") String username) {
        return service.findUserByUsername(username).toString();
    }

    @PatchMapping()
    String updatePassword(@RequestBody @Valid User user) throws NullPointerException {
        try{
            return service.updatePassword(user.getUsername(), user.getPassword()).toString();
        }catch(NullPointerException ex){
            throw new IllegalArgumentException("User not found");
        }
    }
}