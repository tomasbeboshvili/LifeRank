package com.example.liferank;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
	@PostMapping("/users")
	public void createUser(int age, String name){
		UserDao userDao = new UserDao();
		userDao.createUserDao(name, age);
	}

	public void getAllUsers(){
		UserDao userDao = new UserDao();
		userDao.getAllUsers();
	}
}
