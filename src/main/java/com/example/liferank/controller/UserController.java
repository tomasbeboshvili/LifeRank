package com.example.liferank.controller;

import com.example.liferank.model.User;
import com.example.liferank.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")    
public class UserController {

    private final UserRepository userRepository;

	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
}
