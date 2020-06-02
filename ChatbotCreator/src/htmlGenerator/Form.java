package htmlGenerator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Form {

	public static String checked(boolean checked) {
		if (checked) {
			return "checked";
		}
		return "";
	}

	public static String getSynonymsString(List<String> synonyms) {
		String list = "";
		for (int i = 0; i < synonyms.size(); i++) {
			if (i != (synonyms.size() - 1)) {
				list += synonyms.get(i) + ", ";
			} else {
				list += synonyms.get(i);
			}
		}
		return list;
	}

	public static String getSelectedName(HttpServletRequest request, HttpSession session) {
		String selectedName = null;
		if (session.getAttribute("selectedName") != null) {
			selectedName = (String) session.getAttribute("selectedName");
			session.setAttribute("selectedName", null);
		} else {
			selectedName = request.getParameter("selectedName");

		}
		return selectedName;
	}

	public static String getTemplatesString(List<String> templates) {
		String list = "";
		for (int i = 0; i < templates.size(); i++) {
			list += templates.get(i) + ";\n";
		}
		return list;
	}
}