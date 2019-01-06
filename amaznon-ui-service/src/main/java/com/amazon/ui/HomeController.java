package com.amazon.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String getInded() {
		return "/index";
	}
	
	@RequestMapping("/home")
	public String getCatalogList() {
		return "/home";
	}
	

}
