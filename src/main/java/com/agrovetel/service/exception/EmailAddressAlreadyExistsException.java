package com.agrovetel.service.exception;

public class EmailAddressAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831690716435013159L;

	public EmailAddressAlreadyExistsException(String message) {
		super(message);
	}

	public EmailAddressAlreadyExistsException() {

	}

}
