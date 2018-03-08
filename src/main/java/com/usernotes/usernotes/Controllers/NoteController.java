package com.usernotes.usernotes.Controllers;

import com.usernotes.usernotes.Domain.Note;
import com.usernotes.usernotes.service.NoteService;
import com.usernotes.usernotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController{
    private final NoteService noteService;
    private final UserService userService;

    @Autowired
    public NoteController(NoteService noteService, UserService userService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping()
    String add(@RequestBody Note note) {
        if(noteService.findNoteByUsernameTitle(note.getUsername(), note.getTitle()) != null){
            return "Note exists";
        }
        if(userService.findUserByUsername(note.getUsername()) == null){
            return "The user does not exist";
        }
        return noteService.create(note).toString();
    }

    @DeleteMapping("{username}/{title}")
    String delete(@PathVariable("username") String username, @PathVariable("title") String title) {
        return noteService.delete(username, title).toString();
    }

    @GetMapping("/{username}")
    List<Note> getAll(@PathVariable("username") String username) {
        return noteService.getAll(username);
    }

    @GetMapping("note/{username}/{title}")
    String findNoteByUsernameAndTitle(@PathVariable("username") String username, @PathVariable("title") String title) {
        return noteService.findNoteByUsernameTitle(username, title).toString();
    }

    @PatchMapping()
    String update(@RequestBody @Valid Note note) throws NullPointerException {
        try{
            if(userService.findUserByUsername(note.getUsername()) == null){
                return "The user does not exist";
            }
            return noteService.update(note).toString();
        }catch (NullPointerException ex){
            return "The Note does not exist";
        }
    }
}
