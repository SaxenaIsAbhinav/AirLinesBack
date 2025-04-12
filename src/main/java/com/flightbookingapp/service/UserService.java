package com.flightbookingapp.service;

// UserService.java

import com.flightbookingapp.entity.User;
import com.flightbookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() &&  password.equals( user.get().getPassword())) {
            return user;
        }
        return user;
    }
}