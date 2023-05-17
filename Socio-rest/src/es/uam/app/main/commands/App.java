package es.uam.app.main.commands;

import java.io.File;
//import java.io.InputStream;

import javax.servlet.ServletContext;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.uam.app.main.exceptions.ExceptionControl;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.emf.Controlador;
import es.uam.app.projects.emf.metamodel.MetamodelControl;
import informationSistem.GeneracionDevolviendoFicheroAdaptadoSara;
import socioProjects.Project;
import socioProjects.User;
import zipUtils.Zipper;

@Path("/app")
public class App extends MainCommand {

	@GET
	@Path("/{id}")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	// public Response app(@Context ServletContext context, InputStream
	// incomingData, @PathParam("id") long id)
	public Response app(@Context ServletContext context, @PathParam("id") long id) {
		try {
			Project actual = getProject(context, id);
			// return app(context, incomingData, actual);
			return app(context, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("app: ", e);
			return sendTextException(e);
		}
	}

	@GET
	@Path("/{channel}/{user}/{project}")
	// @Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN })
	// public Response app(@Context ServletContext context, InputStream
	// incomingData, @PathParam("channel") String channel,
	// @PathParam("user") String user, @PathParam("project") String project)
	public Response app(@Context ServletContext context, @PathParam("channel") String channel,
			@PathParam("user") String user, @PathParam("project") String project) {
		try {
			Project actual = getProject(context, channel, user, project);
			//return app(context, incomingData, actual);
			return app(context, actual);
		} catch (InternalException e) {
			return sendTextException(e);
		} catch (Exception e) {
			ExceptionControl.geExceptionControl(context).printLogger("app: ", e);
			return sendTextException(e);
		}
	}

	//private Response app(ServletContext context, InputStream incomingData, Project actual) throws Exception
	private Response app(ServletContext context, Project actual) throws Exception
	{
		//User user = getUser(context, incomingData, "user");
		//File file = app(context, actual, user);
		File file = app1(context, actual);
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"").build();
	}

	//public static File app(ServletContext context, Project actual, User user) throws Exception 
	public static File app1(ServletContext context, Project project) throws Exception
	{

		/*if (!(user.canEdit(actual))) {
			throw new InternalException("You don't have editing permissions in this project.");
		}*/

		Controlador controlador = project.getControlador();
		if (controlador instanceof MetamodelControl) {
			File file = GeneracionDevolviendoFicheroAdaptadoSara.funcionPrincipal(project.getPath()+"/"+project.getName(),
					((MetamodelControl) controlador).getResource());
			File zip = zip(file, project.getPath()).getFile();
			if (zip.exists()) {
				return zip;
			}
		}
		throw new InternalException("I can generate the app");
	}

	public static File app(ServletContext context, String pChannel, String pUser, String pName,
			com.socio.client.beans.User user) throws Exception {

		Project actual = getProject(context, pChannel, pUser, pName);
		User u = getUser(context, user.getChannel(), user.getNick(), user.getId(), user.getName());
		//return app(context, actual, u);
		return app1(context, actual);
	}

	private static Zipper zip(File f, String path) {
		Zipper zip = new Zipper(path, f.getName());
		zip(f, "", zip);
		zip.close();
		return zip;
	}

	private static void zip(File file, String folders, Zipper zip) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				zip(f, folders + file.getName() + "/", zip);
			}
		} else {
			zip.addFileToFolder(folders, file.getName(), file);
		}
	}
}
