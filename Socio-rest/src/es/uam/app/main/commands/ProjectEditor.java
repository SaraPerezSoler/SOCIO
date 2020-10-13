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

import com.socio.client.beans.Message;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.main.exceptions.NotActionException;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

@Path("/editor")
public class ProjectEditor extends MainCommand {

	@POST
	@Path("/do/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response editProject(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return editProject(context, actual, incomingData);
		}catch (NotActionException e) {
			return sendText("Sorry, I don't understand. You can try to make a direct order like '/talk Add A in B.'. Remember, you can put the noun with \" \", if I still couldn't understand. By the way, /help command is always welcome to be used.");
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("editProject: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/do/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response editProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return editProject(context, actual, incomingData);
		}catch (NotActionException e) {
			return sendText("Sorry, I don't understand. You can try to make a direct order like '/talk Add A in B.'. Remember, you can put the noun with \" \", if I still couldn't understand. By the way, /help command is always welcome to be used.");
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("editProject: ", e);
			return sendTextException(e);
		}

	}
	
	@POST
	@Path("/show/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response show(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return showProject(context, actual, incomingData);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("editProject: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/show/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response show(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return showProject(context, actual, incomingData);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("editProject: ", e);
			return sendTextException(e);
		}

	}

	private Response editProject(ServletContext context, Project actual, InputStream incomingData) throws Exception {
		Msg msg = getMsg(context, incomingData, null);
		File png = editProject(context, actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
	private Response showProject(ServletContext context, Project actual, InputStream incomingData) throws Exception {
		Msg msg = getMsg(context, incomingData, null);
		msg.setText(null);
		File png = editProject(context, actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
	public static File editProject(ServletContext context, Project actual, Msg msg) throws Exception {

		if (msg.hasText()) {
			if (msg.getUser().canEdit(actual)) {
				File png = SocioData.getSocioData(context).execute(actual, msg);
				return png;
			} else {
				throw new InternalException("You don't have editing permissions in this project.");
			}
		} else {
			if (msg.getUser().canRead(actual)) {
				File png = actual.getPng(null);
				return png;
			} else {
				throw new InternalException("You don't have reading permissions in this project.");
			}
		}
	}
	
	public static File editProject(ServletContext context, String pChannel, String pUser, String pName, Message message) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User user = getUser(context, message.getUser().getChannel(), message.getUser().getNick(), message.getUser().getId(), message.getUser().getName());
		Msg msg = getMsg(message.getId(), message.getMsg(), user, message.getDate(), message.getText());
		return editProject(context, actual, msg);
	}

	@POST
	@Path("/redo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response redo(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return redo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("redo: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/redo/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response redo(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return redo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("redo: ", e);
			return sendTextException(e);
		}

	}

	private Response redo(@Context ServletContext context, InputStream incomingData, Project actual) throws Exception {
		Msg msg = getMsg(context, incomingData, null);
		File png = redo(context, actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}

	public static File redo(@Context ServletContext context, Project actual, Msg msg) throws Exception {

		if (!(msg.getUser().canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}

		File png = SocioData.getSocioData(context).redo(actual, msg);
		return png;
		
	}
	public static File redo(ServletContext context, String pChannel, String pUser, String pName, Message message) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User user = getUser(context, message.getUser().getChannel(), message.getUser().getNick(), message.getUser().getId(), message.getUser().getName());
		Msg msg = getMsg(message.getId(), message.getMsg(), user, message.getDate(), message.getText());
		return redo(context, actual, msg);
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
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("undo: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/undo/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response undo(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return undo(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("undo: ", e);
			return sendTextException(e);
		}

	}

	private Response undo(ServletContext context, InputStream incomingData, Project actual) throws Exception {

		Msg msg = getMsg(context, incomingData, null);
		SocioData.getSocioData(context).addUser(msg.getUser());
		File png = undo(context, actual, msg);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
	
	public static File undo(ServletContext context, Project actual, Msg msg) throws Exception {

		SocioData.getSocioData(context).addUser(msg.getUser());
		if (!(msg.getUser().canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}
		File png = SocioData.getSocioData(context).undo(actual, msg);
		return png;
		
	}
	public static File undo(ServletContext context, String pChannel, String pUser, String pName, Message message) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User user = getUser(context, message.getUser().getChannel(), message.getUser().getNick(), message.getUser().getId(), message.getUser().getName());
		Msg msg = getMsg(message.getId(), message.getMsg(), user, message.getDate(), message.getText());
		return undo(context, actual, msg);
	}
}
