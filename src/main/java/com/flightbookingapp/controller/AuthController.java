package com.flightbookingapp.controller;// AuthController.java

import com.flightbookingapp.entity.LoginRequest;
import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.User;
import com.flightbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        String emailId = loginRequest.getEmailId();
String password = loginRequest.getPassword();

        PassengerDetails user = userService.authenticateUser(emailId, password);
        if (null != user) {
            // Generate a fake JWT token for demonstration purposes
            String token = "fake-jwt-token";
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", user);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Invalid emailId or password");
        }
    }
}
