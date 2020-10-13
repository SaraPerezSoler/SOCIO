package com.socio.client.command.responseExceptions;

public class ResponseError extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public ResponseError(String message) {
		msg= message;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
