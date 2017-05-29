package es.uam.app.main.commands;

import java.io.File;
import es.uam.app.main.exceptions.MessageException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.projects.Project;

public class Redo extends MainCommand {

	public Redo() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws MessageException, Exception {
		String nameProject = validProjectName(rm.getText());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			File png = actual.redo();
			throw new MessageException(rm.getText(), png);
		} else {
			throw new ProjectNotFoundException(nameProject);
		}
	}

}
