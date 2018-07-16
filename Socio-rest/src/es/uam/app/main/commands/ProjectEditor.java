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

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.InternalException;
import projectHistory.Msg;
import socioProjects.Project;

@Path("/editor")
public class ProjectEditor extends MainCommand {

	@POST
	@Path("/do/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response editProject(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return editProject(context, actual, incomingData);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@POST
	@Path("/do/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response editProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return editProject(context, actual, incomingData);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	private Response editProject(ServletContext context, Project actual, InputStream incomingData) throws Exception {
		Msg msg = getMsg(context, incomingData, null);
		if (msg.hasText()) {
			if (msg.getUser().canEdit(actual)) {
				File png = SocioData.getSocioData(context).execute(actual, msg);
				return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
						.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
			} else {
				throw new InternalException("You don't have editing permissions in this project.");
			}
		} else {
			if (msg.getUser().canRead(actual)) {
				File png = actual.getPng(null);
				return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
						.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
			} else {
				throw new InternalException("You don't have reading permissions in this project.");
			}
		}
	}

	@POST
	@Path("/redo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response redo(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return redo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/redo/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response redo(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return redo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	private Response redo(@Context ServletContext context, InputStream incomingData, Project actual) throws Exception {
		Msg msg = getMsg(context, incomingData, null);
		if (!(msg.getUser().canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}

		File png = SocioData.getSocioData(context).redo(actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}

	@POST
	@Path("/undo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response undo(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			throws Exception {
		try {
			Project actual = getProject(context, id);
			return undo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/undo/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response undo(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return undo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	private Response undo(@Context ServletContext context, InputStream incomingData, Project actual) throws Exception {

		Msg msg = getMsg(context, incomingData, null);
		SocioData.getSocioData(context).addUser(msg.getUser());
		if (!(msg.getUser().canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}
		File png = SocioData.getSocioData(context).undo(actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
}
