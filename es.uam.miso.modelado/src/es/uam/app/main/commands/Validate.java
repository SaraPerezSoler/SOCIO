package es.uam.app.main.commands;

import es.uam.app.main.exceptions.MessageException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.projects.Project;

public class Validate extends MainCommand {

	public Validate() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws MessageException, Exception {
		String nameProject = validProjectName(rm.getText());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			String text = actual.validate();
			throw new MessageException("Validate " + nameProject + ":\n\n" + text);

		} else {
			throw new ProjectNotFoundException(nameProject);
		}

	}

}
