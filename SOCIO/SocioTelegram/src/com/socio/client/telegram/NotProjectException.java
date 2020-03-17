package com.socio.client.telegram;

import com.socio.client.command.responseExceptions.ForbiddenResponse;

public class NotProjectException extends ForbiddenResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotProjectException() {
		super("You don't have a selected project. You can choose one with /setproject.");
	}

	
}
