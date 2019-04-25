package com.agrovetel.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agrovetel.domain.Ad;
import com.agrovetel.domain.Category;
import com.agrovetel.domain.Manufacturer;
import com.agrovetel.domain.User;
import com.agrovetel.service.AdService;
import com.agrovetel.service.CategoryService;
import com.agrovetel.service.ManufacturerService;
import com.agrovetel.service.UserService;
import com.agrovetel.service.exception.CategoryAlreadyExistsException;

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

	private CategoryService categoryService;

	/**
	 * Setter-based autowiring
	 * 
	 * @param categoryService
	 */
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
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
		return "redirect:/admin/users";
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
		return "redirect:/admin/users";
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
		return "redirect:/admin/users";
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
		model.addAttribute("updatedAd", this.adService.findById(id));
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
	public String updateAd(@PathVariable long id, @ModelAttribute("updatedAd") Ad updatedAd, Model model) {
		log.info("Updating ad: " + updatedAd.toString());
		this.adService.updateAd(id, updatedAd);
		model.addAttribute("ads", this.adService.findAll());
		return "redirect:/admin/ads";
	}

	/**
	 * Disable an ad
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/ads/{id}/disable")
	public String disableAd(@PathVariable long id, Model model) {
		log.info("Disabled");
		this.adService.disableById(id);
		model.addAttribute("ads", this.adService.findAll());
		return "redirect:/admin/ads";
	}

	/**
	 * Enable an ad
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/ads/{id}/enable")
	public String enableAd(@PathVariable long id, Model model) {
		log.info("Enabled");
		this.adService.enableById(id);
		model.addAttribute("ads", this.adService.findAll());
		return "redirect:/admin/ads";
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
	 * Getting details of a manufacturer
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/manufacturers/{id}")
	public String editManufacturer(@PathVariable long id, Model model) {
		log.info("Getting a manufacturer by id");
		Manufacturer manufacturer = this.manufacturerService.findById(id);
		log.info("FOUND: " + manufacturer.toString());
		model.addAttribute("manufacturer", manufacturer);
		return "manufacturer";
	}

	@GetMapping("/manufacturers/{id}/update")
	public String updateManufacturer(@PathVariable long id,
			@ModelAttribute("manufacturer") Manufacturer updatedManufacturer, Model model) {
		log.info("Updating manufacturer: " + updatedManufacturer.toString());
		this.manufacturerService.updateManufacturer(id, updatedManufacturer);
		model.addAttribute("categories", this.categoryService.findAllCategory());
		return "redirect:/admin/manufacturers";
	}

	/**
	 * Disable a category
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/manufacturers/{id}/disable")
	public String disableManufacturer(@PathVariable long id, Model model) {
		log.info("Disabled manufacturer");
		this.manufacturerService.disableManufacturerById(id);
		model.addAttribute("manufacturers", this.manufacturerService.findAll());
		return "redirect:/admin/manufacturers";
	}

	/**
	 * Enable a category
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/manufacturers/{id}/enable")
	public String enableManufacturer(@PathVariable long id, Model model) {
		log.info("Enabled manufacturer");
		this.manufacturerService.enableManufacturerById(id);
		model.addAttribute("manufacturers", this.manufacturerService.findAll());
		return "redirect:/admin/manufacturers";
	}

	/**
	 * Displaying add new manufacturer page
	 * 
	 * @return
	 */
	@GetMapping("/manufacturers/new")
	public String showNewManufacturerPage(@Valid Manufacturer manufacturer, Model model) {
		this.manufacturerService.updateCreateManufacturer(manufacturer);
		model.addAttribute("manufacturers", this.manufacturerService.findAll());
		return "manufacturer";
	}

	/**
	 * List of the categories
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/categories")
	public String showCategories(Model model) {
		log.info("Getting categories");
		model.addAttribute("categories", this.categoryService.findAllCategory());
		return "categories";
	}

	/**
	 * Getting details of a category
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/categories/{id}")
	public String editCategory(@PathVariable long id, Model model) {
		log.info("Getting a category by id");
		model.addAttribute("category", this.categoryService.findCategoryById(id));
		return "category";
	}

	/**
	 * 
	 * Editing a category
	 * 
	 * @param id
	 * @param updatedCategory
	 * @param model
	 * @return
	 */
	@GetMapping("/categories/{id}/update")
	public String updateCategory(@PathVariable long id, @ModelAttribute("category") Category updatedCategory,
			Model model) {
		if (id == 0) {
			try {
				this.categoryService.createCategoryByCategoryName(updatedCategory.getName());
			} catch (CategoryAlreadyExistsException e) {
				e.printStackTrace();
			}
		} else {
			try {
				this.categoryService.updateCategory(id, updatedCategory);
			} catch (CategoryAlreadyExistsException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/categories";
	}

	/**
	 * Disable a category
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/categories/{id}/disable")
	public String disableCategory(@PathVariable long id, Model model) {
		log.info("Disabled");
		this.categoryService.disableCategoryById(id);
		model.addAttribute("categories", this.categoryService.findAllCategory());
		return "redirect:/admin/categories";
	}

	/**
	 * Enable a category
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/categories/{id}/enable")
	public String enableCategory(@PathVariable long id, Model model) {
		log.info("Enabled");
		this.categoryService.enableCategoryById(id);
		model.addAttribute("categories", this.categoryService.findAllCategory());
		return "redirect:/admin/categories";
	}

	/**
	 * Displaying add new categories page
	 * 
	 * @return
	 * @throws CategoryAlreadyExistsException
	 */
	@GetMapping("/categories/new")
	public String showNewcategoryPage(@Valid Category category, Model model) {
		log.info("Category id" + category.getId());
		return "category";
	}

}
