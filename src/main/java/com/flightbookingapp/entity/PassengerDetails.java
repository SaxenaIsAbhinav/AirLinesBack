package com.flightbookingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="PassengerDetails")
public class PassengerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;

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





    public String getFullName() {
        return fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }



    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public PassengerDetails() {
    }


}