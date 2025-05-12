package com.example.demohttps.student;

import java.time.LocalDate;

public class student {
    private long id; 
    private String name; 
    private String email; 
    private LocalDate dob; 
    private Integer age; 

    // Default constructor
    public student() {
    }

    // Constructor with all fields
    public student(long id, String name, String email, LocalDate dob, Integer age) {
        this.id = id; 
        this.name = name; 
        this.email = email; 
        this.dob = dob; 
        this.age = age; 
    }

    // Constructor without 'id'
    public student(String name, String email, LocalDate dob, Integer age) {
        this.name = name; 
        this.email = email; 
        this.dob = dob; 
        this.age = age; 
    }

    // Getter for 'id'
    public long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(long id) {
        this.id = id;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'email'
    public String getEmail() {
        return email;
    }

    // Setter for 'email'
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for 'dob' (Date of Birth)
    public LocalDate getDob() {
        return dob;
    }

    // Setter for 'dob'
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Getter for 'age'
    public Integer getAge() {
        return age;
    }

    // Setter for 'age'
    public void setAge(Integer age) {
        this.age = age;
    }
}

