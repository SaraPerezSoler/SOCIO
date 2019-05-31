package es.uam.app.main.commands;

import java.io.File;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.ExceptionControl;
import projectHistory.Msg;
import socioProjects.Project;

@Path("/updates")
public class Updates extends MainCommand implements DataFormat {

	@GET
	@Path("/register/{channel}")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN })
	public Response register(@Context ServletContext context, @PathParam("channel") String channel) {
		try {
			SocioData.getSocioData(context).register(channel);
			return Response.ok("OK", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("register: ", e);
			return sendTextException(e);
		}

	}

	@GET
	@Path("/getupdates/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getUpdatesProjects(@Context ServletContext context, @PathParam("channel") String channel) {
		try {
			List<Project> projects = SocioData.getSocioData(context).getUpdates(channel);
			JSONObject projectsJSON = this.getProjectListJSON(context, projects);
			return Response.ok(projectsJSON.toString(), MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getUpdatesProjects: ", e);
			return sendTextException(e);
		}
	}

	@GET
	@Path("/getupdate/{channel}/{projectId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getProjectUpdate(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("projectId") Long id) {
		try {
			Project project = getProject(context, id);
			return getProjectUpdate(context, channel, project);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getProjectUpdate: ", e);
			return sendTextException(e);
		}
	}

	@GET
	@Path("/getupdate/{channel}/{userChannel}/{user}/{projectname}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getProjectUpdate(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("userChannel") String userChannel, @PathParam("user") String user,
			@PathParam("projectname") String projectname) {
		try {
			Project project = getProject(context, userChannel, user, projectname);
			return getProjectUpdate(context, channel, project);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getProjectUpdate: ", e);
			return sendTextException(e);
		}
	}

	private Response getProjectUpdate(ServletContext context, String channel, Project project) throws Exception {
		List<Msg> msgs = SocioData.getSocioData(context).getUpdate(project, channel);
		return Response.ok(this.getMsgListJSON(msgs).toString(), MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/getlastfile/{projectId}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response getlastfile(@Context ServletContext context, @PathParam("projectId") Long id) {
		try {
			Project project = getProject(context, id);
			return getlastfile(context, project);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getlastfile: ", e);
			return sendTextException(e);
		}
	}

	@GET
	@Path("/getlastfile/{channel}/{user}/{projectname}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response getlastfile(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String user, @PathParam("projectname") String projectname) {
		try {
			Project project = getProject(context, channel, user, projectname);
			return getlastfile(context, project);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getlastfile: ", e);
			return sendTextException(e);
		}
	}

	private Response getlastfile(ServletContext context, Project project) throws Exception {
		File png = SocioData.getSocioData(context).getLastPng(project);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
}
