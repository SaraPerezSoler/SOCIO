package com.socio.client.command.responseExceptions;

import org.json.JSONObject;

public class JSONResponse extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject object;
	
	public JSONResponse(JSONObject object) {
		super();
		this.object = object;
	}

	public JSONObject getObject() {
		return object;
	}

	public void setObject(JSONObject object) {
		this.object = object;
	}
	
	

}
