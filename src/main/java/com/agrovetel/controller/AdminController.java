package com.agrovetel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.User;
import com.agrovetel.service.AdService;
import com.agrovetel.service.ManufacturerService;
import com.agrovetel.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private ManufacturerService manufacturerService;

	/**
	 * Setter-based autowiring
	 * 
	 * @param userService
	 */
	@Autowired
	public void setManufacturerService(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

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
	 * Displaying a "HelloWorld" page
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String showAdminSite() {
		log.debug("Loading admin site");
		return "admin";
	}

	/**
	 * List of the users
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/users")
	public String showUsers(Model model) {
		log.info("Getting users");
		model.addAttribute("users", this.userService.findAll());
		return "users";
	}

	/**
	 * Getting details of a user
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/users/{id}")
	public String editUser(@PathVariable long id, Model model) {
		log.info("Getting a user by id");
		model.addAttribute("user", this.userService.findById(id));
		return "user";
	}

	/**
	 * 
	 * Editing a user
	 * 
	 * @param id
	 * @param updatedUser
	 * @param model
	 * @return
	 */
	@GetMapping("/users/{id}/update")
	public String updateUser(@PathVariable long id, @Valid User updatedUser, Model model) {
		log.info("Updating user");
		this.userService.updateUser(id, updatedUser);
		model.addAttribute("users", this.userService.findAll());
		return "users";
	}

	/**
	 * Disable a user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}/disable")
	public String disableUser(@PathVariable long id, Model model) {
		log.info("Disabled");
		this.userService.disableById(id);
		model.addAttribute("users", this.userService.findAll());
		return "users";
	}

	/**
	 * Enable a user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}/enable")
	public String enableUser(@PathVariable long id, Model model) {
		log.info("Enabled");
		this.userService.enableById(id);
		model.addAttribute("users", this.userService.findAll());
		return "users";
	}

	/**
	 * List of the ads
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/ads")
	public String showAds(Model model) {
		log.info("Getting ads");
		model.addAttribute("ads", this.adService.findAll());
		return "ads";
	}

	/**
	 * Getting details of a ad
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/ads/{id}")
	public String editAd(@PathVariable long id, Model model) {
		log.info("Getting a ad by id");
		model.addAttribute("ad", this.adService.findById(id));
		return "ad";
	}

	/**
	 * 
	 * Editing an ad
	 * 
	 * @param id
	 * @param updatedAd
	 * @param model
	 * @return
	 */
	@GetMapping("/ads/{id}/update")
	public String updateAd(@PathVariable long id, @Valid Ad updatedAd, Model model) {
		log.info("Updating ad");
		this.adService.updateAd(id, updatedAd);
		model.addAttribute("ads", this.adService.findAll());
		return "ads";
	}

	/**
	 * Disable a user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/ads/{id}/disable")
	public String disableAd(@PathVariable long id, Model model) {
		log.info("Disabled");
		this.adService.disableById(id);
		model.addAttribute("ads", this.adService.findAll());
		return "ads";
	}

	/**
	 * Enable a user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/ads/{id}/enable")
	public String enableAd(@PathVariable long id, Model model) {
		log.info("Enabled");
		this.adService.enableById(id);
		model.addAttribute("ads", this.adService.findAll());
		return "ads";
	}

	/**
	 * List of the manufacturers
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/manufacturers")
	public String showManufacturers(Model model) {
		log.info("Getting manufacturers");
		log.info("Size: " + this.manufacturerService.findAll().size());
		model.addAttribute("manufacturers", this.manufacturerService.findAll());
		return "manufacturers";
	}

	/**
	 * Displaying add new manufacturer page
	 * 
	 * @return
	 */
	@GetMapping("/manufacturers/new")
	public String showNewManufacturerPage() {
		return "manufacturer";
	}
}
