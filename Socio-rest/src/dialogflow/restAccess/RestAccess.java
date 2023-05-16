package dialogflow.restAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Subproject;
import com.socio.client.command.SaveFileServer;
import com.socio.client.beans.User;

import dialogflow.request.Image;
import dialogflow.request.OutputContext;
import dialogflow.request.Request;
import dialogflow.request.Response;
import dialogflow.request.RichMessege;
import dialogflow.telegram.replykeyboard.ReplyKeyboardRemove;
import es.uam.app.main.SocioData.ProjectType;
import es.uam.app.main.commands.Get;
import es.uam.app.main.commands.History;
import es.uam.app.main.commands.ProjectConfiguration;
import es.uam.app.main.commands.ProjectEditor;
import es.uam.app.main.commands.Projects;
import es.uam.app.main.commands.Statistics;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.model.parser.Create;
import es.uam.app.model.parser.DialogflowIntent;
import es.uam.app.model.parser.Remove;
import es.uam.app.model.parser.UpdateAttr;
import es.uam.app.model.parser.UpdateRef;
import socioProjects.Visibility;

@Path("/dialogflow/")
public class RestAccess {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
	public static ObjectMapper mapper = new ObjectMapper();
	private static String GET = "Get";
	private static String HISTORY_MESSAGES = "History - Messages";
	private static String HISTORY_STATISTICS = "History - Statistics";
	private static String HISTORY_MESSAGES_DATE = "History - Messages - Date";
	private static String HISTORY_MESSAGES_USER = "History - Messages - User";
	private static String HISTORY_MESSAGES_ELEMENT = "History - Messages - Element";
	private static String HISTORY_MESSAGES_ALL = "History - Messages - All";
	private static String HISTORY_MESSAGES_ACTION_CREATE = "History - Messages - Action - Create";
	private static String HISTORY_MESSAGES_ACTION_UPDATE = "History - Messages - Action - Update";
	private static String HISTORY_MESSAGES_ACTION_DELETE = "History - Messages - Action - Remove";
	private static String HISTORY_STATISTICS_ACTIONS = "History - Statistics - Actions";
	private static String HISTORY_STATISTICS_M1USER = "History - Statistics - M1User";
	private static String HISTORY_STATISTICS_MUSERS = "History - Statistics - MUsers";
	private static String HISTORY_STATISTICS_A1USER = "History - Statistics - A1User";
	private static String HISTORY_STATISTICS_AUSER = "History - Statistics - AUsers";
	private static String HISTORY_STATISTICS_AUTHORSHIP = "History - Statistics - Authorship";
	private static String NEWPROJECT = "NewProject";
	private static String PROJECTS = "Projects";
	private static String REDO = "Redo";
	private static String SETPROJECT = "SetProject";
	private static String SHOW = "Show";
//	private static String TALK = "Talk";
	private static String UNDO = "Undo";
//	private static String VALIDATE = "Validate";
	private static String CREATE = "Create ";
	private static String REMOVE = "Remove ";
	private static String UPDATE = "Update ";
	private static String UPDATE_REF = "Update Ref ";
	private static String UPDATE_ATT = "Update Att ";

	private static String PROJECT = "project";
	private static String VISIBILITY = "visibility";

	private static User defaultUser = new User("Dialogflow", "TestConsola", "Consola", 1);

	public static final SaveFileServer server = new SaveFileServer("http://miso1.ii.uam.es:80/FileServer/file/");

	@POST
	@Path("{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public javax.ws.rs.core.Response editProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("name") String name) throws JsonParseException, JsonMappingException, IOException {
		String data = readIncomingData(incomingData);

		//System.out.println(data);

		Request request = mapper.readValue(data, Request.class);
		 System.out.println(request);

		try {
			return processRequest(context, request, name);
		} catch (Exception e) {
			Response response = new Response();
			response.setFulfillmentText(e.getMessage());
			return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON)
					.build();
		}
	}

	private String readIncomingData(InputStream incomingData) {
		String text = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				text += line + "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	@GET
	@Path("hello/{name}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name + " dialogflow";
	}

	private javax.ws.rs.core.Response processRequest(ServletContext context, Request request, String mmodel)
			throws Exception {

		User user = request.getUser();
		if (user == null) {
			user = defaultUser;
		}
		String intent = request.getQueryResult().getIntent().getDisplayName();
		Response response;
		System.out.println(intent);
		System.out.println(HISTORY_MESSAGES);
		if (intent.equals(NEWPROJECT)) {
			response = processNewProject(context, request, user, mmodel);

		} else if (intent.startsWith(HISTORY_MESSAGES)) {
			response = processHistory(context, request, user, mmodel);

		} else if (intent.startsWith(HISTORY_STATISTICS)) {
			response = processStatistics(context, request, user, mmodel);
		} else if (intent.equals(PROJECTS)) {
			response = processProjects(context, request, user, mmodel);
		} else if (intent.equals(GET)) {
			response = processGet(context, request, user, mmodel);
		} else if (intent.equals(SHOW)) {
			response = processShow(context, request, user, mmodel);
		} else if (intent.equals(UNDO)) {
			response = processUndo(context, request, user, mmodel);
		} else if (intent.equals(REDO)) {
			response = processRedo(context, request, user, mmodel);
		} else if (intent.startsWith(CREATE)) {
			response = processCreate(context, request, user, mmodel);
		} else if (intent.equals(SETPROJECT)) {
			response = processSetproject(context, request, user, mmodel);
		} else if (intent.startsWith(UPDATE)) {
			response = processUpdate(context, request, user, mmodel);
		} else if (intent.startsWith(REMOVE)){
			response = processRemove(context, request, user, mmodel);
		} else {
			return null;
		}

		return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON).build();

	}

	private Response processSetproject(ServletContext context, Request request, User user, String mmodel)
			throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(SETPROJECT)) {
			throw new InternalException("This intent is not setproject");
		}

		Response response = new Response();
		try {
			String projectSplit[] = getProjectName(request);
			String pChannel = projectSplit[0];
			String pUser = projectSplit[1];
			String pName = projectSplit[2];
			JSONObject projectJSON = Projects.projectS(context, pChannel, pUser, pName);
			Project project = Project.createProject(projectJSON);
			String text = "The project has been selected\n" + printProject(project) + "\n";
			response.setFulfillmentText(text);

			return response;
		} catch (Exception e) {
			response.setFulfillmentText(e.getMessage());
			List<OutputContext> outputContexts = request.getQueryResult().getOutputContexts();
			for (OutputContext oc : outputContexts) {
				oc.setLifespanCount(0);
			}
			response.setOutputContexts(outputContexts);
		}
		return response;
	}

	private Response processRemove(ServletContext context, Request request, User user, String mmodel) throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.startsWith(REMOVE)) {
			throw new InternalException("This intent is not remove");
		}

		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		String className = intent.replace(REMOVE, "");
		Map<String, Object> parameter = request.getQueryResult().getParameters();
		Map<String, List<Object>> ids = new HashMap<>();
		for (String key : parameter.keySet()) {
			String name = key.replace(className + "-", "");
			if (key.endsWith("-Id")) {
				safeParemeter(name.replace("-Id", ""), parameter.get(key), ids);
			}
		}
		Remove removeObjects = new Remove();
		removeObjects.setClassName(className);
		removeObjects.setIds(ids);

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, mapper.writeValueAsString(removeObjects), new Date(), id);

		File f = ProjectEditor.editProject(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	private Response processUpdate(ServletContext context, Request request, User user, String mmodel) throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.startsWith(UPDATE)) {
			throw new InternalException("This intent is not update");
		}

		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		DialogflowIntent update = null;
		if (intent.startsWith(UPDATE_REF)) {
			UpdateRef updateRef = new UpdateRef();
			String intentValues[] = intent.replace(UPDATE_REF, "").split("-");
			String srcClass = intentValues[0];
			String refName = intentValues[1];
			String trgClass = intentValues[2];
			Map<String, Object> parameter = request.getQueryResult().getParameters();
			Map<String, List<Object>> trgIds = new HashMap<>();
			Map<String, List<Object>> srcIds = new HashMap<>();
			for (String key : parameter.keySet()) {
				if (key.endsWith("SrcId")) {
					safeParemeter(key.replace("SrcId", ""), parameter.get(key), srcIds);
				} else if (key.endsWith("TrgId")) {
					safeParemeter(key.replace("TrgId", ""), parameter.get(key), trgIds);
				}
			}

			updateRef.setRefName(refName);
			updateRef.setSrcClass(srcClass);
			updateRef.setTrgClass(trgClass);
			updateRef.setTrgId(trgIds);
			updateRef.setSrcId(srcIds);
			update = updateRef;
		} else if (intent.startsWith(UPDATE_ATT)) {
			UpdateAttr updateAttr = new UpdateAttr();
			String intentValues[] = intent.replace(UPDATE_ATT, "").split("-");
			String className = intentValues[0];
			String attrName = intentValues[1];
			Map<String, Object> parameter = request.getQueryResult().getParameters();
			Map<String, Object> ids = new HashMap<>();
			Object value = null;
			for (String key : parameter.keySet()) {
				if (key.endsWith("Id")) {
					ids.put(key.replace("Id", ""), parameter.get(key));
				} else if (key.equals("value")) {
					value = parameter.get(key);
				}
			}

			updateAttr.setAttrName(attrName);
			updateAttr.setClassName(className);
			updateAttr.setId(ids);
			updateAttr.setValue(value);
			update = updateAttr;
		} else {
			throw new InternalException("This intent is under construction");
		}

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, mapper.writeValueAsString(update), new Date(), id);

		File f = ProjectEditor.editProject(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	private Response processCreate(ServletContext context, Request request, User user, String mmodel) throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.startsWith(CREATE)) {
			throw new InternalException("This intent is not create");
		}

		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		String className = intent.replace(CREATE, "");
		Map<String, Object> parameter = request.getQueryResult().getParameters();
		Map<String, List<Object>> ids = new HashMap<>();
		Map<String, List<Object>> notIds = new HashMap<>();
		int n = 1;
		for (String key : parameter.keySet()) {
			if (key.equalsIgnoreCase("quantity")) {
				if (parameter.get(key) instanceof Double) {
					double nDouble = (double) parameter.get(key);
					n = (int) nDouble;
				}
			} else {
				String name = key.replace(className + "-", "");
				if (key.endsWith("-Id")) {
					safeParemeter(name.replace("-Id", ""), parameter.get(key), ids);
				} else {
					safeParemeter(name, parameter.get(key), notIds);
				}
			}
		}
		Create createObject = new Create();
		createObject.setClassName(className);
		createObject.setIds(ids);
		createObject.setNotIds(notIds);
		createObject.setN(n);

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, mapper.writeValueAsString(createObject), new Date(), id);

		File f = ProjectEditor.editProject(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	@SuppressWarnings("unchecked")
	private void safeParemeter(String name, Object value, Map<String, List<Object>> map) {
		if (value != null) {
			if (value instanceof List<?>) {
				map.put(name, (List<Object>) value);
			} else {
				List<Object> list = new ArrayList<>();
				list.add(value);
				map.put(name, list);
			}
		}
	}

	private Response processShow(ServletContext context, Request request, User user, String mmodel) throws Exception {

		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(SHOW)) {
			throw new InternalException("This intent is not show");
		}
		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, "", new Date(), id);
		File f = ProjectEditor.editProject(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	private Response processUndo(ServletContext context, Request request, User user, String mmodel) throws Exception {

		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(UNDO)) {
			throw new InternalException("This intent is not undo");
		}
		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, "", new Date(), id);
		File f = ProjectEditor.undo(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	private Response processRedo(ServletContext context, Request request, User user, String mmodel) throws Exception {

		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(REDO)) {
			throw new InternalException("This intent is not redo");
		}
		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		String id = request.getOriginalDetectIntentRequest().getId();
		String text = request.getQueryResult().getQueryText();
		Message message = new Message(user, text, "", new Date(), id);
		File f = ProjectEditor.redo(context, pChannel, pUser, pName, message);
		return sendPhoto(f);
	}

	private Response processGet(ServletContext context, Request request, User user, String mmodel) throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(GET)) {
			throw new InternalException("This intent is not get");
		}
		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		File f = Get.get(context, pChannel, pUser, pName, user);
		return sendDocument(f, "file");

	}

	private Response processProjects(ServletContext context, Request request, User user, String mmodel)
			throws Exception {
		JSONObject projJSON = Projects.projectsForUserS(context, user.getChannel(), user.getNick());
		List<Project> projects = new ArrayList<>();

		if (!projJSON.isNull("projectList")) {
			JSONArray projectList = projJSON.getJSONArray("projectList");
			for (int i = 0; i < projectList.length(); i++) {
				JSONObject proj = projectList.getJSONObject(i);
				projects.add(Project.createProject(proj));
			}
		}
		String text = "";
		if (projects.isEmpty()) {
			text = "There are not projects";
		}
		for (Project p : projects) {
			text += printProject(p) + "\n\n";
		}
		Response response = new Response();
		response.setFulfillmentText(text);

		return response;
	}

	private Response processHistory(ServletContext context, Request request, User user, String mmodel)
			throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();

		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];

		JSONObject object = null;

		if (intent.equals(HISTORY_MESSAGES_ACTION_CREATE)) {

		} else if (intent.equals(HISTORY_MESSAGES_ACTION_DELETE)) {

		} else if (intent.equals(HISTORY_MESSAGES_ACTION_UPDATE)) {

		} else if (intent.equals(HISTORY_MESSAGES_ALL)) {
			object = History.history(context, user, null, -1, -1, null, null, pChannel, pUser, pName);

		} else if (intent.equals(HISTORY_MESSAGES_DATE)) {

		} else if (intent.equals(HISTORY_MESSAGES_ELEMENT)) {

		} else if (intent.equals(HISTORY_MESSAGES_USER)) {

		} else {
			throw new InternalException("This intent is not History");
		}
		String text = getMessegesText(object);
		if (text.length() > 4000) {
			return sendDocument(getTextFile(text), "history");
		} else {
			Response response = new Response();
			response.setFulfillmentText(text);
			Map<String, String> payload = new HashMap<>();
			ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
			payload.put("text", text);
			payload.put("reply_markup", mapper.writeValueAsString(keyboard));
			response.addPayload("telegram", payload);
			return response;
		}

	}

	private static String getMessegesText(JSONObject object) {
		List<Message> listRet = new ArrayList<>();

		if (!object.isNull("msgList")) {
			JSONArray msgList = object.getJSONArray("msgList");
			for (int i = 0; i < msgList.length(); i++) {
				JSONObject msg = msgList.getJSONObject(i);
				listRet.add(Message.createMessage(msg));
			}
		}
		Comparator<Message> comparator = new Comparator<Message>() {

			@Override
			public int compare(Message o1, Message o2) {
				return (int) (o1.getDate() - o2.getDate());
			}

		};

		Collections.sort(listRet, comparator);

		String text;
		if (listRet.isEmpty()) {
			text = "The history is empty";
		} else {
			text = Message.getHistoryFormat(listRet);
		}
		return text;
	}

	private static File getTextFile(String text) {
		File f = new File("temp.txt");
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {

			fichero = new FileWriter(f);
			pw = new PrintWriter(fichero);
			pw.println(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return f;
	}

	private String[] getProjectName(Request request) throws InternalException {
		OutputContext outputContext = request.getQueryResult().getOutputContexts().get(0);
		String project = (String) outputContext.getParameters().get(PROJECT);
		if (project == null) {
			throw new InternalException("This intent doesn't has the project name");
		}
		String projectSplit[] = project.split("/");
		if (projectSplit.length != 3) {
			throw new InternalException("Malformed project name");
		}
		return projectSplit;
	}

	private Response processStatistics(ServletContext context, Request request, User user, String mmodel)
			throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();

		String projectSplit[] = getProjectName(request);
		String pChannel = projectSplit[0];
		String pUser = projectSplit[1];
		String pName = projectSplit[2];
		File f = null;
		if (intent.equals(HISTORY_STATISTICS_A1USER)) {

		} else if (intent.equals(HISTORY_STATISTICS_ACTIONS)) {
			f = Statistics.allActions(context, pChannel, pUser, pName, user);

		} else if (intent.equals(HISTORY_STATISTICS_AUSER)) {

		} else if (intent.equals(HISTORY_STATISTICS_AUTHORSHIP)) {
			f = Statistics.authorship(context, pChannel, pUser, pName, user);

		} else if (intent.equals(HISTORY_STATISTICS_M1USER)) {

		} else if (intent.equals(HISTORY_STATISTICS_MUSERS)) {

		} else {
			throw new InternalException("This intent is not History");
		}

		return sendPhoto(f);
	}

	private Response sendPhoto(File f) throws Exception {
		String URL = server.saveSecondFile(f, 99, TimeUnit.DAYS);
		System.out.println(URL);
		URL = "http://miso1.ii.uam.es/factoryFile/" + URL;
		System.out.println(URL);
		Response response = new Response();

		Map<String, RichMessege> fulfillmentMessages = new HashMap<>();
		Image image = new Image();
		image.setImageUri(URL);
		fulfillmentMessages.put(RichMessege.IMAGE, image);

		response.addFulfillmentMessages(fulfillmentMessages);
		Map<String, String> payload = new HashMap<>();
		ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
		payload.put("photo", URL);
		payload.put("reply_markup", mapper.writeValueAsString(keyboard));
		response.addPayload("telegram", payload);
		return response;
	}

	private Response sendDocument(File f, String fileType) throws Exception {
		String URL = server.saveFile(f, 1, TimeUnit.DAYS);
		Response response = new Response();
		response.setFulfillmentText("You can get the history in: " + URL);

		Map<String, String> payload = new HashMap<>();
		ReplyKeyboardRemove keyboard = new ReplyKeyboardRemove();
		payload.put("text", "You can get the " + fileType + " in: " + URL);
		payload.put("reply_markup", mapper.writeValueAsString(keyboard));
		response.addPayload("telegram", payload);
		return response;
	}

	private Response processNewProject(ServletContext context, Request request, User user, String mmodel)
			throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(NEWPROJECT)) {
			throw new InternalException("This intent is not new project");
		}

		OutputContext outputContext = request.getQueryResult().getOutputContexts().get(0);
		String project = (String) outputContext.getParameters().get(PROJECT);
		if (project == null) {
			throw new InternalException("This intent doesn't has the project name");
		}
		String visibility = (String) outputContext.getParameters().get(VISIBILITY);
		Visibility v = Visibility.getByName(visibility);
		if (v == null) {
			v = Visibility.PUBLIC;
		}
		JSONObject projectJSON = ProjectConfiguration.newProject(context, project, v, ProjectType.MODEL, mmodel, user);
		Project p = Project.createProject(projectJSON);
		String text = "Project created:\n" + printProject(p);

		Response response = new Response();
		response.setFulfillmentText(text);
		outputContext.getParameters().put(PROJECT, p.getCompleteName());
		response.setOutputContexts(request.getQueryResult().getOutputContexts());
		return response;
	}

	public static String printProject(Project project) {
		String cad = "*" + project.getCompleteName() + "\n" + "\t" + FORMATTER.format(project.getCreateDate()) + ", "
				+ project.getType() + ", " + project.getVisibility() + ", " + project.getOpenStatus() + "\n";
		if (project.isBranch()) {
			cad += "\t Branch of _" + project.getFather().getName() + "_\n";
			cad += "\t Branch group: " + project.getBranchGroup() + "\n";
		} else {
			Map<String, List<Subproject>> openBranchs = project.getOpenBranchs();
			if (!openBranchs.isEmpty()) {
				cad += "\t Open branchs: \n";
				for (String key : openBranchs.keySet()) {
					cad += "\t\t -" + key + "\n";
					for (Subproject branch : openBranchs.get(key)) {
						cad += "\t\t\t + _" + branch.getName() + "_\n";
					}
				}
			}
			if (!project.getCloseBranchs().isEmpty()) {
				cad += "\t Close branchs: \n";
				for (String branchs : project.getCloseBranchs()) {
					cad += "\t\t -" + branchs.replace("\n", "\n\t\t\t") + "\n";
				}
			}
		}
		return cad;
	}

}
