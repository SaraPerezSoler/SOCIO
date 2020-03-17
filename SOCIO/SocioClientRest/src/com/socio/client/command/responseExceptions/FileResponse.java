package com.socio.client.command.responseExceptions;

import java.io.File;

public class FileResponse extends Exception{

	private static final long serialVersionUID = -3817098094573185184L;
	private File file;
	public FileResponse(File file) {
		super();
		this.file = file;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
}
