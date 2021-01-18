package botGenerator.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class GetFiles
 */
@WebServlet("/getfiles/*")
public class GetFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourceName = req.getParameter("resource");
		String botName = resourceName.replace(".bot", "");
		String tool = req.getPathInfo().substring(1);
		
		File srcFile = new File(BasePath.BASE_PATH+"/"+botName+"/"+tool+"/"+botName+".zip");;
		if (!srcFile.exists()) {
			resp.setContentType("text/plain");
	        resp.getWriter().println("The file "+tool+"/"+botName+".zip doesn't exist");
		}else {
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "filename=\""+tool+"_"+botName+".zip\"");
			FileUtils.copyFile(srcFile, resp.getOutputStream());
		}
		
	}

}
