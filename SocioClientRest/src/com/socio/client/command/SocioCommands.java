package com.socio.client.command;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Message;
import com.socio.client.beans.Polling;
import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;



public class SocioCommands extends Commands {

	private static final String GET_PATH = "get/";
	private static final String EDITOR_PATH = "editor/";
	private static final String RECOMMEND_PATH = "recommend/";
	private static final String EDIT_PATH = EDITOR_PATH + "do/";
	private static final String UNDO_PATH = EDITOR_PATH + "undo/";
	private static final String REDO_PATH = EDITOR_PATH + "redo/";
	private static final String DELETE_EDITOR_PATH = EDITOR_PATH + "delete/";
	private static final String ADD_EDITOR_PATH = EDITOR_PATH + "add/";
	private static final String HELP_PATH = "help/";
	private static final String CONFIGURATION_PATH = "configuration/";
	private static final String NEW_PROJECT = CONFIGURATION_PATH + "new_project/";
	private static final String REMOVE_PROJECT = CONFIGURATION_PATH + "remove_project/";
	private static final String VISIBILITY_PROJECT = CONFIGURATION_PATH + "visibility/";
	private static final String VALIDATE_PATH = CONFIGURATION_PATH + "validate/";
	private static final String ADD_USER_PATH = CONFIGURATION_PATH + "addUser/";
	private static final String NEW_BRANCH_PATH = CONFIGURATION_PATH + "newBranch/";
	private static final String BRANCHGROUP_PATH = CONFIGURATION_PATH + "branchgroup/";
	private static final String UPDATE_USER_PATH = CONFIGURATION_PATH + "updateUser/";
	private static final String REMOVE_USER_PATH = "CONFIGURATION_PATH + \"removeUser/";
	private static final String HISTORY_PATH = "history/";
	private static final String HISTORY_PROJECT_PATH = HISTORY_PATH + "project/";
	private static final String PROJECT_PATH = "projects/";
	private static final String PROJECT_INFO_PATH = PROJECT_PATH + "info/";
	private static final String PROJECT_ELEMEMTS_PATH = PROJECT_PATH + "elements/";
	private static final String PROJECT_EDIT_PATH = PROJECT_PATH + "write/";
	private static final String PROJECT_READ_PATH = PROJECT_PATH + "read/";
	private static final String STATISTICS_PATH = "statistics/";
	private static final String STATISTICS_ALLACTIONS_PATH = STATISTICS_PATH + "allactions/";
	private static final String STATISTICS_ACTIONS_PATH = STATISTICS_PATH + "actions/";
	private static final String STATISTICS_MESSAGES_PATH = STATISTICS_PATH + "messages/";
	private static final String STATISTICS_AUTHORSHIP_PATH = STATISTICS_PATH + "authorship/";
	private static final String UPDATES_PATH = "updates/";
	private static final String REGISTER = UPDATES_PATH + "register/";
	private static final String GET_UPDATES = UPDATES_PATH + "getupdates/";
	private static final String GET_UPDATE = UPDATES_PATH + "getupdate/";
	private static final String GET_LAST_FILE = UPDATES_PATH + "getlastfile/";
	
	
	private static final String DECISION = "decisionMaker/";
	private static final String SET_CHOICE = DECISION+ "setChoice/";
	private static final String CONSENSUS = DECISION+ "consensus/";
	private static final String START_POLL = DECISION+ "startPoll/";
	private static final String GET_POLL = DECISION+ "getPoll/";
	private static final String SET_POLL = DECISION+ "addPoll/";
	private static final String GET_END_POLL = DECISION+ "getEndPoll/";
	
	
	private static SocioCommands SOCIO = null;
	
	public static SocioCommands getSOCIO(String url) {
		if (SOCIO == null) {
			SOCIO = new SocioCommands(url);
		}
		return SOCIO;
	}
	
	private SocioCommands(String url) {
		super (url);
	}

	public File get(String projectName, User user) throws ResponseError, ForbiddenResponse {
		String path = GET_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		return responseFile(path, object);
	}

	public File get(Project project, User user) throws ResponseError, ForbiddenResponse {
		return get(getProjectData(project), user);
	}

	public File get(long project, User user) throws ResponseError, ForbiddenResponse {
		return get(getProjectData(project), user);
	}

	public File get(String channel, String nick, String project, User user) throws ResponseError, ForbiddenResponse {
		return get(getProjectData(channel, nick, project), user);
	}
	
	public JSONObject recommend(String projectName, String className, User user) throws ResponseError, ForbiddenResponse {
		String path = RECOMMEND_PATH + getProjectData(projectName)+"/"+className;
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("userChannel", user.getChannel());
		queryParams.put("userNick", user.getNick());
		queryParams.put("userId", user.getId());
		return responseJSON(path, null, queryParams);
	}

	public JSONObject recommend(Project project, String className, User user) throws ResponseError, ForbiddenResponse {
		return recommend(getProjectData(project), className, user);
	}

	public JSONObject recommend(long project, String className, User user) throws ResponseError, ForbiddenResponse {
		return recommend(getProjectData(project), className, user);
	}

	public JSONObject recommend(String channel, String nick, String project,String className, User user) throws ResponseError, ForbiddenResponse {
		return recommend(getProjectData(channel, nick, project), className, user);
	}

	private File editor(String path, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		Message message = new Message(user, msg, text, date, id);
		JSONObject object = addMsg(message, new JSONObject());
		System.out.println(object);
		return responseFile(path, object);

	}

	public File edit(String projectName, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		String path = EDIT_PATH + getProjectData(projectName);
		return editor(path, user, msg, text, date, id);
	}

	public File edit(Project project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return edit(getProjectData(project), user, msg, text, date, id);
	}

	public File edit(long project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return edit(getProjectData(project), user, msg, text, date, id);
	}

	public File edit(String channel, String nick, String project, User user, String msg, String text, Date date,
			String id) throws ResponseError, ForbiddenResponse {
		return edit(getProjectData(channel, nick, project), user, msg, text, date, id);
	}

	public File undo(String projectName, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		String path = UNDO_PATH + getProjectData(projectName);
		return editor(path, user, msg, text, date, id);
	}
	
	public File undo(Project project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return undo(getProjectData(project), user, msg, text, date, id);
	}

	public File undo(long project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return undo(getProjectData(project), user, msg, text, date, id);
	}

	public File undo(String channel, String nick, String project, User user, String msg, String text, Date date,
			String id) throws ResponseError, ForbiddenResponse {
		return undo(getProjectData(channel, nick, project), user, msg, text, date, id);
	}
	
	public File delete(String projectName, User user, String msg, Date date, String id, List<String> classes,
			List<String> features, List<String> unkown)
			throws ResponseError, ForbiddenResponse {
		String path = DELETE_EDITOR_PATH + getProjectData(projectName);
		JSONObject object = new JSONObject();
		JSONArray classesArray = new JSONArray();
		for (String s: classes) {
			classesArray.put(s);
		}
		object.put("class", classesArray);
		JSONArray featuresArray = new JSONArray();
		for (String s: features) {
			featuresArray.put(s);
		}
		object.put("feature", featuresArray);
		
		JSONArray unknowArray = new JSONArray();
		for (String s: unkown) {
			unknowArray.put(s);
		}
		object.put("unknow", unknowArray);
		
		String text = object.toString();
		
		return editor(path, user, msg,text ,date, id);
	}
	public File delete(Project project, User user, String msg, Date date, String id, List<String> classes, List<String> features, List<String> unkown)
			throws ResponseError, ForbiddenResponse {
		return delete(getProjectData(project), user, msg, date, id, classes, features, unkown);
	}
	
	public File delete(long project, User user, String msg, Date date, String id, List<String> classes, List<String> features, List<String> unkown)
			throws ResponseError, ForbiddenResponse {
		return delete(getProjectData(project), user, msg, date, id, classes, features, unkown);
	}

	public File delete(String channel, String nick, String project, User user, String msg, Date date,
			String id, List<String> classes, List<String> features, List<String> unkown) throws ResponseError, ForbiddenResponse {
		return delete(getProjectData(channel, nick, project), user, msg, date, id, classes, features, unkown);
	}
	
	
	public File add(String projectName, User user, String msg, Date date, String id, JSONObject object)
			throws ResponseError, ForbiddenResponse {
		String path = ADD_EDITOR_PATH + getProjectData(projectName);
		String text = object.toString();
		
		return editor(path, user, msg,text ,date, id);
	}
	public File add(Project project, User user, String msg, Date date, String id,JSONObject object)
			throws ResponseError, ForbiddenResponse {
		return add(getProjectData(project), user, msg, date, id, object);
	}
	
	public File add(long project, User user, String msg, Date date, String id, JSONObject object)
			throws ResponseError, ForbiddenResponse {
		return add(getProjectData(project), user, msg, date, id, object);
	}

	public File add(String channel, String nick, String project, User user, String msg, Date date,
			String id,JSONObject object) throws ResponseError, ForbiddenResponse {
		return add(getProjectData(channel, nick, project), user, msg, date, id, object);
	}
	
	

	public File redo(String projectName, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		String path = REDO_PATH + getProjectData(projectName);
		return editor(path, user, msg, text, date, id);
	}

	public File redo(Project project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return redo(getProjectData(project), user, msg, text, date, id);
	}

	public File redo(long project, User user, String msg, String text, Date date, String id)
			throws ResponseError, ForbiddenResponse {
		return redo(getProjectData(project), user, msg, text, date, id);
	}

	public File redo(String channel, String nick, String project, User user, String msg, String text, Date date,
			String id) throws ResponseError, ForbiddenResponse {
		return redo(getProjectData(channel, nick, project), user, msg, text, date, id);
	}

	public String[] help() throws ResponseError, ForbiddenResponse {
		JSONObject object = responseJSON(HELP_PATH, null);

		String[] ret = new String[2];
		ret[0] = object.getString("text");
		ret[1] = object.getString("url");
		return ret;
	}

	public Project newProject(String projecName, User user, Visibility visibility)
			throws ResponseError, ForbiddenResponse {
		String path = NEW_PROJECT + getProjectData(projecName) +"/"+ visibility.toString().toLowerCase();
		return newProjectp(path, user);
	}

	public Project newProject(String projecName, User user) throws ResponseError, ForbiddenResponse {
		String path = NEW_PROJECT + getProjectData(projecName);
		return newProjectp(path, user);
	}

	private Project newProjectp(String path, User user) throws ResponseError, ForbiddenResponse {
		JSONObject object = addUser(user, new JSONObject());
		return responseProject(path, object);

	}

	public String removeProject(String projectName, User user) throws ResponseError, ForbiddenResponse {
		String path = REMOVE_PROJECT + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		return responseText(path, object);
	}

	public String removeProject(Project project, User user) throws ResponseError, ForbiddenResponse {
		return removeProject(Long.toString(project.getId()), user);
	}

	public String removeProject(long project, User user) throws ResponseError, ForbiddenResponse {
		return removeProject(getProjectData(project), user);
	}

	public String removeProject(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return removeProject(getProjectData(channel, nick, project), user);
	}

	public Project changeVisibility(String projectName, User user, Visibility visibility)
			throws ResponseError, ForbiddenResponse {
		String path = VISIBILITY_PROJECT + getProjectData(projectName) + "/" + visibility.name().toLowerCase();
		JSONObject object = addUser(user, new JSONObject());
		return responseProject(path, object);
	}

	public Project changeVisibility(Project project, User user, Visibility visibility)
			throws ResponseError, ForbiddenResponse {
		return changeVisibility(getProjectData(project), user, visibility);
	}

	public Project changeVisibility(long project, User user, Visibility visibility)
			throws ResponseError, ForbiddenResponse {
		return changeVisibility(getProjectData(project), user, visibility);
	}

	public Project changeVisibility(String channel, String nick, String project, User user, Visibility visibility)
			throws ResponseError, ForbiddenResponse {
		return changeVisibility(getProjectData(channel, nick, project), user, visibility);
	}

	public String validate(String projectName, User user) throws ResponseError, ForbiddenResponse {
		String path = VALIDATE_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		return responseText(path, object);
	}

	public String validate(Project project, User user) throws ResponseError, ForbiddenResponse {
		return validate(getProjectData(project), user);
	}

	public String validate(long project, User user) throws ResponseError, ForbiddenResponse {
		return validate(getProjectData(project), user);
	}

	public String validate(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return validate(getProjectData(channel, nick, project), user);
	}

	public Project addUserToProject(String projectName, User user, User userToSearch, boolean edit)
			throws ResponseError, ForbiddenResponse {
		String path = ADD_USER_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		object = addUser(userToSearch, object, "userToSearch");
		if (edit) {
			object.put("access", "edit");
		} else {
			object.put("access", "read");
		}
		return responseProject(path, object);
	}

	public Project addUserToProject(Project project, User user, User userToSearch, boolean edit)
			throws ResponseError, ForbiddenResponse {
		return addUserToProject(getProjectData(project), user, userToSearch, edit);
	}

	public Project addUserToProject(long project, User user, User userToSearch, boolean edit)
			throws ResponseError, ForbiddenResponse {
		return addUserToProject(getProjectData(project), user, userToSearch, edit);
	}

	public Project addUserToProject(String channel, String nick, String project, User user, User userToSearch,
			boolean edit) throws ResponseError, ForbiddenResponse {
		return addUserToProject(getProjectData(channel, nick, project), user, userToSearch, edit);
	}

	public Project removeUserFromProject(String projectName, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		String path = REMOVE_USER_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		object = addUser(userToSearch, object, "userToSearch");

		return responseProject(path, object);
	}

	public Project removeUserFromProject(Project project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return removeUserFromProject(getProjectData(project), user, userToSearch);
	}

	public Project removeUserFromProject(long project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return removeUserFromProject(getProjectData(project), user, userToSearch);
	}

	public Project removeUserFromProject(String channel, String nick, String project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return removeUserFromProject(getProjectData(channel, nick, project), user, userToSearch);
	}

	public Project updateUserInProject(String projectName, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		String path = UPDATE_USER_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		object = addUser(userToSearch, object, "userToSearch");

		return responseProject(path, object);
	}

	public Project updateUserInProject(Project project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return updateUserInProject(getProjectData(project), user, userToSearch);
	}

	public Project updateUserInProject(long project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return updateUserInProject(getProjectData(project), user, userToSearch);
	}

	public Project updateUserInProject(String channel, String nick, String project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return updateUserInProject(getProjectData(channel, nick, project), user, userToSearch);
	}

	public File newBranch(String projectName, User user, String branchName, String groupName)
			throws ResponseError, ForbiddenResponse {
		String path = NEW_BRANCH_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		object.put("branchName", branchName);
		object.put("branchGroup", groupName);
		return responseFile(path, object);
	}

	public File newBranch(Project project, User user, String branchName, String groupName)
			throws ResponseError, ForbiddenResponse {
		return newBranch(getProjectData(project), user, branchName, groupName);
	}

	public File newBranch(long project, User user, String branchName, String groupName)
			throws ResponseError, ForbiddenResponse {
		return newBranch(getProjectData(project), user, branchName, groupName);
	}

	public File newBranch(String channel, String nick, String project, User user, String branchName, String groupName)
			throws ResponseError, ForbiddenResponse {
		return newBranch(getProjectData(channel, nick, project), user, branchName, groupName);
	}

	public Project branchGroup(String projectName, User user, String groupName)
			throws ResponseError, ForbiddenResponse {
		String path = BRANCHGROUP_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		object.put("branchGroup", groupName);
		return responseProject(path, object);
	}

	public Project branchGroup(Project project, User user, String groupName)
			throws ResponseError, ForbiddenResponse {
		return branchGroup(getProjectData(project), user, groupName);
	}

	public Project branchGroup(long project, User user, String groupName)
			throws ResponseError, ForbiddenResponse {
		return branchGroup(getProjectData(project), user, groupName);
	}

	public Project branchGroup(String channel, String nick, String project, User user, String groupName)
			throws ResponseError, ForbiddenResponse {
		return branchGroup(getProjectData(channel, nick, project), user, groupName);
	}
	
	private List<Message> history(String projectName, User user, JSONObject object)
			throws ResponseError, ForbiddenResponse {
		String path = HISTORY_PATH + getProjectData(projectName);
		object = addUser(user, object);
		return responseMsgList(path, object);
	}

	public List<Message> history(String projectName, User user, Date startDate, Date endDate)
			throws ResponseError, ForbiddenResponse {

		JSONObject object = new JSONObject();

		if (startDate != null) {
			object.put("startDate", startDate.getTime());
			if (endDate != null) {
				object.put("endDate", endDate.getTime());
			}
		}
		return history(getProjectData(projectName), user, object);
	}

	public List<Message> history(Project project, User user, Date startDate, Date endDate)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, startDate, endDate);
	}

	public List<Message> history(long project, User user, Date startDate, Date endDate)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, startDate, endDate);
	}

	public List<Message> history(String channel, String nick, String project, User user, Date startDate, Date endDate)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(channel, nick, project), user, startDate, endDate);
	}

	public List<Message> history(String projectName, User user, String actionElement, boolean isAction)
			throws ResponseError, ForbiddenResponse {

		JSONObject object = new JSONObject();

		if (actionElement != null) {
			if (isAction) {
				object.put("action", actionElement);
			} else {
				object.put("element", actionElement);
			}
		}
		return history(getProjectData(projectName), user, object);
	}

	public List<Message> history(Project project, User user, String actionElement, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, actionElement, isAction);
	}

	public List<Message> history(long project, User user, String actionElement, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, actionElement, isAction);
	}

	public List<Message> history(String channel, String nick, String project, User user, String actionElement,
			boolean isAction) throws ResponseError, ForbiddenResponse {
		return history(getProjectData(channel, nick, project), user, actionElement, isAction);
	}

	public List<Message> history(String projectName, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {

		JSONObject object = new JSONObject();

		if (userToSearch != null) {
			object = addUser(userToSearch, object, "userToSearch");
		}
		return history(getProjectData(projectName), user, object);
	}

	public List<Message> history(Project project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, userToSearch);
	}

	public List<Message> history(long project, User user, User userToSearch) throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user, userToSearch);
	}

	public List<Message> history(String channel, String nick, String project, User user, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(channel, nick, project), user, userToSearch);
	}

	public List<Message> history(String projectName, User user) throws ResponseError, ForbiddenResponse {

		JSONObject object = new JSONObject();
		return history(getProjectData(projectName), user, object);
	}

	public List<Message> history(Project project, User user) throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user);
	}

	public List<Message> history(long project, User user) throws ResponseError, ForbiddenResponse {
		return history(getProjectData(project), user);
	}

	public List<Message> history(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return history(getProjectData(channel, nick, project), user);
	}

	public File projectHistory(String projectName, User user) throws ResponseError, ForbiddenResponse {

		String path = HISTORY_PROJECT_PATH + getProjectData(projectName);
		JSONObject object = addUser(user, new JSONObject());
		return responseFile(path, object);
	}

	public File projectHistory(Project project, User user) throws ResponseError, ForbiddenResponse {
		return projectHistory(getProjectData(project), user);
	}

	public File projectHistory(long project, User user) throws ResponseError, ForbiddenResponse {
		return projectHistory(getProjectData(project), user);
	}

	public File projectHistory(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return projectHistory(getProjectData(channel, nick, project), user);
	}

	public List<Project> projects() throws ResponseError, ForbiddenResponse {

		return responseProjectList(PROJECT_PATH, null);
	}

	public Project project(String projectName) throws ResponseError, ForbiddenResponse {

		String path = PROJECT_INFO_PATH + getProjectData(projectName);
		return responseProject(path, null);
	}
	public JSONObject elemets(Project project) throws ResponseError, ForbiddenResponse {
		String path = PROJECT_ELEMEMTS_PATH + getProjectData(project);
		return responseJSON(path, null);
	}
	
	public Project project(Project project) throws ResponseError, ForbiddenResponse {
		return project(getProjectData(project));
	}

	public Project project(long project) throws ResponseError, ForbiddenResponse {
		return project(getProjectData(project));
	}

	public Project project(String channel, String nick, String project) throws ResponseError, ForbiddenResponse {
		return project(getProjectData(channel, nick, project));
	}

	public List<Project> projects(User user) throws ResponseError, ForbiddenResponse {
		String path = PROJECT_PATH + getUserPath(user);
		return responseProjectList(path, null);
	}

	public List<Project> projects(User user, boolean editAccess) throws ResponseError, ForbiddenResponse {
		String path;
		if (editAccess) {
			path = PROJECT_EDIT_PATH + getUserPath(user);
		} else {
			path = PROJECT_READ_PATH + getUserPath(user);
		}
		return responseProjectList(path, null);
	}

	private String getUserPath(User user) {
		if (user.getId()==-1) {
			return user.getChannel() + "/" + user.getNick();
		}else {
			return user.getChannel() + "/" + user.getId();
		}
	}
	
	public List<Project> projects(Visibility visibility) throws ResponseError, ForbiddenResponse {
		String path = PROJECT_PATH + visibility.name().toLowerCase();
		return responseProjectList(path, null);
	}



	private File statistics(String projectName, JSONObject object, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		String path;
		if (isAction) {
			path = STATISTICS_ACTIONS_PATH + getProjectData(projectName);
		} else {
			path = STATISTICS_MESSAGES_PATH + getProjectData(projectName);
		}
		return responseFile(path, object);
	}

	public File statistics(String projectName, User user, boolean isAction, boolean absolute)
			throws ResponseError, ForbiddenResponse {
		JSONObject object = addUser(user, new JSONObject());
		object.put("absolute", absolute);
		return statistics(getProjectData(projectName), object, isAction);
	}

	public File statistics(Project project, User user, boolean isAction, boolean absolute)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction, absolute);
	}

	public File statistics(long project, User user, boolean isAction, boolean absolute)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction, absolute);
	}

	public File statistics(String channel, String nick, String project, User user, boolean isAction, boolean absolute)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(channel, nick, project), user, isAction, absolute);
	}

	public File statistics(String projectName, User user, boolean isAction, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		JSONObject object = addUser(user, new JSONObject());
		object= addUser(userToSearch, object, "userToSearch");
		return statistics(getProjectData(projectName), object, isAction);
	}

	public File statistics(Project project, User user, boolean isAction, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction, userToSearch);
	}

	public File statistics(long project, User user, boolean isAction, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction, userToSearch);
	}

	public File statistics(String channel, String nick, String project, User user, boolean isAction, User userToSearch)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(channel, nick, project), user, isAction, userToSearch);
	}
	
	public File statistics(String projectName, User user, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		JSONObject object = addUser(user, new JSONObject());
		return statistics(getProjectData(projectName), object, isAction);
	}

	public File statistics(Project project, User user, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction);
	}

	public File statistics(long project, User user, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(project), user, isAction);
	}

	public File statistics(String channel, String nick, String project, User user, boolean isAction)
			throws ResponseError, ForbiddenResponse {
		return statistics(getProjectData(channel, nick, project), user, isAction);
	}
	
	public File statisticsAllActions(String projectName, User user)
			throws ResponseError, ForbiddenResponse {
		String path=STATISTICS_ALLACTIONS_PATH+getProjectData(projectName);
		JSONObject object= addUser(user, new JSONObject());
		return responseFile(path, object);
	}

	public File statisticsAllActions(Project project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAllActions(getProjectData(project), user);
	}

	public File statisticsAllActions(long project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAllActions(getProjectData(project), user);
	}

	public File statisticsAllActions(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAllActions(getProjectData(channel, nick, project), user);
	}
	
	public File statisticsAuthorship(String projectName, User user)
			throws ResponseError, ForbiddenResponse {
		String path=STATISTICS_AUTHORSHIP_PATH+getProjectData(projectName);
		JSONObject object= addUser(user, new JSONObject());
		return responseFile(path, object);
	}

	public File statisticsAthorship(Project project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAuthorship(getProjectData(project), user);
	}

	public File statisticsAthorship(long project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAuthorship(getProjectData(project), user);
	}

	public File statisticsAthorship(String channel, String nick, String project, User user)
			throws ResponseError, ForbiddenResponse {
		return statisticsAuthorship(getProjectData(channel, nick, project), user);
	}
	
	
	private String getProjectData(Project project) {
		return getProjectData(project.getId());
	}

	private String getProjectData(long id) {
		return Long.toString(id);
	}
	private String getProjectData(String projectName) {
		return projectName.replace(" ", "");
	}

	private String getProjectData(String channel, String nick, String name) {
		return channel + "/" + nick + "/" + name;
	}
	
	public String register(String channel) throws ResponseError, ForbiddenResponse {
		String path = REGISTER + channel;
		return responseText(path, null);
	}
	
	public List<Project> getUpdates(String channel) throws ResponseError, ForbiddenResponse{
		String path = GET_UPDATES + channel;
		return responseProjectList(path, null);
	}
	
	public List<Message> getUpdate(String channel, Project p) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(p);
		return getUpdate(channel, path);
	}
	public List<Message> getUpdate(String channel, long p) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(p);
		return getUpdate(channel, path);
	}
	public List<Message> getUpdate(String channel, String projectchannel, String user, String pname) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(projectchannel, user, pname);
		return getUpdate(channel, path);
	}
	private List<Message> getUpdate(String channel, String path) throws ResponseError, ForbiddenResponse {
		String path1 = GET_UPDATE + channel +"/" + path;
		return responseMsgList(path1, null);

	}
	
	public File getLastFile(Project p) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(p);
		return getLastFile( path);
	}
	public File getLastFile(long p) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(p);
		return getLastFile (path);
	}
	public File getLastFile(String projectchannel, String user, String pname) throws ResponseError, ForbiddenResponse {
		String path = getProjectData(projectchannel, user, pname);
		return getLastFile(path);
	}
	private File getLastFile(String path) throws ResponseError, ForbiddenResponse {
		String path1 = GET_LAST_FILE + path;
		return responseFile(path1, null);

	}

	public File setChoice (String projectName, User user, String branchGroup, String branchChannel, String branchUser, String branchName, String messageId)  throws ResponseError, ForbiddenResponse  {
		String path=SET_CHOICE+getProjectData(projectName)+"/"+branchGroup;
		JSONObject object= addUser(user, new JSONObject());
		object.put("branchChannel", branchChannel);
		object.put("branchUser", branchUser);
		object.put("branchName", branchName);
		object.put("messageId", messageId);
		return responseFile(path, object);
	}
	public File setChoice(Project p,  User user, String branchGroup, String branchChannel, String branchUser, String branchName, String messageId) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(p);
		return setChoice( projectName,user, branchGroup, branchChannel, branchUser, branchName, messageId);
	}
	public File setChoice(long p,  User user, String branchGroup, String branchChannel, String branchUser, String branchName, String messageId) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(p);
		return setChoice (projectName,user, branchGroup, branchChannel, branchUser, branchName, messageId);
	}
	public File setChoice(String projectchannel, String user, String pname,  User user1, String branchGroup, String branchChannel, String branchUser, String branchName, String messageId) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(projectchannel, user, pname);
		return setChoice(projectName,user1, branchGroup, branchChannel, branchUser, branchName, messageId);
	}
	
	public String setPoll (String projectName,  User user, String branchGroup, Map<Integer, String> preference)  throws ResponseError, ForbiddenResponse  {
		String path=SET_POLL+getProjectData(projectName)+"/"+branchGroup;
		JSONObject object= addUser(user, new JSONObject());
		JSONObject order= new JSONObject();
		for (int i : preference.keySet()) {
			order.put(Integer.toString(i), preference.get(i));
		}
		object.put("order", order);
		return responseText(path, object);
	}
	public String setPoll(Project p,  User user, String branchGroup, Map<Integer, String> preference) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(p);
		return setPoll( projectName,user, branchGroup, preference);
	}
	public String setPoll(long p,   User user, String branchGroup, Map<Integer, String> preference) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(p);
		return setPoll (projectName,user, branchGroup, preference);
	}
	
	public String setPoll(String projectchannel, String puser, String pname,  User user, String branchGroup, Map<Integer, String> preference) throws ResponseError, ForbiddenResponse {
		String projectName = getProjectData(projectchannel, puser, pname);
		return setPoll(projectName,user, branchGroup,preference);
	}

	public List<Polling> getPolling(String channelName) throws ResponseError, ForbiddenResponse{
		String path = GET_POLL + channelName;
		JSONObject object = responseJSON(path, null);
		List<Polling> ret = new ArrayList<>();
		JSONArray array = object.getJSONArray("polls");
		for (int i =0; i<array.length(); i++) {
			ret.add(Polling.createPolling(array.getJSONObject(i)));
		}
		return ret;
	}

	public List<EndConsensus> getEndConsensus(String channelName)throws ResponseError, ForbiddenResponse {
		String path = GET_END_POLL + channelName;
		JSONObject object = responseJSON(path, null);
		List<EndConsensus> ret = new ArrayList<>();
		JSONArray array = object.getJSONArray("polls");
		for (int i =0; i<array.length(); i++) {
			ret.add(EndConsensus.createEndConsensus(array.getJSONObject(i)));
		}
		return ret;
	}
	
	public File consensus (String projectName,  User user, List<User> usersToSearch, String branchGroup, String messageId)throws ResponseError, ForbiddenResponse  {
		String path=CONSENSUS+getProjectData(projectName)+"/"+branchGroup;
		JSONObject object= addUser(user, new JSONObject());
		JSONArray array = new JSONArray();
		for (User u: usersToSearch) {
			array.put(addUser(u, new JSONObject()));
		}
		object.put("usersToSearch", array);
		object.put("messageId", messageId);
		return responseFile(path, object);
	}
	public File consensus (Project p,  User user, List<User> usersToSearch, String branchGroup, String messageId)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(p);
		return consensus(projectName, user, usersToSearch, branchGroup, messageId);
	}
	public File consensus (long p,  User user, List<User> usersToSearch, String branchGroup, String messageId)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(p);
		return consensus(projectName, user, usersToSearch, branchGroup, messageId);
	}
	public File consensus (String projectchannel, String puser, String pname,  User user, List<User> usersToSearch, String branchGroup, String messageId)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(projectchannel, puser, pname);
		return consensus(projectName, user, usersToSearch, branchGroup, messageId);
	}
	
	public Polling startPoll (String projectName,  User user, String branchGroup)throws ResponseError, ForbiddenResponse  {
		String path=START_POLL+getProjectData(projectName)+"/"+branchGroup;
		JSONObject object= addUser(user, new JSONObject());
		JSONObject polling = responseJSON(path, object);
		return Polling.createPolling(polling);
	}
	public Polling startPoll (Project p,  User user, String branchGroup)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(p);
		return startPoll(projectName, user,  branchGroup);
	}
	public Polling startPoll (long p,  User user, String branchGroup)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(p);
		return startPoll(projectName, user,  branchGroup);
	}
	public Polling startPoll (String projectchannel, String puser, String pname,  User user, String branchGroup)throws ResponseError, ForbiddenResponse  {
		String projectName = getProjectData(projectchannel, puser, pname);
		return startPoll(projectName, user,  branchGroup);
	}
}
