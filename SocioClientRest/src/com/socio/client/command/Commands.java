package com.socio.client.command;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socio.client.beans.JSONObj;
import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public abstract class Commands extends CreateRequest {

	
	private static final String URL = "http://localhost:8080/Socio-rest/";
	public Commands() {
		super (URL);
	}

	protected JSONObject addUser(User user, JSONObject object) throws ResponseError {
		try {
			object.put("user", JSONObj.getJSONObject(user));
			return object;
		} catch (JSONException | JsonProcessingException e1) {
			throw UNEXPECTED_ERROR;
		}
	}

	protected JSONObject addUser(User user, JSONObject object, String dataName) throws ResponseError {
		if (dataName == null) {
			return addUser(user, object);
		}
		try {
			object.put(dataName, JSONObj.getJSONObject(user));
			return object;
		} catch (JSONException | JsonProcessingException e1) {
			throw UNEXPECTED_ERROR;
		}
	}

	protected JSONObject addMsg(Message msg, JSONObject object) throws ResponseError {
		try {
			object.put("msg", JSONObj.getJSONObject(msg));
			return object;
		} catch (JSONException | JsonProcessingException e1) {
			throw UNEXPECTED_ERROR;
		}
	}
	protected List<Project> responseProjectList(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		JSONObject projJSON = responseJSON(path, object);
		List<Project> listRet= new ArrayList<>();
		if (projJSON.isNull("projectList")) {
			return listRet;
		}
				
		JSONArray projectList=projJSON.getJSONArray("projectList");
		for (int i=0; i<projectList.length(); i++) {
			JSONObject proj=projectList.getJSONObject(i);
			listRet.add(Project.createProject(proj));
		}
		return listRet;
	}

	protected List<Message> responseMsgList(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		JSONObject msgJSON = responseJSON(path, object);
		List<Message> listRet= new ArrayList<>();
		if (msgJSON.isNull("msgList")) {
			return listRet;
		}
				
		JSONArray msgList=msgJSON.getJSONArray("msgList");
		for (int i=0; i<msgList.length(); i++) {
			JSONObject msg=msgList.getJSONObject(i);
			listRet.add(Message.createMessage(msg));
		}
		return listRet;
	}

	protected Project responseProject(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		JSONObject projJSON = responseJSON(path, object);
		Project project = Project.createProject(projJSON);
		if (project == null) {
			throw UNEXPECTED_ERROR;
		}
		return project;
	}

	protected Message responseMsg(String path, JSONObject object) throws ResponseError, ForbiddenResponse {
		JSONObject msgJSON = responseJSON(path, object);

		Message message = Message.createMessage(msgJSON);
		if (message == null) {
			throw UNEXPECTED_ERROR;
		}
		return message;
	}


}
