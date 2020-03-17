package dialogflow.restAccess;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dialogflow.request.OutputContext;
import dialogflow.request.Request;
import dialogflow.request.Response;

@Path("/dialogflow")
public class DialogflowWebhook extends Webhook{

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
	
	public static ObjectMapper mapper = new ObjectMapper();
	private static final String APPOINTMENT = "Make Appointment";

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public javax.ws.rs.core.Response editProject(@Context ServletContext context, InputStream incomingData) throws JsonParseException, JsonMappingException, IOException {
		String data = readIncomingData(incomingData);

		System.out.println(data);

		Request request = mapper.readValue(data, Request.class);
		System.out.println(request);

		try {
			return processRequest(context, request);
		} catch (Exception e) {
			Response response = new Response();
			response.setFulfillmentText(e.getMessage());
			return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON)
					.build();
		}
	}



	@GET
	@Path("hello/{name}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name + " dialogflow";
	}

	private javax.ws.rs.core.Response processRequest(ServletContext context, Request request)
			throws Exception {

		String intent = request.getQueryResult().getIntent().getDisplayName();
		Response response;
		System.out.println(intent);
		;
		if (intent.equals(APPOINTMENT)) {
			response = processNewProject(context, request);

		} else {
			response =  new Response();
			response.setFulfillmentText("I can not handler this request");

		}
		
		
		return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON).build();

	}

	private Response processNewProject(ServletContext context, Request request) throws Exception {
		String intent = request.getQueryResult().getIntent().getDisplayName();
		if (!intent.equals(APPOINTMENT)) {
			throw new Exception("This intent is not " + APPOINTMENT);
		}

		OutputContext outputContext = request.getQueryResult().getOutputContexts().get(0);
		String dateString = getParameter(DATE_PARAMETER, outputContext);
		String time = getParameter(TIME_PARAMETER, outputContext);
		String pet = getParameter(PET_PARAMETER, outputContext);
		String petName = getParameter(PET_NAME_PARAMETER, outputContext);

		System.out.println("DateTime: "+dateString +" "+time);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		DateTime dateAux = new DateTime(formatter.parse(dateString).getTime());
		DateTime timeAux = new DateTime(formatter.parse(time).getTime());
		
		String text = makeAnAppointment(dateAux, timeAux, pet, petName);

		Response response = new Response();
		response.setFulfillmentText(text);
		return response;
	}
	
	private String getParameter (String parameterName, OutputContext outputContext) throws Exception {
		String string = (String) outputContext.getParameters().get(parameterName);
		if (string == null) {
			throw new Exception("This intent doesn't has the " + parameterName);
		}
		return string;
	}

}
