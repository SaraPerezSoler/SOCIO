package es.uam.app.main.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;

import es.uam.app.main.SocioData;
import projectHistory.Action;
import projectHistory.Msg;
import socioProjects.BranchGroup;
import socioProjects.Project;
import socioProjects.User;

public interface DataFormat {

	public static JSONObject getMsgListJSON(List<Msg> msgList) {
		JSONObject response = new JSONObject();
		JSONArray array = new JSONArray();

		for (Msg msg : msgList) {

			JSONObject msgObject = getMsgJSON(msg);
			array.put(msgObject);

		}
		response.put("msgList", array);
		return response;
	}

	public static JSONObject getMsgJSON(Msg msg) {

		List<String> ams = new ArrayList<String>();
		Map<String, List<Action>> sentences = msg.getSentencesMap();
		Set<String> keys = sentences.keySet();
		for (String k : keys) {
			for (Action a : sentences.get(k)) {
				ams.add(a.toString());
			}
		}
		JSONObject msgObject = new JSONObject();
		msgObject.put("user", getUserJSON(msg.getUser()));
		msgObject.put("msg", msg.getMsg());
		msgObject.put("text", msg.getText());
		if (msg.getDate() != null) {
			msgObject.put("date", msg.getDate().getTime());
		}
		msgObject.put("id", msg.getId());
		JSONArray actionsArray = new JSONArray(ams);
		msgObject.put("actions", actionsArray);
		return msgObject;
	}

	public static JSONObject getUserJSON(User u) {
		JSONObject user = new JSONObject();
		user.put("nick", u.getNick());
		user.put("name", u.getName());
		user.put("channel", u.getChannel());
		user.put("id", u.getId());
		return user;
	}

	public static JSONObject getProjectJSON(ServletContext context, Project p) throws Exception {
		JSONObject project = new JSONObject();
		project.put("admin", getUserJSON(p.getAdmin()));
		project.put("name", p.getName());
		project.put("id", p.getId());
		project.put("type", p.getType());
		project.put("visibility", p.getVisibility().toString());
		project.put("isOpen", p.isOpen());
		project.put("isBranch", p.isBranch());
		project.put("createDate", p.getCreateDate().getTime());

		JSONArray usersCanEdit = new JSONArray();
		JSONArray usersCanRead = new JSONArray();
		for (User u : SocioData.getSocioData(context).getUsers(p)) {
			if (u.canEdit(p)) {
				usersCanEdit.put(getUserJSON(u));
			} else {
				usersCanRead.put(getUserJSON(u));
			}
		}
		project.put("usersCanEdit", usersCanEdit);
		project.put("usersCanRead", usersCanRead);

		if (p.isBranch()) {
			project.put("branchGroup", p.getBranchGroup().getName());
			JSONObject father = getSortProjectJSON(context, p.getFather());
			project.put("father", father);
		} else {
			if (!p.getOpenBranchs().isEmpty() || !p.getCloseBranchs().isEmpty()) {
				JSONArray openBranchs = new JSONArray();
				for (BranchGroup bg : p.getOpenBranchs()) {
					for (Project b : bg.getBranchs()) {
						JSONObject ob = getSortProjectJSON(context, b);
						ob.put("branchGroup", bg.getName());
						openBranchs.put(ob);
					}
				}
				
				for (BranchGroup bg : p.getCloseBranchs()) {
					for (Project b : bg.getBranchs()) {
						JSONObject ob = getSortProjectJSON(context, b);
						ob.put("branchGroup", bg.getName());
						openBranchs.put(ob);
					}
				}
				project.put("openBranchs", openBranchs);
			}
			if (!p.getMergedBranchs().isEmpty()) {
				JSONArray closeBranch = new JSONArray();
				for (BranchGroup bg : p.getMergedBranchs()) {
					closeBranch.put(bg.getDecision().decisionInformation());
				}
				project.put("closeBranchs", closeBranch);
			}
		}
		return project;
	}

	public static JSONObject getSortProjectJSON(ServletContext context, Project p) {
		JSONObject ob = new JSONObject();
		ob.put("name", p.getCompleteName());
		ob.put("id", p.getId());
		return ob;
	}

	public static JSONObject getProjectListJSON(ServletContext context, List<Project> list) throws Exception {
		JSONObject projects = new JSONObject();
		JSONArray listProjects = new JSONArray();
		for (Project p : list) {
			listProjects.put(getProjectJSON(context, p));
		}
		projects.put("projectList", listProjects);
		return projects;
	}
}
