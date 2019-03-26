package com.agrovetel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
