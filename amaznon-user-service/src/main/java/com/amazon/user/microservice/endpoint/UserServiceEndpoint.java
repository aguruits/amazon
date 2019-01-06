package com.amazon.user.microservice.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.user.microservice.model.User;
import com.amazon.user.microservice.service.UserService;

@RestController
public class UserServiceEndpoint {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/getUserList")
	public List<User> getUserList() {
		return userService.getUserList();
	}
	
	@PostMapping("/getUserforAuthenticate")
	public User getUserforAuthenticate(@RequestBody User user) {
		return userService.getUserforAuthenticate(user);
	}

	@PostMapping("/getUser")
	public User getUser(@RequestBody User user) {
		return userService.getUser(user);
	}
	
	@PostMapping("/addUser")
	public int addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/updateUser")
	public int updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
}
