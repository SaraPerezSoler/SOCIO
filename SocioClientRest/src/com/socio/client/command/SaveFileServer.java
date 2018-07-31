package com.socio.client.command;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.MediaType;

import com.socio.client.command.responseExceptions.FileResponse;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.JSONResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.command.responseExceptions.TextResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.impl.MultiPartWriter;

public class SaveFileServer extends CreateRequest{
	private static final String URL = "http://localhost:8080/FileServer/file/";
	
	public SaveFileServer() {
		super(URL);
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
			return URL + "get/"+e.getText();
		} catch (ForbiddenResponse | ResponseError | JSONResponse | FileResponse e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getFile (String path) throws ResponseError, ForbiddenResponse {
		path = path.replace(URL, "");
		return super.responseFile(path, null);
	}
	@Override
	protected WebResource getWebResource(String path) {
		String url = super.getURL() + path;
		final ClientConfig config = new DefaultClientConfig();
		config.getClasses().add(MultiPartWriter.class);
		final Client client = Client.create(config);
		return client.resource(url);
	}
	
}
