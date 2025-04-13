package com.example.liferank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.liferank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom methods can be defined here if needed.
    // Example: Find user by email
    User findByEmail(String email);

    // Example: Find user by username
    User findByUsername(String username);
}
