package com.example.liferank.service;

import com.example.liferank.model.User;
import com.example.liferank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to get a user by their ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to get a user by their email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
