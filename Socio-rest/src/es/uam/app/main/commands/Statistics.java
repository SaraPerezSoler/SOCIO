package es.uam.app.main.commands;

import java.io.File;
import java.io.InputStream;

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
import socioProjects.Project;
import socioProjects.User;

@Path("/statistics")
public class Statistics extends MainCommand {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/allactions/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response allActions(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return allActions(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("allActions: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/allactions/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response allActions(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return allActions(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("allActions: ", e);
			return sendTextException(e);
		}
	}

	private Response allActions(@Context ServletContext context, InputStream incomingData, Project actual)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, null);
		File jpg = allActions(context, actual, user);
		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();

	}
	
	public static File allActions(@Context ServletContext context,  Project actual, User user)
			throws Exception {

		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}
		File jpg = actual.getStatisticsActions();
		return jpg;

	}
	
	public static File allActions(@Context ServletContext context,  String pChannel, String pUser, String pName, com.socio.client.beans.User user)
			throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		return allActions(context, actual, u);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/actions/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response actions(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return actionsMessages(context, incomingData, actual, true);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("actions: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/actions/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response actions(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return actionsMessages(context, incomingData, actual, true);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("actions: ", e);
			return sendTextException(e);
		}
	}

	private Response actionsMessages(ServletContext context, InputStream incomingData, Project actual, boolean isAction)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, null);
		User user2Search;
		
		boolean abs;
		if (object.isNull("absolute")) {
			abs = false;
		} else {
			abs = object.getBoolean("absolute");
		}
			
		try {
			user2Search = getUser(context, object, "userToSearch");
		}catch (InternalException e) {
			user2Search=null;
		}
		
		File jpg = actionsMessages(context, actual, isAction, user, user2Search, abs);
		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();
		
	}
	
	public static File actionsMessages(ServletContext context, Project actual, boolean isAction, User user, User user2Search, boolean abs)
			throws Exception {

		
		File jpg;
		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}

		if (user2Search == null) {

			if (abs) {
				if (isAction) {
					jpg = actual.getStatisticsUserActionAbs();
				} else {
					jpg = actual.getStatisticsUserMsgAbs();
				}
			} else {
				if (isAction) {
					jpg = actual.getStatisticsUserAction();
				} else {
					jpg = actual.getStatisticsUserMsg();
				}
			}
		} else {
			if (isAction) {
				jpg = actual.getStatisticsUserAction(user2Search);
			} else {
				jpg = actual.getStatisticsUserMsg(user2Search);
			}
		}

		return jpg;
	}
	
	public static File actionsMessages(ServletContext context, String pChannel, String pUser, String pName, boolean isAction, com.socio.client.beans.User user, com.socio.client.beans.User user2Search, boolean abs)
			throws Exception {
		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		User u2s = getUser(context, user2Search.getChannel(), user2Search.getNick(), user2Search.getId(), user2Search.getName());
		return actionsMessages(context, actual, isAction, u, u2s, abs);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/authorship/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response authorship(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return authorship(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("authorship: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/authorship/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response authorship(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return authorship(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("authorship: ", e);
			return sendTextException(e);
		}
	}

	private Response authorship(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		User user = getUser(context, incomingData, null);
		File jpg = authorship(context, actual, user);
		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();
	}

	
	public static File authorship(ServletContext context, Project actual, User user) throws Exception {

		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}
		File jpg = actual.percentOfAuthorship();
		return jpg;
	}
	
	public static File authorship(ServletContext context,  String pChannel, String pUser, String pName, com.socio.client.beans.User user) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		return authorship(context, actual, u);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/messages/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response messages(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return actionsMessages(context, incomingData, actual, false);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("messages: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/messages/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response messages(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return actionsMessages(context, incomingData, actual, false);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("messages: ", e);
			return sendTextException(e);
		}
	}

}
