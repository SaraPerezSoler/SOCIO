package es.uam.app.main.exceptions;

public class ProjectNotFoundException extends MessageException {

	/**
	 * 
	 */
	public static final String PROJECT_NOT_FOUND = "I don't find the project: ";
	private static final long serialVersionUID = 1L;
	public ProjectNotFoundException(String nameProject) {
		super(PROJECT_NOT_FOUND+nameProject);
	}

}
