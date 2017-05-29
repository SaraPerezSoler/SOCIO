package es.uam.app.main.exceptions;

import java.io.File;

public class MessageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File png=null;
	private File document=null;
	public MessageException(String message) {
		super(message);
	}
	
	public MessageException(String message, File png) {
		super(message);
		this.png=png;
	}
	public MessageException(File png) {
		this.png=png;
	}
	
	public File getPng(){
		return png;
	}

	public File getDocument() {
		return document;
	}
	public void setDocument(File document) {
		this.document= document;
	}
	
	

}
