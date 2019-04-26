package com.agrovetel.controller;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.agrovetel.domain.User;
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
		log.info("User will be registered");
		log.info(user.toString());
		userService.registerUser(user);
		return "auth/login";
	}
	
	/**
	 * Deciding where to go: admin site - user site - nowhere
	 * NOT_LOGGED_IN_USER is not checked
	 * @return the given site
	 */
	@GetMapping("/mysite")
	public String showMySite() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("////");
		log.info(auth.getName());
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		boolean isGlobalAdmin = authorities.contains(new SimpleGrantedAuthority("GLOBAL_ADMIN"));
		boolean isLoggedInUser = authorities.contains(new SimpleGrantedAuthority("LOGGED_IN_USER"));
		boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ADMIN"));
		if(isAdmin || isGlobalAdmin) {
			return "redirect:/admin/";
		}
		else if(isLoggedInUser) {
			return "redirect:/user/mypage";
		}
		else {
			return "/";
		}
	}
	
}
