package com.flightbookingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "mobileNumber")
    private long mobileNumber;

    public User() {
    }

    public User(Integer userId, String username, String emailId, String fullName, String password, int age, long mobileNumber) {
        this.userId = userId;
        this.username = username;
        this.emailId = emailId;
        this.fullName = fullName;
        this.password = password;
        this.age = age;
        this.mobileNumber = mobileNumber;
    }

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}



