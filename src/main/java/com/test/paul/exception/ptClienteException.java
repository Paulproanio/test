package com.test.paul.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ptClienteException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ptClienteException(String message) {
		super(message);
	}
	
	public ptClienteException(String message, Throwable t) {
		super(message, t);
	}

}
