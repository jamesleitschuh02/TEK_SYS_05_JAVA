package com.example.Thymeleafproject.entity;

//import javax.persistence.Entity;
//
//@Entity
public class UserEntity {
    // creating our fields
    private String name;
    private String email;
// creating our constructors
    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
// default constructor
    public UserEntity() {
    }
// getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

