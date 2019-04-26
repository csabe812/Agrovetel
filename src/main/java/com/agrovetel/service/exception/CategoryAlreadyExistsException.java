package com.agrovetel.service.exception;

public class CategoryAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6840334981045771817L;

	public CategoryAlreadyExistsException(String message) {
		super(message);
	}

	public CategoryAlreadyExistsException() {
	}

}