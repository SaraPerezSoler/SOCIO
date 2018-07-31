package com.socio.client.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.socio.client.beans.Project.Subproject;
import com.socio.client.command.Channel;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public class Polling {

	private Project project;
	private String branchGroup;
	private Map<String, File> branchs;
	private List<User> users;
	private int nRound;
	private long time;

	public static Polling createPolling(JSONObject object) {
		if (object.isNull("project") || object.isNull("branchGroup") || object.isNull("users")
				|| object.isNull("nRound") || object.isNull("timer")) {
			return null;
		}

		Polling polling = new Polling();
		polling.setProject(Project.createProject(object.getJSONObject("project")));
		polling.setBranchGroup(object.getString("branchGroup"));
		List<User> users = new ArrayList<>();
		JSONArray usersJson = object.getJSONArray("users");
		for (int i = 0; i < usersJson.length(); i++) {
			JSONObject user = usersJson.getJSONObject(i);
			users.add(User.createUser(user));
		}
		polling.setUsers(users);
		polling.setnRound(object.getInt("nRound"));
		polling.setTime(object.getLong("timer"));
		List<Subproject> branchSubProjects = polling.getProject().getOpenBranchs().get(polling.getBranchGroup());
		if (branchSubProjects == null || branchSubProjects.isEmpty()) {
			return null;
		}
		Map<String, File> branchs = new HashMap<>();
		try {

			for (Subproject proj : branchSubProjects) {
				Project branch = Channel.SOCIO.project(proj.getName());
				File file = Channel.SOCIO.edit(branch, branch.getAdmin(), "", "", new Date(), "");
				branchs.put(proj.getName(), file);
			}

		} catch (ResponseError | ForbiddenResponse e) {
			return null;
		}
		polling.setBranchs(branchs);
		return polling;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Map<String, File> getBranchs() {
		return branchs;
	}

	public void setBranchs(Map<String, File> branchs) {
		this.branchs = branchs;
	}

	public int getnRound() {
		return nRound;
	}

	public void setnRound(int nRound) {
		this.nRound = nRound;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
