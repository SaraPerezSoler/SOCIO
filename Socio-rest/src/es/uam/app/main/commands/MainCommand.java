package es.uam.app.main.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;


import es.uam.app.main.SocioData;
import es.uam.app.main.ValidText;
import es.uam.app.main.exceptions.InternalException;
import projectHistory.Msg;
import projectHistory.ProjectHistoryFactory;
import socioProjects.Project;
import socioProjects.SocioProjectsFactory;
import socioProjects.User;

public abstract class MainCommand implements DataFormat {
	private static final char[] validProjectCharacteres = { '_', '/' };
	// protected ObjectMapper mapper = new ObjectMapper();

	protected static String validProjectName(String text) {
		return ValidText.validText(text, validProjectCharacteres);
	}

	protected JSONObject readRequest(InputStream incomingData) {
		String text = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				text += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONObject(text);
	}

	protected String getString(JSONObject object, String data) throws Exception {
		;
		if (data == null || data.isEmpty()) {
			return "";
		}
		if (object.isNull(data)) {
			return "";
		}
		return object.getString(data);
	}

	protected int getInt(JSONObject object, String data) throws Exception {

		if (data == null || data.isEmpty()) {
			return -1;
		}
		if (object.isNull(data)) {
			return -1;
		}
		return object.getInt(data);
	}

	protected long getLong(JSONObject object, String data) throws Exception {

		if (data == null || data.isEmpty()) {
			return -1;
		}
		if (object.isNull(data)) {
			return -1;
		}
		return object.getLong(data);
	}

	protected User getUser(ServletContext context, InputStream incomingData, String userName) throws Exception {
		JSONObject object = readRequest(incomingData);
		return getUser(context, object, userName);
	}

	protected User getUser(ServletContext context, JSONObject object, String userName) throws Exception {
		if (userName == null || userName.isEmpty()) {
			userName = "user";
		}
		if (object.isNull(userName)) {
			if (userName.equals("user")) {
				return getUser(context, object);
			} else {
				throw new InternalException("The user is not specified");
			}
		}
		return getUser(context, object.getJSONObject(userName));
	}

	private User getUser(ServletContext context, JSONObject object) throws Exception {
		if (object.isNull("channel")) {
			throw new InternalException("All users need a channel");
		} else {
			if (object.isNull("nick") && object.isNull("id")) {
				throw new InternalException("All users need a id or a nick");
			}
		}

		String name = "";
		if (!object.isNull("name")) {
			name = object.getString("name");
		}
		String nick = "";
		if (!object.isNull("nick")) {
			nick = object.getString("nick");
		}
		String channel = object.getString("channel");
		long id = -1;
		if (!object.isNull("id")) {
			id = object.getLong("id");
		}

		return getUser(context, channel, nick, id, name);
	}

	protected Msg getMsg(ServletContext context, InputStream incomingData, String data)
			throws JSONException, Exception {
		JSONObject object = readRequest(incomingData);
		if (data == null) {
			data = "message";
		}
		if (object.isNull(data)) {
			return getMsg(context, object);
		}
		return getMsg(context, object.getJSONObject(data));
	}

	private Msg getMsg(ServletContext context, JSONObject object) throws JSONException, Exception {

		User user = getUser(context, object.getJSONObject("user"));

		Msg msg = ProjectHistoryFactory.eINSTANCE.createMsg();
		if (object.isNull("id") || object.isNull("msg") || object.isNull("date")) {
			throw new InternalException("Malformed message, it needs id, msg, date and user");
		}
		msg.setId(object.getString("id"));
		msg.setMsg(object.getString("msg"));
		msg.setUser(user);
		msg.setDate(new Date(object.getLong("date")));
		msg.setText(object.getString("text"));
		return msg;

	}

	protected static Msg getMsg(String id, String message, User user, long date, String text) {
		Msg msg = ProjectHistoryFactory.eINSTANCE.createMsg();
		msg.setId(id);
		msg.setMsg(message);
		msg.setUser(user);
		msg.setDate(new Date(date));
		msg.setText(text);
		return msg;
	}

	protected Project getProject(ServletContext context, long id) throws Exception {
		Project project = SocioData.getSocioData(context).getProject(id);
		if (project == null) {
			throw new InternalException("The project with the id " + id + " doesn't exists");
		}
		return project;

	}

	protected static Project getProject(ServletContext context, String channel, String user, String project)
			throws Exception {
		User user1 = SocioData.getSocioData(context).getUser(user, channel);
		Project p = SocioData.getSocioData(context).getProject(project, user1);
		if (p == null) {
			throw new InternalException("The project " + channel + "/" + user + "/" + project + " doesn't exists");
		}
		return p;
	}

	protected static User getUser(ServletContext context, String channel, String nick, long id, String name)
			throws InternalException, Exception {
		User u = SocioProjectsFactory.eINSTANCE.createUser();
		u.setChannel(channel);
		u.setId(id);
		u.setName(name);
		u.setNick(nick);
		u = SocioData.getSocioData(context).addUser(u);
		return u;
	}

	protected Response sendTextException(InternalException e) {
		return Response.ok(e.getMessage(), MediaType.TEXT_PLAIN).status(Status.FORBIDDEN).build();
	}

	protected Response sendTextException(Exception e) {
		return Response.ok(e.getMessage(), MediaType.TEXT_PLAIN).status(Status.INTERNAL_SERVER_ERROR).build();
	}
	protected static String normalizeString(String text) {
		String stringNormalize = Normalizer.normalize(text, Normalizer.Form.NFD);   
		stringNormalize = stringNormalize.replaceAll("[^\\p{ASCII}]", "");
		return stringNormalize;

	}
}
