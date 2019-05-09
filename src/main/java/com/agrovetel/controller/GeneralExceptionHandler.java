package com.agrovetel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler
	public String exception(Exception exc, Model model) {
		log.info("ENTERED GeneralExceptionHandler");
		model.addAttribute("exception", exc);
		return "exception";
	}
}
