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

import es.uam.app.main.SocioData;
import es.uam.app.main.SocioData.ProjectType;
import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import socioProjects.Access;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.Visibility;

@Path("/configuration")
public class ProjectConfiguration extends MainCommand implements DataFormat {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/new_project/{project}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response newProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("project") String project) {
		try {
			return newProject(context, incomingData, project, Visibility.PUBLIC);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("newProject: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/new_project/{project}/{visibility}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response newProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("project") String project, @PathParam("visibility") String v){
		try {
			Visibility c = Visibility.valueOf(v.toUpperCase());
			return newProject(context, incomingData, project, c);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("newProject: ", e);
			return sendTextException(e);
		}
	}

	private Response newProject(ServletContext context, InputStream incomingData, String project, Visibility v)
			throws Exception {

		User user = getUser(context, incomingData, null);
		try {
			getProject(context, user.getChannel(), user.getNick(), project);

		} catch (InternalException e) {

			Project p = SocioData.getSocioData(context).createProject(project, user, ProjectType.METAMODEL, v, null, "");
			return Response.ok(new JSONObject().put("project", getProjectJSON(context, p)).toString(), MediaType.APPLICATION_JSON).build();
		}
		throw new InternalException("A project with the name " + user.getChannel() + "/" + user.getNick() + "/"
				+ project + " already exists");
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/remove_project/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeProject(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return removeProject(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("removeProject: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/remove_project/{channel}/{user}/{project}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return removeProject(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("removeProject: ", e);
			return sendTextException(e);
		}
	}

	private Response removeProject(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		User user = getUser(context, incomingData, null);

		if (!(user.isAdmin(actual) || user.isRoot())) {
			throw new InternalException("The user " + user.getChannel() + "/" + user.getNick()
					+ " can't remove the project " + actual.getAdmin().getChannel() + "/" + actual.getAdmin().getNick()
					+ "/" + actual.getName());
		}

		SocioData.getSocioData(context).removeProject(actual);
		return Response.ok("The project " + actual.getName() + " has been deleted.", MediaType.TEXT_PLAIN).build();
	}

	@POST
	@Path("/visibility/{id}/{visibility}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response changeVisibility(@Context ServletContext context, InputStream incomingData,
			@PathParam("id") long id, @PathParam("visibility") String v){
		try {
			Project actual = getProject(context, id);
			return changeVisibility(context, incomingData, actual, v);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("changeVisibility: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/visibility/{channel}/{user}/{project}/{visibility}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response changeVisibility(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("visibility") String v) {
		try {
			Project actual = getProject(context, channel, user, project);
			return changeVisibility(context, incomingData, actual, v);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("changeVisibility: ", e);
			return sendTextException(e);
		}
	}

	private Response changeVisibility(ServletContext context, InputStream incomingData, Project actual, String v)
			throws Exception {
		Visibility c = Visibility.valueOf(v.toUpperCase());
		User user = getUser(context, incomingData, null);
		if (!user.isAdmin(actual)) {
			throw new InternalException("Only the project admin can do this.");
		}
		SocioData.getSocioData(context).changeProjectVisibility(actual, c);
		return Response.ok(new JSONObject().put("project", getProjectJSON(context, actual)).toString(), MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/validate/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response validate(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
	{
		try {
			Project actual = getProject(context, channel, user, project);
			return validate(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("validate: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/validate/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response validate(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return validate(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("validate: ", e);
			return sendTextException(e);
		}
	}

	private Response validate(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		User user = getUser(context, incomingData, null);
		if (!(user.canRead(actual))) {
			throw new InternalException("You are not authorised to do this action. ");
		}
		String text = actual.validate();
		return Response.ok(text, MediaType.TEXT_PLAIN).build();
	}

	@POST
	@Path("/addUser/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addUser(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return addUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("addUser: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/addUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addUser(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return addUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("addUser: ", e);
			return sendTextException(e);
		}
	}

	private Response addUser(ServletContext context, InputStream incomingData, Project actual) throws Exception {

		JSONObject object = readRequest(incomingData);
		String access = getString(object, "access");
		User user = getUser(context, object, "user");
		User user2Search = getUser(context, object, "userToSearch");

		if (!(user.isAdmin(actual))) {
			throw new InternalException(
					"You are not authorised to do this action. Only the project admin can add a user to this project.");
		}

		Access a = Access.EDIT;
		Access aaux = Access.get(access.toUpperCase());
		if (aaux != null) {
			a = aaux;
		}

		SocioData.getSocioData(context).addUserToProject(actual, user2Search, a);
		return Response.ok(new JSONObject().put("project", getProjectJSON(context, actual)).toString(), MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/removeUser/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response removeUser(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return removeUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("removeUser: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/removeUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response removeUser(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return removeUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("removeUser: ", e);
			return sendTextException(e);
		}
	}

	private Response removeUser(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		User user2Search = getUser(context, object, "userToSearch");

		if (!(user.isAdmin(actual))) {
			throw new InternalException(
					"You are not authorised to do this action. Only the project admin can remove a user to the project");
		}

		if (user2Search.canEdit(actual) || user2Search.canRead(actual)) {
			SocioData.getSocioData(context).removeUserToProject(actual, user2Search);
			return Response.ok(new JSONObject().put("project", getProjectJSON(context, actual)).toString(), MediaType.APPLICATION_JSON).build();

		}
		throw new InternalException("The user " + user2Search.getChannel() + "/" + user2Search.getNick()
				+ " is not in the project " + actual.getCompleteName());
	}

	@POST
	@Path("/updateUser/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response updateUser(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return updateUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("updateUser: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/updateUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response updateUser(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return updateUser(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("updateUser: ", e);
			return sendTextException(e);
		}
	}

	private Response updateUser(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		User user2Search = getUser(context, object, "userToSearch");

		if (!(user.isAdmin(actual))) {
			throw new InternalException(
					"You are not authorised to do this action. Only the project admin can remove a user to the project");
		}

		if (user2Search.canEdit(actual)) {
			SocioData.getSocioData(context).addUserToProject(actual, user2Search, Access.READ);
		} else if (user2Search.canRead(actual)) {
			SocioData.getSocioData(context).addUserToProject(actual, user2Search, Access.EDIT);
		} else {
			throw new InternalException("The user " + user2Search.getChannel() + "/" + user2Search.getNick()
					+ " is not in the project " + actual.getCompleteName());
		}
		return Response.ok(new JSONObject().put("project", getProjectJSON(context, actual)).toString(), MediaType.APPLICATION_JSON).build();

	}

	@POST
	@Path("/newBranch/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response newBranch(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return newBranch(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("newBranch: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/newBranch/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response newBranch(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return newBranch(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("newBranch: ", e);
			return sendTextException(e);
		}
	}

	private Response newBranch(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		String branchName = getString(object, "branchName");
		String branchGroup = getString(object, "branchGroup");
		if (actual.isBranch()) {
			throw new InternalException("A branch can't has a branch");
		}

		if (branchName == null || branchName.isEmpty()) {
			throw new InternalException("It's necessary the name of the branch");
		}
		if (branchGroup == null || branchGroup.isEmpty()) {
			branchGroup = "default";
		}

		Project p = SocioData.getSocioData(context).getProject(branchName, user);
		if (p != null) {
			throw new InternalException(
					"The project " + user.getChannel() + "/" + user.getNick() + "/" + branchName + " already exits");
		}
		p = actual.getBranch(branchName);
		if (p != null) {
			throw new InternalException("The branch " + branchName + " already exits in the project "
					+ actual.getAdmin().getChannel() + "/" + actual.getAdmin().getNick() + "/" + actual.getName());
		}

		if (!user.canEdit(actual)) {
			throw new InternalException("The user needs write permissions to create a branch");
		}

		File png = SocioData.getSocioData(context).createBranch(actual, user, validProjectName(branchName),
				validProjectName(branchGroup));

		return Response.ok(png, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + png.getName() + "\"").build();
	}
	
	@POST
	@Path("/branchgroup/{channel}/{user}/{project}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response branchgroup(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project)
			{
		try {
			Project actual = getProject(context, channel, user, project);
			return branchgroup(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("branchgroup: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/branchgroup/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response branchgroup(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id)
			{
		try {
			Project actual = getProject(context, id);
			return branchgroup(context, incomingData, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		}catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("branchgroup: ", e);
			return sendTextException(e);
		}
	}
	
	private Response branchgroup(ServletContext context, InputStream incomingData, Project actual) throws Exception {
		
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		String branchGroup = getString(object, "branchGroup");
		
		if (!actual.isBranch()){
			throw new InternalException("The project must be a branch to set a group.");
		}
		
		if (!user.isAdmin(actual)){
			throw new InternalException("You are not authorised to do this action. Only the project admin can change the branch group");
		}
		SocioData.getSocioData(context).changeBranchGroup(actual, branchGroup);
		return Response.ok(new JSONObject().put("project", getProjectJSON(context, actual)).toString(), MediaType.APPLICATION_JSON).build();

		
	}
}
