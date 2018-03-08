package com.usernotes.usernotes.service;

import com.usernotes.usernotes.Domain.Note;
import com.usernotes.usernotes.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteService(NoteRepository dataBase){
        this.noteRepository = dataBase;
    }

    public Note create(Note note){
        noteRepository.save(note);
        return note;
    }

    public Note delete(String username, String title){
        Note deleted = findNoteByUsernameTitle(username, title);
        noteRepository.delete(deleted);
        return deleted;
    }

    public Note read(String username, String title){
        return noteRepository.findByUsernameTitle(username, title);
    }

    public List<Note> getAll(String username){
        return noteRepository.findByUsername(username);
    }

    public Note update(Note note){
        Note foundNote = findNoteByUsernameTitle(note.getUsername(), note.getTitle());
        foundNote.update(note);
        foundNote = noteRepository.save(foundNote);
        return foundNote;
    }

    public void deleteByUsername(String username){
        for (Note note : noteRepository.findByUsername(username)){
            noteRepository.delete(note);
        }
    }

    public void deleteAll(){
        noteRepository.deleteAll();
    }

    public Note findNoteByUsernameTitle(String username, String title){
        Note result = noteRepository.findByUsernameTitle(username, title);
        return result;
    }
}
