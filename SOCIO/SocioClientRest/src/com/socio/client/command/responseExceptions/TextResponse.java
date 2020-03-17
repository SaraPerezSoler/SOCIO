package com.socio.client.command.responseExceptions;

public class TextResponse extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text;

	public TextResponse(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
