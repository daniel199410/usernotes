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
            "Daniel",
            "123",
            Arrays.asList(
                new Note("nota1", "Lorem ipsum"),
                new Note("nota2", "Lorem ipsum")
            )
        );
        User daniela = new User(
            "zorina",
            "Daniela",
            "123",
            Arrays.asList(
            new Note("nota3", "Lorem ipsum"),
            new Note("nota4", "Lorem ipsum")
            )
        );
        this.userRepository.deleteAll();
        List<User> users = Arrays.asList(daniel, daniela);
        this.userRepository.save(users);
    }
}
