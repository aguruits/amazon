package com.amazon.ui.user.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazon.ui.user.model.User;

@FeignClient(name="USER")
public interface UserContract {
	
	@PostMapping("/getUserList")
	public List<User> getUserList();
	
	@PostMapping("/getUserforAuthenticate")
	public User getUserforAuthenticate(@RequestBody User user);

	@PostMapping("/getUser")
	public User getUser(@RequestBody User user);
	
	@PostMapping("/addUser")
	public int addUser(@RequestBody User user);
	
	@PostMapping("/updateUser")
	public int updateUser(@RequestBody User user);
	
}
