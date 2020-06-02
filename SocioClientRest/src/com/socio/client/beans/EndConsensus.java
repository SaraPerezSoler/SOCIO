package com.socio.client.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import com.socio.client.command.SaveFileServer;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public class EndConsensus {
	private String messageId;
	private Project project;
	private String branchGroup;
	private Map<Integer, String> preference;
	private List<User> notVoted;
	private Map<User, Boolean> close;
	private double measure;
	private double required;
	private File branchs;
	private static final SaveFileServer fileServer = new SaveFileServer("http://miso1.ii.uam.es:8080/FileServer/file/");
	//private static final SaveFileServer fileServer = new SaveFileServer("http://dimo1.ii.uam.es:8080/FileServer/file/");

	public static EndConsensus createEndConsensus(JSONObject object) {
		if (object.isNull("project") || object.isNull("branchGroup") || object.isNull("colective")
				|| object.isNull("notVoted") || object.isNull("close") || object.isNull("measure")
				|| object.isNull("required")) {
			return null;
		}

		EndConsensus endConsensus = new EndConsensus();
		endConsensus.setProject(Project.createProject(object.getJSONObject("project")));
		endConsensus.setBranchGroup(object.getString("branchGroup"));

		Map<Integer, String> preference = new HashMap<>();
		JSONArray preferenceJson = object.getJSONArray("colective");
		for (int i = 0; i < preferenceJson.length(); i++) {
			JSONObject pref = preferenceJson.getJSONObject(i);
			preference.put(pref.getInt("pos"), pref.getString("proj"));
		}
		endConsensus.setPreference(preference);

		List<User> notVoted = new ArrayList<>();
		JSONArray usersJson = object.getJSONArray("notVoted");
		for (int i = 0; i < usersJson.length(); i++) {
			JSONObject user = usersJson.getJSONObject(i);
			notVoted.add(User.createUser(user));
		}
		endConsensus.setNotVoted(notVoted);

		Map<User, Boolean> close = new HashMap<>();
		JSONArray closeJson = object.getJSONArray("close");
		for (int i = 0; i < closeJson.length(); i++) {
			JSONObject user = closeJson.getJSONObject(i);
			Boolean clo = user.getBoolean("close");
			close.put(User.createUser(user), clo);
		}
		endConsensus.setClose(close);

		endConsensus.setMeasure(object.getDouble("measure"));
		endConsensus.setRequired(object.getDouble("required"));
		if (object.has("messageId")) {
			endConsensus.setMessageId(object.getString("messageId"));
		}
		try {
			if (object.has("filePath")) {
				System.out.println(object.getString("filePath"));
				endConsensus.setBranchs(fileServer.getFile(object.getString("filePath")));
				System.out.println("Despues...");
			}
		} catch (ResponseError | ForbiddenResponse e) {
		}

		return endConsensus;

	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getBranchGroup() {
		return branchGroup;
	}

	public void setBranchGroup(String branchGroup) {
		this.branchGroup = branchGroup;
	}

	public File getBranchs() {
		return branchs;
	}

	public void setBranchs(File branchs) {
		this.branchs = branchs;
	}

	public Map<Integer, String> getPreference() {
		return preference;
	}

	public void setPreference(Map<Integer, String> preference) {
		this.preference = preference;
	}

	public List<User> getNotVoted() {
		return notVoted;
	}

	public void setNotVoted(List<User> notVoted) {
		this.notVoted = notVoted;
	}

	public Map<User, Boolean> getClose() {
		return close;
	}

	public void setClose(Map<User, Boolean> close) {
		this.close = close;
	}

	public double getMeasure() {
		return measure;
	}

	public void setMeasure(double measure) {
		this.measure = measure;
	}

	public double getRequired() {
		return required;
	}

	public void setRequired(double required) {
		this.required = required;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
