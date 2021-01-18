package recommenderQuestionnaire.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import generator.Bot;
import recommenderQuestionnaire.main.RecommenderControl;

/**
 * Servlet implementation class ProcesaFichero
 */
@WebServlet("/StartQuestionnaire")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class StartQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Metamodel";
	private static final String FILE_EXTENSION = ".bot";
	public static final String ID = "id";
	private static final String FILE_ATTRIBUTE_NAME = "model-file";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartQuestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear el directorio donde se va a guardar una copia del fichero enviado por
		// el usuario
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		// Comprobar que el usuario solo ha mandado un fichero
		if (request.getParts().size() > 1 || request.getParts().size() < 0) {
			response.getWriter().append("Send one and only one file. Served at: ").append(request.getContextPath());
		}
		// Copiar el fichero mandado por el usuario al directorio que se acaba de crear
		String fileName;
		String filepath = "";
		for (Part part : request.getParts()) {
			if (part.getName().equals(FILE_ATTRIBUTE_NAME)) {
				fileName = getFileName(part);
				filepath = uploadPath + File.separator + fileName;
				part.write(filepath);
			}
		}

		File f = new File(filepath);
		if (!f.exists()) {
			response.getWriter().append("Internal Error. Served at: ").append(request.getContextPath());
		}
		String path = readFile(getServletContext(), f);
		Bot bot = RecommenderControl.getBot(path);
		RecommenderControl control = RecommenderControl
				.getRecommenderControl(getServletContext().getInitParameter("RecommenderPath"), null);
		Map<String, String> evaluationLevel = new HashMap<String, String>();
		for (String ev : control.getEvaluations().keySet()) {
			String name = control.getQuestionName(ev);
			String value = request.getParameter(name);
			evaluationLevel.put(ev, value);
		}
		long id = control.newUser(bot, evaluationLevel);

		HttpSession session = request.getSession(true);
		session.setAttribute(ID, id);

		RequestDispatcher jsp;
		jsp = getServletContext().getRequestDispatcher("/Questionnaire.jsp");
		jsp.forward(request, response);
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				String path = content.substring(content.indexOf("=") + 2, content.length() - 1);
				Path uri = new File(path).toPath();
				String filename = uri.getFileName().toString();
				if (!filename.endsWith(FILE_EXTENSION)) {
					filename = filename + FILE_EXTENSION;
				}
				return filename;
			}
		}
		return null;
	}

	private String readFile(ServletContext context, File file) {

		/* Abrir el fichero y leer el modelo, falta control de errores */
		System.out.println(file.getPath());
		String path = file.getPath().substring(file.getPath().indexOf(":") + 1);
		return path;
	}
}
