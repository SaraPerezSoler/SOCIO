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
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return allActions(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/allactions/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response allActions(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return allActions(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	private Response allActions(@Context ServletContext context, InputStream incomingData, Project actual)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, null);

		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}
		File jpg = actual.getStatisticsActions();
		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/actions/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response actions(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return actionsMessages(context, incomingData, actual, true);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/actions/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response actions(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return actionsMessages(context, incomingData, actual, true);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	private Response actionsMessages(ServletContext context, InputStream incomingData, Project actual, boolean isAction)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, null);
		User user2Search;
		try {
			user2Search = getUser(context, object, "userToSearch");
		}catch (InternalException e) {
			user2Search=null;
		}
		File jpg;
		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}

		if (user2Search == null) {
			boolean abs;
			if (object.isNull("absolute")) {
				abs = false;
			} else {
				abs = object.getBoolean("absolute");
			}
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

		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/authorship/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response authorship(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return authorship(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/authorship/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response authorship(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return authorship(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	private Response authorship(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		User user = getUser(context, incomingData, null);

		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action.");
		}
		File jpg = actual.percentOfAuthorship();
		return Response.ok(jpg, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + jpg.getName() + "\"").build();
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
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/messages/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response messages(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return actionsMessages(context, incomingData, actual, false);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

}
