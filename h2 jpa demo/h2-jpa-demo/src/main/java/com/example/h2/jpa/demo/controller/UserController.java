package com.example.h2.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.jpa.demo.entity.User;
import com.example.h2.jpa.demo.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
    @Autowired 
    private UserService user_service; 

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        return user_service.createUser(user);
    }
    
    
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return user_service.createUsers(users);
	}

    @GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return user_service.getUserById(id);
	}

    @GetMapping("/users")
	public List<User> getAllUsers() {
		return user_service.getAllUsers();
	}
    @PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return user_service.updateUser(user);
	}
    @DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return user_service.deleteUserById(id);
	}

}
 