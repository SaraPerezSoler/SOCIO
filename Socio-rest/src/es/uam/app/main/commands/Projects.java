package es.uam.app.main.commands;

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
import es.uam.app.main.exceptions.InternalException;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.Visibility;

@Path("/projects")
public class Projects extends MainCommand implements DataFormat {

	public Projects() {
	}

	private Response sendProjects(ServletContext context, List<Project> projects) throws Exception {
		JSONObject list = this.getProjectListJSON(context, projects);
		return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response projects(@Context ServletContext context) throws Exception {
		try {
			List<Project> projects = SocioData.getSocioData(context).getProjects();
			return sendProjects(context, projects);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@GET
	@Path("/{channel}/{user}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response projectsForUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) throws Exception {
		try {
			User user = SocioData.getSocioData(context).getUser(userInfo, channel);
			if (user==null) {
				throw new InternalException("The user "+channel+"/"+userInfo+" doesn't exists");
			}
			List<Project> list = SocioData.getSocioData(context).getProjects(user);
			return sendProjects(context, list);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@GET
	@Path("/read/{channel}/{user}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response projectsReadUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) throws Exception {
		try {
			User user = SocioData.getSocioData(context).getUser(userInfo, channel);
			List<Project> list = SocioData.getSocioData(context).getProjectsForUserCanRead(user);
			return sendProjects(context, list);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@GET
	@Path("/write/{channel}/{user}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response projectsWriteUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) throws Exception {
		try {
			User user = SocioData.getSocioData(context).getUser(userInfo, channel);
			List<Project> list = SocioData.getSocioData(context).getProjectsForUserCanWrite(user);
			return sendProjects(context, list);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@GET
	@Path("/{visibility}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response projectsVisibility(@Context ServletContext context, @PathParam("visibility") String visibility)
			throws Exception {
		try {
			Visibility v = Visibility.get(visibility.toUpperCase());
			if (v == null) {
				throw new InternalException(v + " is not a valid visibilty, it must be PUBLIC, PRIVATE or PROTECTED");
			}
			List<Project> list = SocioData.getSocioData(context).getProjectsForVisibility(v);
			return sendProjects(context, list);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@GET
	@Path("/info/{channel}/{user}/{project}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response project(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo, @PathParam("project") String project) throws Exception {
		try {
			Project p = getProject(context, channel, userInfo, project);
			return Response.ok(new JSONObject().put("project", getProjectJSON(context, p)).toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	@GET
	@Path("/info/{project}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response project(@Context ServletContext context, @PathParam("project") long id) throws Exception {
		try {
			Project p = getProject(context, id);
			return Response.ok(new JSONObject().put("project", getProjectJSON(context, p)).toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

}
