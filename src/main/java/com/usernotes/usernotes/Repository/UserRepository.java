package com.usernotes.usernotes.Repository;

import com.usernotes.usernotes.Domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Note, String>{
}
