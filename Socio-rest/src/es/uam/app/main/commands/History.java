package es.uam.app.main.commands;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.impl.ProjectImpl;

@Path("/history")
public class History extends MainCommand implements DataFormat {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response history(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id) {
		try {
			Project actual = getProject(context, id);
			return history(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("history: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response history(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user,
			@PathParam("project") String project) {
		try {
			Project actual = getProject(context, channel, user, project);
			return history(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("history: ", e);
			return sendTextException(e);
		}
	}

	public static final String ERROR_MENSAGE = "I don't fine history for this parametres:";
	public static final String ERROR_MENSAGE2_START = "The project ";
	public static final String ERROR_MENSAGE2_END = " is empty.";
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	private Response history(@Context ServletContext context, InputStream incomingData, Project actual)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}

		long dateStart = getLong(object, "startDate");
		long dateEnd = getLong(object, "endDate");
		String action = getString(object, "action");
		String element = getString(object, "element");
		User user2Search;
		try {
			user2Search = getUser(context, object, "userToSearch");
		} catch (InternalException e) {
			user2Search = null;
		}
		JSONObject history = history(context, user, user2Search, dateStart, dateEnd, action, element, actual);

		return Response.ok(history.toString(), MediaType.APPLICATION_JSON).build();

	}

	public static JSONObject history(@Context ServletContext context, User user, User user2Search, long dateStart,
			long dateEnd, String action, String element, Project actual) throws Exception {
		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}

		String error;
		List<Msg> msgList;
		if (dateStart != -1) {
			Date start = new Date(dateStart);
			String startFormat = formatter.format(start);
			if (dateEnd != -1) {
				Date end = new Date(dateEnd);
				String endFormat = formatter.format(end);
				error = ERROR_MENSAGE + " from: " + startFormat + " to: " + endFormat;
				if (start.before(end)) {
					msgList = actual.getHistoryMsg(start, end, ProjectImpl.ASCENDING);
				} else {
					msgList = actual.getHistoryMsg(end, start, ProjectImpl.DESCENDING);
				}
			} else {
				error = ERROR_MENSAGE + " from: " + startFormat;
				msgList = actual.getHistoryMsg(start, ProjectImpl.ASCENDING);
			}
		} else if (action != null && !action.isEmpty()) {
			msgList = actual.getHistoryForAction(action);
			error = ERROR_MENSAGE + " action= " + action;
		} else if (element != null && !element.isEmpty()) {
			msgList = actual.getHistoryForElement(element);
			error = ERROR_MENSAGE + " element= " + element;
		} else if (user2Search != null) {
			msgList = actual.getHistoryForUser(user2Search);
			error = ERROR_MENSAGE + " usernick= " + user2Search.getChannel() + "/" + user2Search.getNick();
		} else {
			error = ERROR_MENSAGE2_START + actual.getName() + ERROR_MENSAGE2_END;
			msgList = actual.getHistoryMsg();
		}

		if (msgList.isEmpty()) {
			throw new InternalException(error);
		} else {

			return DataFormat.getMsgListJSON(msgList);
		}

	}

	public static JSONObject history(@Context ServletContext context, com.socio.client.beans.User user,
			com.socio.client.beans.User user2Search, long dateStart, long dateEnd, String action, String element,
			String pChannel, String pUser, String pName) throws Exception {
		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		User u2s;
		try {
			u2s = getUser(context, user2Search.getChannel(), user2Search.getNick(), user2Search.getId(),
					user2Search.getName());
		} catch (Exception e) {
			u2s = null;
		}
		return history(context, u, u2s, dateStart, dateEnd, action, element, actual);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("project/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response projectHistory(@Context ServletContext context, InputStream incomingData,
			@PathParam("id") long id) {
		try {
			Project actual = getProject(context, id);
			return projectHistory(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectHistory: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("project/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response projectHistory(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user,
			@PathParam("project") String project) {
		try {
			Project actual = getProject(context, channel, user, project);
			return projectHistory(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectHistory: ", e);
			return sendTextException(e);
		}
	}

	private Response projectHistory(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		File png = projectHistory(context, user, actual);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}

	public static File projectHistory(ServletContext context, User user, Project actual) throws Exception {

		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}

		File png = actual.getProjectHistory();
		return png;
	}

	public static File projectHistory(ServletContext context, com.socio.client.beans.User user, String pChannel,
			String pUser, String pName) throws Exception {
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		Project actual = getProject(context, pChannel, pUser, pName);
		return projectHistory(context, u, actual);
	}
}
