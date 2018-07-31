package es.uam.app.main.commands;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

		SocioData.getSocioData(context).startConsensus(p, branchGroup, users, measureRequired, new Date());
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
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return startPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/startPoll/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response startPoll(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, id);
			return startPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
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

		int nRound = ((Consensus) d).getRounds().size();
		long timer = 600000;
		if (object.has("timer")) {
			timer = object.getLong("timer");
		}

		SocioData.getSocioData(context).startVoting(context, p, (Consensus) d, timer, new Date());
		JSONObject polling = createPollingJSON(context, p, branchGroup, ((Consensus) d).getUsers(), nRound, timer);
		return Response.ok(polling.toString(), MediaType.APPLICATION_JSON).build();
	}

	private JSONObject createPollingJSON(ServletContext context, Project project, String branchGroup, List<User> users,
			int nRound, long timer) throws JSONException, Exception {
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
		return object;
	}

	@GET
	@Path("/getPoll/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getPoll(@Context ServletContext context, @PathParam("channel") String channel) throws Exception {
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
			array.put(createPollingJSON(context, cons.getBranchGroup().getFather(), cons.getName(), users, roundsSize,
					rounds.get(roundsSize - 1).getTimer()));
		}

		JSONObject pollsJSON = new JSONObject();
		pollsJSON.put("polls", array);
		return Response.ok(pollsJSON.toString(), MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/addPoll/{channel}/{user}/{project}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addPoll(@Context ServletContext context, InputStream incomingData,
			@PathParam("channel") String channel, @PathParam("user") String user, @PathParam("project") String project,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, channel, user, project);
			return addPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}

	}

	@POST
	@Path("/addPoll/{id}/{branchGroup}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response addPoll(@Context ServletContext context, InputStream incomingData, @PathParam("id") long id,
			@PathParam("branchGroup") String branchGroup) throws Exception {
		try {
			Project actual = getProject(context, id);
			return startPoll(context, incomingData, actual, branchGroup);
		} catch (InternalException e) {
			return sendTextException(e);
		}
	}

	private Response addPoll(ServletContext context, InputStream incomingData, Project p, String branchGroup) throws InternalException, Exception {
		
		
		BranchGroup bg = p.getCloseBranchGroup(branchGroup);
		if (bg == null) {
			throw new InternalException("The branch group is not close or don't exits");
		}
		Decision d = bg.getDecision();
		if ( d == null || !(d instanceof Consensus)) {
			throw new InternalException("The consensus doesn't exits");
		}
		Consensus cons =(Consensus) d;
		JSONObject object = readRequest(incomingData);
		User user = getUser(context, object, "user");
		if (!cons.getUsers().contains(user)){
			throw new InternalException("You need to be included in the poll");
		}
		Map<String, Integer> order = new HashMap<>();
		JSONObject orderObject = object.getJSONObject("order");
		for (int i=0; i<bg.getBranchs().size(); i++) {
			String value = orderObject.getString(Integer.toString(i));
			order.put(value, i);
		}
		SocioData.getSocioData(context).addPreference(p, cons, user, order);
		return Response.ok("The preferences are stored sussecfully").build();
	}
	
	@GET
	@Path("/getEndPoll/{channel}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getEndPoll(@Context ServletContext context, @PathParam("channel") String channel) throws Exception {
		List<Consensus> polls = SocioData.getSocioData(context).getAndRemoveEndConsensus(channel);
		JSONArray array = new JSONArray();
		for (Consensus cons : polls) {
			array.put(createEndConsensusJSON(context, cons.getBranchGroup().getFather(), cons));
		}

		JSONObject pollsJSON = new JSONObject();
		pollsJSON.put("polls", array);
		return Response.ok(pollsJSON.toString(), MediaType.APPLICATION_JSON).build();
	}
	
	private JSONObject createEndConsensusJSON(ServletContext context, Project project, Consensus consensus) throws JSONException, Exception {
		JSONObject object = new JSONObject();
		object.put("project", getProjectJSON(context, project));
		object.put("branchGroup", consensus.getName());
		List<Order> order = consensus.getConsensusOrder();
		JSONArray colective = new JSONArray();
		for (Order o: order) {
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
				user.put("close", false);
			}else {
				user.put("close", true);
			}
			array.put(user);
		}
		object.put("close", array);
		
		object.put("measure", consensus.getConsensusActualMeasure());
		object.put("required", consensus.getConsensusRequired());
		return object;
	}
}
