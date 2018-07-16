package com.socio.client.beans;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Bean {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static JSONObject getJSONObject(Object object) throws JSONException, JsonProcessingException  {
		return new JSONObject(mapper.writeValueAsString(object));
	}
}
