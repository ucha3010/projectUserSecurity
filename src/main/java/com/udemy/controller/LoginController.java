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
		LOG.info("Salida método showLoginForm - model: " + model);
		return ViewConstant.LOGIN;
	}
	
//	@GetMapping({"/loginsuccess", "/"})
	@GetMapping("/loginsuccess")
	public String showLoginSuccess() {
		LOG.info("Entrada método showLoginSuccess");
		LOG.info("Salida método showLoginSuccess");
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/")
	public String showEntradaPrincipal() {
		LOG.info("Entrada método showEntradaPrincipal");
		LOG.info("Salida método showEntradaPrincipal");
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/logout")
	public String showLogoutForm(Model model,
			@RequestParam(name = "error", required=false) String error,
			@RequestParam(name = "logout", required=false) String logout) {
		LOG.info("Entrada método showLogoutForm");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Salida método showLogoutForm");
		return ViewConstant.LOGOUT;
	}

}
