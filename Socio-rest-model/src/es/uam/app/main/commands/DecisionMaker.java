package es.uam.app.main.commands;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import branchDecision.Consensus;
import branchDecision.Decision;
import branchDecision.Order;
import branchDecision.Round;
import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.ExceptionControl;
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
			@PathParam("branchGroup") String branchGroup) {
		Project actual;
		try {
			actual = getProject(context, id);
			return setChoice(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("setChoice: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/setChoice/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response setChoice(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, channel, user, project);
			return setChoice(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("setChoice: ", e);
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
		String messageId = object.getString("messageId");
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
			SocioData.getSocioData(context).startDecision(actual, branchGroup, new Date(), messageId);
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
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, channel, user, project);
			return consensus(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("consensus: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/consensus/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response consensus(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, id);
			return consensus(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("consensus: ", e);
			return sendTextException(e);
		}
	}

	private Response consensus(ServletContext context, InputStream incomingData, Project p, String branchGroup)
			throws InternalException, Exception {

		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		if (!user.isAdmin(p)) {
			throw new InternalException("You need to be a project Admin");
		}
		List<User> users = new ArrayList<User>();
		JSONArray usersArray = object.getJSONArray("usersToSearch");
		for (int i = 0; i < usersArray.length(); i++) {
			User u = getUser(context, usersArray.getJSONObject(i), "");
			if (u != null) {
				users.add(u);
			}
		}
		double measureRequired = 0.75;
		if (object.has("required")) {
			measureRequired = object.getDouble("required");
		}
		if (p.getOpenBranchGroup(branchGroup) == null) {
			throw new InternalException(
					"The project " + p.getCompleteName() + " doesn't have the group " + branchGroup);
		}
		String messageId = object.getString("messageId");

		SocioData.getSocioData(context).startConsensus(p, branchGroup, users, measureRequired, new Date(), messageId);
		File f = p.getProjectHistory();
		return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"").build();
	}

	@POST
	@Path("/startPoll/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response startPoll(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, channel, user, project);
			return startPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("startPoll: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/startPoll/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response startPoll(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, id);
			return startPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("startPoll: ", e);
			return sendTextException(e);
		}
	}

	private Response startPoll(ServletContext context, InputStream incomingData, Project p, String branchGroup)
			throws InternalException, Exception {

		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		if (!user.isAdmin(p)) {
			throw new InternalException("You need to be a project Admin");
		}

		BranchGroup bg = p.getCloseBranchGroup(branchGroup);
		if (bg == null) {
			throw new InternalException("The branch group is not close or don't exits");
		}
		Decision d = bg.getDecision();
		if (d == null || !(d instanceof Consensus)) {
			throw new InternalException("The consensus doesn't exits");
		}

		long timer = 120000;
		if (object.has("timer")) {
			timer = object.getLong("timer");
		}

		SocioData.getSocioData(context).startVoting(context, p, (Consensus) d, timer, new Date());
		int nRound = ((Consensus) d).getRounds().size();
		JSONObject polling = createPollingJSON(context, p, branchGroup, ((Consensus) d).getUsers(), nRound, timer,
				((Consensus) d).getMessageId());
		return Response.ok(polling.toString(), MediaType.APPLICATION_JSON).build();
	}

	private JSONObject createPollingJSON(ServletContext context, Project project, String branchGroup, List<User> users,
			int nRound, long timer, String messageId) throws JSONException, Exception {
		JSONObject object = new JSONObject();
		object.put("project", getProjectJSON(context, project));
		object.put("branchGroup", branchGroup);

		JSONArray array = new JSONArray();
		for (User u : users) {
			array.put(getUserJSON(u));
		}
		object.put("users", array);
		object.put("nRound", nRound);
		object.put("timer", timer);
		object.put("messageId", messageId);
		return object;
	}

	@GET
	@Path("/getPoll/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getPoll(@Context ServletContext context, @PathParam("channel") String channel) {
		try {
			List<Consensus> polls = SocioData.getSocioData(context).getAndRemoveConsensus(channel);
			JSONArray array = new JSONArray();
			for (Consensus cons : polls) {
				List<User> users = new ArrayList<>();
				for (User u : cons.getUsers()) {
					if (u.getChannel().equals(channel)) {
						users.add(u);
					}
				}
				List<Round> rounds = cons.getRounds();
				int roundsSize = rounds.size();
				array.put(createPollingJSON(context, cons.getBranchGroup().getFather(), cons.getName(), users,
						roundsSize, rounds.get(roundsSize - 1).getTimer(), cons.getMessageId()));
			}

			JSONObject pollsJSON = new JSONObject();
			pollsJSON.put("polls", array);
			return Response.ok(pollsJSON.toString(), MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("getPoll: ", e);
			return sendTextException(e);
		}
	}

	@POST
	@Path("/addPoll/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addPoll(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, channel, user, project);
			return addPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("addPoll: ", e);
			return sendTextException(e);
		}

	}

	@POST
	@Path("/addPoll/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addPoll(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) {
		try {
			Project actual = getProject(context, id);
			return addPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("addPoll: ", e);
			return sendTextException(e);
		}
	}

	private Response addPoll(ServletContext context, InputStream incomingData, Project p, String branchGroup)
			throws InternalException, Exception {

		BranchGroup bg = p.getCloseBranchGroup(branchGroup);
		if (bg == null) {
			throw new InternalException("The branch group is not close or don't exits");
		}
		Decision d = bg.getDecision();
		if (d == null || !(d instanceof Consensus)) {
			throw new InternalException("The consensus doesn't exits");
		}
		Consensus cons = (Consensus) d;
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		if (!cons.getUsers().contains(user)) {
			throw new InternalException("You need to be included in the poll");
		}
		Map<String, Integer> order = new HashMap<>();
		JSONObject orderObject = object.getJSONObject("order");

		Iterator<?> keys = orderObject.keys();
		while (keys.hasNext()) {
			String i = (String) keys.next();
			String value = orderObject.getString(i);
			order.put(value, Integer.parseInt(i));
		}
		SocioData.getSocioData(context).addPreference(p, cons, user, order);
		return Response.ok("The preferences are stored sussecfully").build();
	}

	@GET
	@Path("/getEndPoll/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getEndPoll(@Context ServletContext context, @PathParam("channel") String channel) {
		try {
			List<Consensus> polls = SocioData.getSocioData(context).getAndRemoveEndConsensus(channel);
			JSONArray array = new JSONArray();
			for (Consensus cons : polls) {
				array.put(createEndConsensusJSON(context, cons.getBranchGroup().getFather(), cons));
			}

			JSONObject pollsJSON = new JSONObject();
			pollsJSON.put("polls", array);
			return Response.ok(pollsJSON.toString(), MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("addPoll: ", e);
			return sendTextException(e);
		}
	}

	private JSONObject createEndConsensusJSON(ServletContext context, Project project, Consensus consensus)
			throws JSONException, Exception {
		JSONObject object = new JSONObject();
		object.put("project", getProjectJSON(context, project));
		object.put("branchGroup", consensus.getName());
		List<Order> order = consensus.getConsensusOrder();
		JSONArray colective = new JSONArray();
		for (Order o : order) {
			JSONObject object2 = new JSONObject();
			object2.put("pos", o.getPos());
			object2.put("proj", o.getProjectName());
			colective.put(object2);
		}
		object.put("colective", colective);
		object.put("filePath", consensus.getFilePath());
		JSONArray array = new JSONArray();
		for (User u : consensus.getUsersNoVoted()) {
			array.put(getUserJSON(u));
		}
		object.put("notVoted", array);

		array = new JSONArray();
		for (User u : consensus.getUsers()) {
			JSONObject user = getUserJSON(u);
			if (consensus.isRevoteCandidate(u)) {
				user.put("close", true);
			} else {
				user.put("close", false);
			}
			array.put(user);
		}
		object.put("close", array);

		object.put("measure", consensus.getConsensusActualMeasure());
		object.put("required", consensus.getConsensusRequired());
		object.put("messageId", consensus.getMessageId());
		return object;
	}
}
