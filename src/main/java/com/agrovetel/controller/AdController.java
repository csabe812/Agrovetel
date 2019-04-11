package com.agrovetel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agrovetel.domain.Ad;
import com.agrovetel.service.AdService;

@Controller
public class AdController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdService adService;
	
	@GetMapping("/ads")
	public String displayAllAds(Model model) {
		model.addAttribute("ads", this.adService.findAll());
		return "allAds";
	}
	
	/**
	 * Returns with the detailed view. And show the current Ad.
	 * @param id The id of the Ad
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/ads/{id}")
	public String showAdDetail(@PathVariable("id") long id, Model model) {
		model.addAttribute("ad", this.adService.incrementNumberOfVisitors(id));
		return "ad";
	}

}
