package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class History extends MainCommand{

	public History() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc {
		if (rm.getText() == null) {
			return;
		}
		String nameProject = validProjectName(rm.getText());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			File history = actual.getHistory();
			throw new SendMessageExc(rm.getText(), history);
		} else {
			throw new ProjectNotFoundException(nameProject);
		}
		
	}

}
