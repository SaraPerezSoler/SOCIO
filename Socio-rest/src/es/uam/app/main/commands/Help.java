package es.uam.app.main.commands;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/help")
public class Help extends MainCommand {

	public static final String HELP = "https://saraperezsoler.github.io/ModellingBot/";
	private static final String HELP_MSG="You can get help to modelling bot here:\n";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response help() {
		JSONObject object= new JSONObject();
		object.put("text", HELP_MSG);
		object.put("url", HELP);
		return Response.ok(object.toString(), MediaType.APPLICATION_JSON).build();
	}

}
