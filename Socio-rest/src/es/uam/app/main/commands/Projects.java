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

import org.json.JSONException;
import org.json.JSONObject;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.Visibility;

@Path("/projects")
public class Projects extends MainCommand implements DataFormat {

	public Projects() {
	}

	private static JSONObject sendProjects(ServletContext context, List<Project> projects) throws Exception {
		JSONObject list;

		list = DataFormat.getProjectListJSON(context, projects);
		return list;

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projects(@Context ServletContext context) {
		try {
			JSONObject list = projectsS(context);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projects: ", e);
			return sendTextException(e);
		}
	}

	public static JSONObject projectsS(ServletContext context) throws Exception {
		List<Project> projects = SocioData.getSocioData(context).getProjects();
		return sendProjects(context, projects);

	}

	@GET
	@Path("/{channel}/{user}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectsForUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) {
		try {
			JSONObject list = projectsForUserS(context, channel, userInfo);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectsForUser: ", e);
			return sendTextException(e);
		}

	}

	public static JSONObject projectsForUserS(ServletContext context, String channel, String userInfo)
			throws InternalException, Exception {

		User user = SocioData.getSocioData(context).getUser(userInfo, channel);
		if (user == null) {
			throw new InternalException("The user " + channel + "/" + userInfo + " doesn't exists");
		}
		List<Project> list = SocioData.getSocioData(context).getProjects(user);
		return sendProjects(context, list);

	}

	@GET
	@Path("/read/{channel}/{user}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectsReadUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) {
		try {
			JSONObject list = projectsReadUserS(context, channel, userInfo);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectsReadUser: ", e);
			return sendTextException(e);
		}

	}

	public static JSONObject projectsReadUserS(ServletContext context, String channel, String userInfo)
			throws InternalException, Exception {
		User user = SocioData.getSocioData(context).getUser(userInfo, channel);
		List<Project> list = SocioData.getSocioData(context).getProjectsForUserCanRead(user);
		return sendProjects(context, list);

	}

	@GET
	@Path("/write/{channel}/{user}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectsWriteUser(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo) {
		try {
			JSONObject list = projectsWriteUserS(context, channel, userInfo);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectsWriteUser: ", e);
			return sendTextException(e);
		}

	}

	public static JSONObject projectsWriteUserS(ServletContext context, String channel, String userInfo)
			throws InternalException, Exception {
		User user = SocioData.getSocioData(context).getUser(userInfo, channel);
		List<Project> list = SocioData.getSocioData(context).getProjectsForUserCanWrite(user);
		return sendProjects(context, list);

	}

	@GET
	@Path("/{visibility}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectsVisibility(@Context ServletContext context, @PathParam("visibility") String visibility) {
		try {
			JSONObject list = projectsVisibilityS(context, visibility);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("projectsVisibility: ", e);
			return sendTextException(e);
		}
	}

	public static JSONObject projectsVisibilityS(ServletContext context, String visibility) throws Exception {
		Visibility v = Visibility.get(visibility.toUpperCase());
		if (v == null) {
			throw new InternalException(v + " is not a valid visibilty, it must be PUBLIC, PRIVATE or PROTECTED");
		}
		List<Project> list = SocioData.getSocioData(context).getProjectsForVisibility(v);
		return sendProjects(context, list);
	}

	@GET
	@Path("/info/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response project(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo, @PathParam("project") String project) {
		try {
			JSONObject list = projectS(context, channel, userInfo, project);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("project: ", e);
			return sendTextException(e);
		}
	}

	public static JSONObject projectS(ServletContext context, String channel, String userInfo, String project)
			throws JSONException, Exception {
		Project p = getProject(context, channel, userInfo, project);
		return new JSONObject().put("project", DataFormat.getProjectJSON(context, p));
	}

	@GET
	@Path("/info/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response project(@Context ServletContext context, @PathParam("project") long id) {
		try {
			Project p = getProject(context, id);
			JSONObject project = projectS(context, p);
			return Response.ok(project.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("project/id: ", e);
			return sendTextException(e);
		}
	}

	public static JSONObject projectS(ServletContext context, Project p) throws JSONException, Exception {
		return new JSONObject().put("project", DataFormat.getProjectJSON(context, p));
	}
	
	@GET
	@Path("/elements/{channel}/{user}/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectElements(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String userInfo, @PathParam("project") String project) {
		try {
			Project p = getProject(context, channel, userInfo, project);
			JSONObject list = projectElementS(context, p);
			return Response.ok(list.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("project: ", e);
			return sendTextException(e);
		}
	}

	public static JSONObject projectElementS(ServletContext context, Project project)
			throws JSONException, Exception {
		return SocioData.getSocioData(context).getElementsJSON(project);
	}

	@GET
	@Path("/elements/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response projectElements(@Context ServletContext context, @PathParam("project") long id) {
		try {
			Project p = getProject(context, id);
			JSONObject project = projectElementS(context, p);
			return Response.ok(project.toString(), MediaType.APPLICATION_JSON).build();
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("project/id: ", e);
			return sendTextException(e);
		}
	}
}
