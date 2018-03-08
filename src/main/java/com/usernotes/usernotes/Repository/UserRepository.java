package com.usernotes.usernotes.Repository;

import com.usernotes.usernotes.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    User findById(String id);
    public User findByUsername(String username);
}
