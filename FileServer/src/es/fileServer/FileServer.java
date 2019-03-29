package es.fileServer;

import java.io.File;

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

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.multipart.FormDataParam;

import SaveFile.TimeUnit;
import SaveFile.impl.SavedFilesImpl;

@Path("/file")
public class FileServer {

	@POST
	@Path("/upload")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadFile(@Context ServletContext context, @FormDataParam("file") File file,
			@FormDataParam("fileName") String filename) throws Exception {
		return uploadFile(context, file, filename, 1, TimeUnit.DAYS);

	}

	@POST
	@Path("/upload/{duration}/{unit}")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadFile(@Context ServletContext context, @FormDataParam("file") File file,
			@FormDataParam("fileName") String filename, @PathParam("duration") long duration,
			@PathParam("unit") TimeUnit unit) throws Exception {
		String UPLOAD_PATH = context.getInitParameter("path.files");
		String id = SavedFilesImpl.getSavedFiles(UPLOAD_PATH).addFile(file, filename, duration, unit);
		return id;

	}

	@GET
	@Path("/get/{id}")
	@Produces({MediaType.APPLICATION_OCTET_STREAM, MediaType.TEXT_PLAIN})
	public Response uploadFile(@Context ServletContext context,@PathParam("id") String id) throws Exception {
		String UPLOAD_PATH = context.getInitParameter("path.files");
		File f = SavedFilesImpl.getSavedFiles(UPLOAD_PATH).getFile(id);
		if (f != null) {
			return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
					.header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"").build();
		}else {
			return Response.ok("The file you requested no longer exists.", MediaType.TEXT_PLAIN).status(Status.FORBIDDEN).build();
		}
	}
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.TEXT_PLAIN)
	public String saludo() {
		return "HOLA!!!";
	}
}
