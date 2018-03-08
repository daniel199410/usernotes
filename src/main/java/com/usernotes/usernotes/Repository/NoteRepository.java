package com.usernotes.usernotes.Repository;

import java.util.List;

import com.usernotes.usernotes.Domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NoteRepository extends MongoRepository<Note, String> {

    @Query( "{'username': ?0, 'title': ?1 }")
    public Note findByUsernameTitle(String username, String title);

    public List<Note> findByUsername(String username);

}
