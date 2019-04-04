package com.agrovetel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.agrovetel.service.AdService;

@Controller
public class AdController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdService adService;
	
	@GetMapping("/ads")
	public String displayAds(Model model) {
		model.addAttribute("ad", adService.findAll());
		return "ads";
	}

}