package com.flightbookingapp.service;

// UserService.java

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.User;
import com.flightbookingapp.repository.PassengerDetailRepository;
import com.flightbookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerDetailRepository passengerDetailRepository;

    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public PassengerDetails authenticateUser(String emailId, String password) {
        PassengerDetails user = passengerDetailRepository.findByEmailId(emailId);
        if (null != user &&  password.equals( user.getPassword())) {
            return user;
        }
        return null;
    }
}