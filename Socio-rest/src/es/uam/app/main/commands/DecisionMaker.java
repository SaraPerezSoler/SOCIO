package es.uam.app.main.commands;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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

import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.InternalException;
import socioProjects.BranchGroup;
import socioProjects.GroupStatus;
import socioProjects.Project;
import socioProjects.User;

@Path("/decisionMaker")
public class DecisionMaker extends MainCommand {

	@POST
	@Path("/setChoice/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response setChoice(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		Project actual;
		try {
			actual = getProject(context, id);
			return setChoice(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/setChoice/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response setChoice(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return setChoice(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	public Response setChoice(ServletContext context, InputStream incomingData, Project actual, String branchGroup)
			throws Exception {
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		String branchChannel = getString(object, "branchChannel");
		String branchUser = getString(object, "branchUser");
		String branchName = getString(object, "branchName");
		Project branch = getProject(context, branchChannel, branchUser, branchName);

		BranchGroup group = actual.getOpenBranchGroup(branchGroup);
		if (group == null) {
			group = actual.getCloseBranchGroup(branchGroup);
		}

		if (!user.isAdmin(actual)) {
			throw new InternalException("Only the project admin can select a branch");
		}
		if (group == null) {
			throw new InternalException(
					"The project " + actual.getCompleteName() + " doesn't have the branch group " + branchGroup);
		}
		if (!group.getBranchs().contains(branch)) {
			throw new InternalException("The branch group doesn't contain the project " + branch.getCompleteName());
		}
		if (group.getDecision() == null) {
			SocioData.getSocioData(context).startDecision(actual, branchGroup, new Date());
		}
		File f = endDecision(context, actual, branchGroup, branch);
		return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"").build();
	}

	private File endDecision(ServletContext context, Project actual, String branchGroup, Project branchSelected)
			throws Exception {

		BranchGroup bg = actual.getBranchGroup(branchGroup);

		if (bg == null || bg.getStatus().equals(GroupStatus.MERGED)) {
			throw new InternalException(
					"There is not a open branch group called " + branchGroup + " in " + actual.getCompleteName());
		}
		if (bg.getDecision() == null) {
			throw new InternalException("Not decision in " + branchGroup + " in " + actual.getCompleteName());
		}
		List<Project> p = bg.getBranchs();
		if (!p.contains(branchSelected)) {
			throw new InternalException(
					branchSelected.getCompleteName() + " is not a close branch in the group " + bg.getName());
		}

		File png = SocioData.getSocioData(context).makeDecision(actual, bg.getDecision(), branchSelected, new Date());
		return png;
	}

	@POST
	@Path("/consensus/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response consensus(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return consensus(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/consensus/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response consensus(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, id);
			return consensus(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	private Response consensus(ServletContext context, InputStream incomingData, Project p, String branchGroup) {

	}
}
