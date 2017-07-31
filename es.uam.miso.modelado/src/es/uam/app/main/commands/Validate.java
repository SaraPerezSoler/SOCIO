package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

public class Validate extends MainCommand {

	public Validate() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects actual = LocalProjects.getProject(nameProject);
		if (actual != null) {
			if (!(rm.getUser().canRead(actual))){
				throw new NotAccessException("");
			}
			String text = actual.validate();
			throw new SendMessageExc("Validate " + nameProject + ":\n\n" + text);

		} else {
			throw new ProjectNotFoundException(nameProject);
		}

	}

}
