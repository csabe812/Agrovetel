package com.agrovetel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
