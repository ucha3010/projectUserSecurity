package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.UserModel;
import com.udemy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String USERS_LIST_VIEW = "userslist";
	private static final String USER_FORM_VIEW = "userForm";
	
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/listusers")
	public ModelAndView listAllUsers(@RequestParam(name = "message", required = false) Integer message, ModelAndView mav) {
		LOG.info("Controlador " + "listAllUsers");
		mav.setViewName(USERS_LIST_VIEW);
		mav.addObject("users", userService.listAllUsers());
		if(message != null) {
			mav.addObject("message",message);
		}
		return mav;
	}
	
	@GetMapping("/userform")
	public String userForm(@RequestParam(name = "userId", required = false) int userId, Model model) {
		LOG.info("Controlador " + "userForm");
		UserModel userModel = new UserModel();
		if(userId != 0) {
			userModel = userService.findUserByUserId(userId);
		}
		model.addAttribute("userModel", userModel);
		
		return USER_FORM_VIEW;
	}
	
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute(name = "userModel") UserModel userModel, ModelAndView mav) {
		LOG.info("Controlador " + "addUser" + " -- Parámetro: " + userModel.toString());		
		if(null != userService.addUser(userModel)){
			if(userModel.getUserId() == 0) {
				return "redirect:/user/listusers?message=1";
			} else {
				return "redirect:/user/listusers?message=5";
			}
		} else {
			return "redirect:/user/listusers?message=2";
		}
	}
	
	@GetMapping("/removeUser")
	public String removeUser(@RequestParam(name = "userId", required = true) int userId) {
		try {
			userService.removeUser(userId);
		} catch (Exception e) {
			return "redirect:/user/listusers?message=4";
		}
		return "redirect:/user/listusers?message=3";
	}

}
