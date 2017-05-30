package es.uam.app.main.exceptions;

import es.uam.app.message.SendMessageExc;

public class ProjectNotFoundException extends SendMessageExc {

	/**
	 * 
	 */
	public static final String PROJECT_NOT_FOUND = "I don't find the project: ";
	private static final long serialVersionUID = 1L;
	public ProjectNotFoundException(String nameProject) {
		super(PROJECT_NOT_FOUND+nameProject);
	}

}
