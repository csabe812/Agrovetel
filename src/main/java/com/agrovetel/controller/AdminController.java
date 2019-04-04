package com.agrovetel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agrovetel.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/index")
	public String showAdminSite() {
		log.debug("Loading admin site");
		return "admin";
	}
	
	@GetMapping("/users")
	public String showUsers(Model model) {
		log.info("Getting users");
		model.addAttribute("users", this.userService.findAll());
		return "users";
	}
}
