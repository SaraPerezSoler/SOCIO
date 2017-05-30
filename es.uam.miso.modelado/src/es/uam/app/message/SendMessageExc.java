package es.uam.app.message;

import java.io.File;

public class SendMessageExc extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String text;
	private File png=null;
	private File document=null;
	private String url=null;
	public SendMessageExc(String message) {
		this.text=message;
	}
	
	@Override
	public String getMessage() {
		return text;
	}
	public SendMessageExc(String message, File png) {
		this.text=message;
		this.png=png;
	}
	public SendMessageExc(File png) {
		this.png=png;
	}
	public String getText() {
		return text;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean hasText(){
		return text!=null;
	}
	
	public boolean hasPng(){
		return png!=null;
	}
	
	public boolean hasDocument(){
		return document!=null;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
