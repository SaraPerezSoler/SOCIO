package com.socio.client.command.responseExceptions;

public class ForbiddenResponse extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForbiddenResponse(String message) {
		super(message);
	}

}
