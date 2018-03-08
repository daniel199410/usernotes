package com.usernotes.usernotes.TestData;

import com.usernotes.usernotes.Domain.Note;
import com.usernotes.usernotes.Domain.User;
import com.usernotes.usernotes.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner{
    private UserRepository userRepository;

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        User daniel = new User(
            "zorin",
            "123"
        );
        User daniela = new User(
            "zorina",
            "123"
        );
        this.userRepository.deleteAll();
        List<User> users = Arrays.asList(daniel, daniela);
        this.userRepository.save(users);

    }
}
