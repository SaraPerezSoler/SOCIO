package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

public class Redo extends MainCommand {

	public Redo() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects actual = LocalProjects.getProject(nameProject);
		if (actual != null) {
			
			if (!(rm.getUser().canEdit(actual))){
				throw new NotAccessException("");
			}
			
			File png = actual.redo();
			throw new SendMessageExc(rm.getText(), png);
		} else {
			throw new ProjectNotFoundException(nameProject);
		}
	}

}
