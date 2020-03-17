package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelInfo.NLElement;
import modelInfo.NLModel;

/**
 * Servlet implementation class ConfiguratorServlet
 */
@WebServlet("/ConfiguratorServlet")
public class ConfiguratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static NLModel MODEL = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfiguratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Enumeration<String> parameter = request.getParameterNames();
		String button = parameter.nextElement();
		if (button.startsWith("Attribute:")) {
			button = button.replace("Attribute:", "");
			session.setAttribute(ProcesaFichero.PAGE, ProcesaFichero.ATTR_PAGE);
		}else if (button.startsWith("Reference:")) {
			button = button.replace("Reference:", "");
			session.setAttribute(ProcesaFichero.PAGE, ProcesaFichero.REF_PAGE);
		}else if (button.startsWith("Class:")) {
			button = button.replace("Class:", "");
			session.setAttribute(ProcesaFichero.PAGE, ProcesaFichero.CLASS_PAGE);
		}
		session.setAttribute(ProcesaFichero.SELECTED, button);
		RequestDispatcher jsp;
        jsp = getServletContext().getRequestDispatcher("/Configurator.jsp");
        jsp.forward(request, response);
	}
	
	

}
