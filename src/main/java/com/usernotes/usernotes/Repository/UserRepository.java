package com.usernotes.usernotes.Repository;

import com.usernotes.usernotes.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    User findById(String id);
}
