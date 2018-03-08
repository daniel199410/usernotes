package com.usernotes.usernotes.service;

import com.usernotes.usernotes.Domain.User;
import com.usernotes.usernotes.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User delete(String username){
        User deleted = findUserByUsername(username);
        userRepository.delete(deleted);
        return deleted;
    }

    public User read(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> readAll(){
        return userRepository.findAll();
    }

    public User updatePassword(String username, String password){
        User user = findUserByUsername(username);
        user.setPassword(password);
        user = userRepository.save(user);
        return user;
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public User findUserByUsername(String username){
        User result = userRepository.findByUsername(username);
        return result;
    }

}