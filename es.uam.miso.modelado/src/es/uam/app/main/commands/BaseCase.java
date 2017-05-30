package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class BaseCase extends MainCommand {

	public BaseCase() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		String nameProject = validProjectName(rm.getCommand());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			File png = actual.execute(rm);
			throw new SendMessageExc(rm.getCommand(), png);
		} else {
			throw new ProjectNotFoundException(nameProject);
		}
	}


}
