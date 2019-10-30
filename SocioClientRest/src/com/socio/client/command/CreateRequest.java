package com.socio.client.command;

import java.io.File;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.client.ClientResponse;
import org.json.JSONException;
import org.json.JSONObject;

import com.socio.client.command.responseExceptions.FileResponse;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.JSONResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.command.responseExceptions.TextResponse;

public abstract class CreateRequest {
	private String URL;
	private static final Client CLIENT = ClientBuilder.newClient();
	protected static final ResponseError UNEXPECTED_ERROR = new ResponseError("A error has ocurred with the command");
	
	public CreateRequest(String URL) {
		this.URL = URL;
	}

	protected ClientResponse getRequest(String path, String ... mediaType) {
		WebTarget webTarget = getWebTarget(path);
		return webTarget.request(addMediaTypeText(mediaType)).get(ClientResponse.class);
	}
	
	private String[] addMediaTypeText (String ... mediaType) {
		String  [] ret = new String[mediaType.length+1];
		for (int i =0; i<mediaType.length; i++) {
			if (mediaType[i].equals(MediaType.TEXT_PLAIN)) {
				return mediaType;
			}
			ret[i] = mediaType[i];
		}
		ret[mediaType.length] = MediaType.TEXT_PLAIN;
		return ret;
	}

	protected ClientResponse postRequest(String path, JSONObject object, String ... mediaTypeAcept) {
		return postRequest(path, object, MediaType.APPLICATION_JSON, mediaTypeAcept);
	}
	
	protected ClientResponse postRequest(String path, Object object, String mediaType,  String ... mediaTypeAcept) {
		WebTarget webTarget = getWebTarget(path);
		return webTarget.request(addMediaTypeText(mediaTypeAcept))
				.post(Entity.entity(object, mediaType), ClientResponse.class);
	}

	protected WebTarget getWebTarget(String path) {
		return CLIENT.target(URL).path(path);
	}

	protected void readResponse(ClientResponse response)
			throws ResponseError, ForbiddenResponse, TextResponse, JSONResponse, FileResponse {
		MultivaluedMap<String, String> header = response.getHeaders();
		List<String> contentType = header.get("Content-type");

		// La peticion se ha recibido pero no se ha procesado por algun problema
		if (response.getStatus() == 403) {
			if (contentType.contains(MediaType.TEXT_PLAIN)) {
				String output =(String)response.getEntity();
				throw new ForbiddenResponse(output);
			}
			// La peticion es correcta
		} else if (response.getStatus() == 200) {

			if (contentType.contains(MediaType.TEXT_PLAIN)) {
				String output = (String)response.getEntity();
				throw new TextResponse(output);
			}
			if (contentType.contains(MediaType.APPLICATION_JSON)) {
				String output = (String)response.getEntity();
				throw new JSONResponse(new JSONObject(output));
			}
			if (contentType.contains(MediaType.APPLICATION_OCTET_STREAM)) {
				File output = (File)response.getEntity();
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
