package com.amazon.ui.user.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.ui.user.model.User;
import com.amazon.ui.user.service.UserContract;

@Controller
public class UserController {
	
	@Autowired
	private UserContract userContract;
	

	@RequestMapping("/getUserList")
	public ModelAndView getUserList() {
		List<User> userList = userContract.getUserList();
		
		ModelAndView mav = new ModelAndView("/user/userList");
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/getUserforAuthenticate/{userId}")
	public ModelAndView getUserforAuthenticate(@PathVariable("userId") String userId) {
		User user = new User();
		user.setUserId(userId);		
		
		user = userContract.getUserforAuthenticate(user);
		
		ModelAndView mav = new ModelAndView("/user/userList");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping("/getUser")
	public ModelAndView getUser(@QueryParam("userId") String userId) {
		User user = new User();
		user.setUserId(userId);		
		
		user = userContract.getUser(user);
		
		ModelAndView mav = new ModelAndView("/user/ViewandEditUser");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/addUserSetup")
	public ModelAndView addUserSetup() {
		ModelAndView mav = new ModelAndView("/user/addUser");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		userContract.addUser(user);
		List<User> userList = userContract.getUserList();
		
		ModelAndView mav = new ModelAndView("/user/userList");
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(User user) {
		userContract.updateUser(user);
		
		User userDB = userContract.getUser(user);
		
		ModelAndView mav = new ModelAndView("/user/ViewandEditUser");
		mav.addObject("recordUpdateFlag", "true");
		mav.addObject("user", userDB);
		return mav;
	}
	
	
}
