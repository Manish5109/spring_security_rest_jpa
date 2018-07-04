/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.exception;

/**
 * @author Manish Kumar
 * @since Jul 3, 2018
 */
public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -7716234137063227118L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
