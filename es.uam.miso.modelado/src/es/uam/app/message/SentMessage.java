package es.uam.app.message;

import java.io.File;

public class SentMessage {
  
	private String text=null;
	private File png=null;
	private File document=null;
	
	public boolean hasText(){
		return text!=null;
	}
	
	public boolean hasPng(){
		return png!=null;
	}
	
	public boolean hasDocument(){
		return document!=null;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public File getPng() {
		return png;
	}
	public void setPng(File png) {
		this.png = png;
	}
	public File getDocument() {
		return document;
	}
	public void setDocument(File document) {
		this.document = document;
	}
	
	

	
	
}
