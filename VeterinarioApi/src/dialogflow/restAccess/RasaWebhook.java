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
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/Rasa")
public class RasaWebhook extends Webhook{
	@GET
	@Path("hello/{name}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name + " Rasa";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	public Response editProject(@Context ServletContext context, InputStream incomingData) throws JsonParseException, JsonMappingException, IOException {
		String data = readIncomingData(incomingData);

		System.out.println(data);
		JSONObject object = new JSONObject(data);
		
		System.out.println(object);
		
		try {
			return processRequest(context, object);
		} catch (Exception e) {

			return javax.ws.rs.core.Response.ok(e.getMessage(), MediaType.TEXT_PLAIN)
					.build();
		}
	}

	private Response processRequest(ServletContext context, JSONObject object) throws Exception {
			
		String dateString = getParameter(DATE_PARAMETER, object);
		String time = getParameter(TIME_PARAMETER, object);
		String pet = getParameter(PET_PARAMETER, object);
		String petName = getParameter(PET_NAME_PARAMETER, object);
		
		System.out.println("DateTime: "+dateString +" "+time);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		DateTime dateAux = new DateTime(dateFormatter.parse(dateString).getTime());
		DateTime timeAux = new DateTime(dateFormatter.parse(time).getTime());
		
		String text = makeAnAppointment(dateAux, timeAux, pet, petName);
		
		return Response.ok(text, MediaType.TEXT_PLAIN).build();
	}
	
	private String getParameter (String parameterName, JSONObject object) throws Exception {
		if (!object.has(parameterName)) {
			throw new Exception("This intent doesn't has the " + parameterName);
		}
		return  object.getString(parameterName);
	}
	

}
