package com.amazon.ui.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.ui.user.model.User;
import com.amazon.ui.user.service.UserContract;

@Controller
public class LoginController {
	
	@Autowired
	private UserContract userContract;
	
	@RequestMapping("/login")
	public ModelAndView setLogin() {
		ModelAndView mav = new ModelAndView("/login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping("/loginAuthenticate")
	public ModelAndView loginAuthenticate(HttpServletRequest request, User user) {
		ModelAndView mav = null;
		
		User authenticateUser = userContract.getUserforAuthenticate(user);
		
		Boolean isUserAthenticated = authenticateUser.getIsUserAthenticated();
		if(isUserAthenticated) {
			mav = new ModelAndView("/home");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", authenticateUser);
			return mav;
		} else {
			mav = new ModelAndView("/login");
			mav.addObject("invalidUserFlag", "true");
			return mav;			
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView("/login");
		mav.addObject("user", new User());
		return mav;
	}
	
}
