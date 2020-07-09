package com.scoreboard.BoardAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoreboard.BoardAPI.Service.UserService;
import com.scoreboard.BoardAPI.entity.users;

@RestController
@RequestMapping("API")
public class UserController {
	@Autowired
	public UserService userservice;
	@GetMapping("/users")
	public List<users> getUsers() {
		return userservice.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public users getUserById(@PathVariable int id ){
		return userservice.getUsersById(id);
	}
	
	@GetMapping("/users/Admin/{id}")
	public users makeadmin(@PathVariable int id) {
		users user=userservice.makeadmin(id);
		return user;
	}
	
	@GetMapping("/users/RAdmin/{id}")
	public users removeadmin(@PathVariable int id) {
		users user=userservice.removeadmin(id);
		return user;
	}
}
