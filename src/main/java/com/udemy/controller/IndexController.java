package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String showIndex() {
		return "redirect:/user/listusers";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

}
