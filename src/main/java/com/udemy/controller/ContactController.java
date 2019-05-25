package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/cancel")
	public String cancel() {
		LOG.info("Entrada método cancel");
		return "redirect:/contacts/showcontacts";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	public String redirectContactFomr(@RequestParam(name="id", required=false) int id, Model model) {
		LOG.info("Entrada método redirectContactFomr");
		ContactModel contactModel;
		if(id == 0) {
			contactModel = new ContactModel();
		} else {
			contactModel = contactService.findContactModelById(id);
		}
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
			Model model) {
		LOG.info("Entrada método addContact");		
		if(null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);			
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		LOG.info("Entrada método showContacts");	
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("contacts", contactService.listAllContacts());
		modelAndView.addObject("username", user.getUsername());
		return modelAndView;		
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		LOG.info("Entrada método removeContact");
		contactService.removeContact(id);
		return showContacts();		
	}

}
