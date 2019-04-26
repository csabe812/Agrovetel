package com.agrovetel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.User;
import com.agrovetel.service.AdService;
import com.agrovetel.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
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

	private AdService adService;

	/**
	 * Setter-based autowiring
	 * 
	 * @param userService
	 */
	@Autowired
	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	/**
	 * Displaying a "mypage"
	 * 
	 * @return
	 */
	@GetMapping("/mypage")
	public String showUserPage() {
		return "mypage";
	}

	@GetMapping("/ads")
	public String showMyAds(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = this.userService.findByEmail(auth.getName());
		log.info("Getting ads");
		model.addAttribute("ads", this.adService.findAllByUserIdAndEnabled(u.getId(), true));
		return "userads";
	}

	/**
	 * Deleting an ad (deleting means: disable the given add, and only an admin can enable it)
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/ads/{id}/delete")
	public String disableManufacturer(@PathVariable long id, Model model) {
		log.info("Deleting an ad");
		this.adService.disableById(id);
		return "redirect:/user/ads";
	}

	/**
	 * Getting details of an ad
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/ads/{id}")
	public String editUserAd(@PathVariable long id, Model model) {
		Ad ad = this.adService.findById(id);
		model.addAttribute("ad", ad);
		return "userad";
	}

	/**
	 * Updating an ad by user
	 * 
	 * @param id
	 * @param updatedAd
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@GetMapping("/ads/{id}/update")
	public String updateManufacturer(@PathVariable long id, @ModelAttribute("ad") @Valid Ad updatedAd,
			BindingResult bindingResult, Model model) {
		this.adService.updateAd(id, updatedAd);
		return "redirect:/user/ads";
	}

	/**
	 * About me section
	 * 
	 * @return
	 */
	@GetMapping("/aboutme")
	public String showAboutMe() {
		return "aboutme";
	}

}
