package com.socio.client.command;

import java.io.File;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.socio.client.command.responseExceptions.FileResponse;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.JSONResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.command.responseExceptions.TextResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public abstract class CreateRequest {
	private String URL;
	private static final Client CLIENT = Client.create();
	protected static final ResponseError UNEXPECTED_ERROR = new ResponseError("A error has ocurred with the command");
	
	public CreateRequest(String URL) {
		this.URL = URL;
	}

	protected ClientResponse getRequest(String path, String ... mediaType) {
		WebResource webResource = getWebResource(path);
		return webResource.accept(MediaType.TEXT_PLAIN).accept(mediaType).get(ClientResponse.class);
	}

	protected ClientResponse postRequest(String path, JSONObject object, String ... mediaTypeAcept) {
		return postRequest(path, object.toString(), MediaType.APPLICATION_JSON, mediaTypeAcept);
	}
	
	protected ClientResponse postRequest(String path, Object object, String mediaType,  String ... mediaTypeAcept) {
		WebResource webResource = getWebResource(path);
		return webResource.type(mediaType).accept(MediaType.TEXT_PLAIN).accept(mediaTypeAcept)
				.post(ClientResponse.class, object);
	}

	protected WebResource getWebResource(String path) {
		String url = URL + path;
		return CLIENT.resource(url);
	}

	protected void readResponse(ClientResponse response)
			throws ResponseError, ForbiddenResponse, TextResponse, JSONResponse, FileResponse {
		MultivaluedMap<String, String> header = response.getHeaders();
		List<String> contentType = header.get("Content-type");

		// La peticion se ha recibido pero no se ha procesado por algun problema
		if (response.getStatus() == 403) {
			if (contentType.contains(MediaType.TEXT_PLAIN)) {
				String output = response.getEntity(String.class);
				throw new ForbiddenResponse(output);
			}
			// La peticion es correcta
		} else if (response.getStatus() == 200) {

			if (contentType.contains(MediaType.TEXT_PLAIN)) {
				String output = response.getEntity(String.class);
				throw new TextResponse(output);
			}
			if (contentType.contains(MediaType.APPLICATION_JSON)) {
				String output = response.getEntity(String.class);
				throw new JSONResponse(new JSONObject(output));
			}
			if (contentType.contains(MediaType.APPLICATION_OCTET_STREAM)) {
				File output = response.getEntity(File.class);
				String name = null;
				List<String> contentDisposition = header.get("Content-Disposition");
				if (contentDisposition != null) {
					for (String s : contentDisposition) {
						if (s.contains("filename=")) {
							name = s.substring(s.indexOf("filename=") + "filename=".length());
							name = name.split("\"")[1];
							//System.out.println(name);
						}
					}
				}
				File f = null;
				if (name != null) {
					f = new File(output.getParent()+"/"+name);
					if (f.exists()) {
						f.delete();
					}
					output.renameTo(f);

				}
				throw new FileResponse(f);
			}
			// Cualquier error
		} else {
			throw new ResponseError(
					"Failed : HTTP error code : " + response.getStatus() + " " + response.getStatusInfo());
		}

	}

	public String getURL() {
		return URL;
	}
	
	protected JSONObject responseJSON(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		try {
			ClientResponse response;
			String[] types = new String[] { MediaType.APPLICATION_JSON };
			if (object == null) {
				response = getRequest(path, types);

			} else {
				response = postRequest(path, object, types);
			}
			readResponse(response);
		} catch (JSONResponse e) {
			return e.getObject();
		} catch (JSONException e1) {
			throw UNEXPECTED_ERROR;
		} catch (TextResponse | FileResponse e) {
			throw UNEXPECTED_ERROR;
		}
		throw UNEXPECTED_ERROR;
	}

	protected String responseText(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		try {
			String[] types = new String[] { MediaType.TEXT_PLAIN };
			ClientResponse response;
			if (object == null) {
				response = getRequest(path, types);
			} else {
				response = postRequest(path, object, types);
			}
			readResponse(response);
		} catch (TextResponse e) {
			return e.getText();
		} catch (JSONException e1) {
			throw UNEXPECTED_ERROR;
		} catch (JSONResponse | FileResponse e) {
			throw UNEXPECTED_ERROR;
		}
		throw UNEXPECTED_ERROR;
	}

	protected File responseFile(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		try {
			ClientResponse response;
			String[] types = new String[] { MediaType.APPLICATION_OCTET_STREAM };
			if (object == null) {
				response = getRequest(path, types);
			} else {
				response = postRequest(path, object, types);
			}
			readResponse(response);
		} catch (FileResponse e) {
			return e.getFile();
		} catch (JSONException e1) {
			throw UNEXPECTED_ERROR;
		} catch (JSONResponse | TextResponse e) {
			throw UNEXPECTED_ERROR;
		}
		throw UNEXPECTED_ERROR;
	}
}
