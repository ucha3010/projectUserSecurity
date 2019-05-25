package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required=false) String error,
			@RequestParam(name = "logout", required=false) String logout) {
		LOG.info("Entrada método showLoginForm");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Salida método showLoginForm");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String showLoginCheck() {
		LOG.info("Entrada método showLoginForm");
		LOG.info("Salida método showLoginForm");
		return "redirect:/contacts/showcontacts";
	}

}
