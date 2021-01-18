package recommenderQuestionnaire.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import answers.QuestionAnswer.RelevanceLevel;
import recommenderQuestionnaire.main.RecommenderControl;

/**
 * Servlet implementation class EndQuestionnaire
 */
@WebServlet("/EndQuestionnaire")
public class EndQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EndQuestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(true);
		long id = (long) session.getAttribute(StartQuestionnaire.ID);
		RecommenderControl control = RecommenderControl
				.getRecommenderControl(getServletContext().getInitParameter("RecommenderPath"), null);
		for (String question : control.getQuestions().keySet()) {
			String name = control.getQuestionName(question);
			boolean multi = control.isMulti(question);
			List<String> optionsList = new ArrayList<String>();
			if (multi) {
				String[] options = request.getParameterValues(name + "-Answer");
				if (options != null) {
					for (String opt : options) {
						optionsList.add(opt);
					}
				}
			} else {
				String opt = request.getParameter(name + "-Answer");
				if (opt != null) {
					optionsList.add(opt);
				}
			}
			String relevanceString = request.getParameter(name + "-Relevant");
			RelevanceLevel level = RelevanceLevel.getRelevanceLevelByText(relevanceString);
			if (level != RelevanceLevel.NOT_RELEVANT && optionsList.isEmpty()) {
				// Enviar error!!! poner alerta
			}

			control.addAnswer(id, question, optionsList, level);
		}
		
		control.calculateRanking(id);
		session.setAttribute(StartQuestionnaire.ID, id);
		RequestDispatcher jsp;
		jsp = getServletContext().getRequestDispatcher("/Ranking.jsp");
		jsp.forward(request, response);
	}

}
