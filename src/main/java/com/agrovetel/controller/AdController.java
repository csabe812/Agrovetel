package com.agrovetel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agrovetel.service.AdService;

@Controller
public class AdController {

	@Autowired
	private AdService adService;

	@GetMapping("/ads")
	public String displayAllAds(Model model) {
		model.addAttribute("ads", this.adService.findAll());
		return "allAds";
	}

	/**
	 * Returns with the detailed view. And show the current Ad.
	 * 
	 * @param id    The id of the Ad
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/ads/{id}")
	public String showAdDetail(@PathVariable("id") long id, Model model) {
		model.addAttribute("ad", this.adService.incrementNumberOfVisitors(id));
		return "ad";
	}
}
