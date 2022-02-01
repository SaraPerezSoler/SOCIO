package es.uam.app.main.commands;


import javax.servlet.ServletContext;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.emf.metamodel.ClassControl;
import recomender.droid.ContextJson;
import recomender.droid.Droid;
import socioProjects.MetamodelProject;
import socioProjects.Project;
import socioProjects.SocioApp;
import socioProjects.User;

@Path("/recommend")
public class Recommend extends MainCommand {

	@GET
	@Path("/{id}/{className}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response recommend(@Context ServletContext context, @PathParam("id") long id,
			@PathParam("className") String className, @QueryParam("userChannel") String userChannel, @DefaultValue("") @QueryParam("userNick") String userNick, @DefaultValue("-1") @QueryParam("userId") long userId) {
		try {
			Project actual = getProject(context, id);
			User user = getUser(context, userChannel, userNick, userId, "");
			return recommend(context, actual, className, user);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("get: ", e);
			return sendTextException(e);
		}
	}

	@GET
	@Path("/{channel}/{user}/{project}/{className}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response recommend(@Context ServletContext context,
			@PathParam("channel") String channel, @PathParam("user") String userProject, @PathParam("project") String project,
			@PathParam("className") String className, @QueryParam("userChannel") String userChannel, @DefaultValue("") @QueryParam("userNick") String userNick, @DefaultValue("-1") @QueryParam("userId") long userId) {
		try {
			Project actual = getProject(context, channel, userProject, project);
			User user = getUser(context, userChannel, userNick, userId, "");
			return recommend(context, actual, className, user);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("get: ", e);
			return sendTextException(e);
		}
	}

	private Response recommend(ServletContext context, Project actual, String className, User user)
			throws Exception {

		JSONObject object = recommendS(context, actual, className, user);
	
		return Response.ok(object.toString(), MediaType.APPLICATION_JSON).build();

	}

	public static JSONObject recommendS(ServletContext context, Project actual, String className, User user) throws Exception {
		if (actual instanceof MetamodelProject) {
			ClassControl class_ = ((MetamodelProject) actual).getClass(className);
			if (class_ == null) {
				throw new InternalException(
						"The class " + className + " does not exist in the project " + actual.getCompleteName());
			}
			if (!user.canEdit(actual)) {
				throw new InternalException("You don't have editing permissions in this project.");
			}
			
			JSONObject ret = SocioData.getSocioData(context).getRecommendation(actual, class_, user);
			
			return ret;
		} else {
			throw new InternalException("Droid recommendations only works in metamodel projects");
		}
	}

	public static JSONObject recommendS(ServletContext context, String pChannel, String pUser, String pName, String className, String userChannel, String userNick, long userId)
			throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User user = getUser(context, userChannel, userNick, userId, "");
		return recommendS(context, actual, className, user);
	}

}
