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

import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import socioProjects.Project;
import socioProjects.User;

@Path("/get")
public class Get extends MainCommand {

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response get(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return get(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("get: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/{channel}/{user}/{project}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response get(@Context ServletContext context, InputStream incomingData, @PathParam("channel") String channel,
			@PathParam("user") String user, @PathParam("project") String project) {
		try {
			Project actual = getProject(context, channel, user, project);
			return get(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("get: ", e);
			return sendTextException(e);
		}
	}

	private Response get(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		User user = getUser(context, incomingData, "user");
		File file = get(context, actual, user);
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"").build();
	}
	
	public static File get(ServletContext context, Project actual, User user) throws Exception {

		if (!(user.canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}

		File file = new File(actual.getFilePath());
		if (file.exists()) {
			return file;
		} else {
			throw new InternalException("I don't find the specified file.");
		}
	}
	
	public static File get(ServletContext context,String pChannel, String pUser, String pName, com.socio.client.beans.User user) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		return get(context, actual, u);
	}

}
