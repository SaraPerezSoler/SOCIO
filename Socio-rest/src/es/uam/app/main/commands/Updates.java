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
import projectHistory.Msg;
import socioProjects.Project;

@Path("/updates")
public class Updates extends MainCommand implements DataFormat{
	
	@GET
	@Path("/register/{channel}")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN })
	public Response register(@Context ServletContext context, @PathParam("channel") String channel) throws Exception{
		SocioData.getSocioData(context).register(channel); 
		return Response.ok("OK", MediaType.TEXT_PLAIN).build();
	}
	
	@GET
	@Path("/getupdates/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getUpdatesProjects(@Context ServletContext context, @PathParam("channel") String channel) throws Exception{
		List<Project> projects = SocioData.getSocioData(context).getUpdates(channel);
		JSONObject projectsJSON = this.getProjectListJSON(context, projects);
		return Response.ok(projectsJSON.toString(), MediaType.APPLICATION_JSON).build();
	}
	@GET
	@Path("/getupdate/{channel}/{projectId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getProjectUpdate(@Context ServletContext context,@PathParam("channel") String channel, @PathParam("projectId") Long id) throws Exception {
		Project project = getProject(context, id);
		return getProjectUpdate(context,channel, project);
	}
	
	@GET
	@Path("/getupdate/{channel}/{userChannel}/{user}/{projectname}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getProjectUpdate(@Context ServletContext context,@PathParam("channel") String channel, @PathParam("userChannel") String userChannel,
			@PathParam("user") String user, @PathParam("projectname") String projectname) throws Exception {
		Project project = getProject(context, userChannel, user, projectname);
		return getProjectUpdate(context,channel, project);
	}
	
	private Response getProjectUpdate (ServletContext context, String channel, Project project) throws Exception {
		List<Msg> msgs = SocioData.getSocioData(context).getUpdate(project, channel);
		return Response.ok(this.getMsgListJSON(msgs).toString(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/getlastfile/{projectId}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response getlastfile(@Context ServletContext context, @PathParam("projectId") Long id) throws Exception {
		Project project = getProject(context, id);
		return getlastfile(context, project);
	}
	
	@GET
	@Path("/getlastfile/{channel}/{user}/{projectname}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response getlastfile(@Context ServletContext context,@PathParam("channel") String channel,
			@PathParam("user") String user, @PathParam("projectname") String projectname) throws Exception {
		Project project = getProject(context, channel, user, projectname);
		return getlastfile(context, project);
	}

	private Response getlastfile(ServletContext context, Project project) throws Exception {
		File png = SocioData.getSocioData(context).getLastPng(project);
		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
}
