package com.air.exception;

public class DuplicateCodeException extends Exception {
	public DuplicateCodeException() {
		this("This is DuplicateCodeException...");
	}

	public DuplicateCodeException(String message) {
		super(message);
	}
}