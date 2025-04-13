package com.example.liferank.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String passwordHash;

    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    // Default constructor (required for JPA)
    public User() {}

    // Constructor with parameters
    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registrationDate = LocalDateTime.now(); // Sets the registration date at the moment of creation
    }
}
