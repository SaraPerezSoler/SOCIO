package com.socio.client.command;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;

import com.socio.client.command.responseExceptions.FileResponse;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.JSONResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.command.responseExceptions.TextResponse;

public class SaveFileServer extends CreateRequest{
//	private static final String URL = "http://dimo1.ii.uam.es:8080/FileServer/file/";

	public SaveFileServer(String url) {
		super(url);
	}
	
	public String saveFile (File file) {
		return saveFile(file, -1, null);
	}
	public String saveFile (File file, long duration, TimeUnit unit) {
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("fileName", file.getName(), MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		ClientResponse response;
		if (duration != -1 && unit != null) {
			response=super.postRequest("upload/"+duration+"/"+unit.toString(), multiPart, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN);
		}else {
			response=super.postRequest("upload", multiPart, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN);
		}
		try {
			readResponse(response);
		} catch (TextResponse e) {
			return getURL() + "get/"+e.getText();
		} catch (ForbiddenResponse | ResponseError | JSONResponse | FileResponse e) {
			e.printStackTrace();
		}
		return null;
	}
	public String saveSecondFile (File file, long duration, TimeUnit unit) {
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("fileName", file.getName(), MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		ClientResponse response;
		if (duration != -1 && unit != null) {
			response=super.postRequest("uploadSecond/"+duration+"/"+unit.toString(), multiPart, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN);
		}else {
			response=super.postRequest("uploadSecond", multiPart, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN);
		}
		try {
			readResponse(response);
		} catch (TextResponse e) {
			return e.getText();
		} catch (ForbiddenResponse | ResponseError | JSONResponse | FileResponse e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getFile (String path) throws ResponseError, ForbiddenResponse {
		System.out.println(path);
		System.out.println("Url_: " + getURL());
		path = path.replace(getURL(), "");
		System.out.println(path);
		return super.responseFile(path, null);
	}
	@Override
	protected WebTarget getWebTarget(String path) {
		String url = super.getURL();
		ClientConfig config = new ClientConfig();
		config.getClasses().add(MultiPartWriter.class);
		Client client = ClientBuilder.newClient(config);
		return client.target(url).path(path);
	}
	
}
