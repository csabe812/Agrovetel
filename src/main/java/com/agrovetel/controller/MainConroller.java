package com.agrovetel.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.User;
import com.agrovetel.service.AdService;
import com.agrovetel.service.UserService;

@Controller
public class MainConroller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private UserService userService;

	/**
	 * Setter-based autowiring
	 * 
	 * @param userService
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/registrate")
	public String showAds(@ModelAttribute User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("==========");
		log.info(auth.getAuthorities().toString());
		log.info("User will be registered");
		log.info(user.toString());
		userService.registerUser(user);
		return "auth/login";
	}
	
	
}
