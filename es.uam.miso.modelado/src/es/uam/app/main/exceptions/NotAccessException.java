package es.uam.app.main.exceptions;

import es.uam.app.message.SendMessageExc;

public class NotAccessException extends SendMessageExc {

	/**
	 * 
	 */
	public static final String MSG = "You are not authorised to do this action. ";
	private static final long serialVersionUID = 1L;
	public NotAccessException(String action) {
		super(MSG+action);
	}

}
