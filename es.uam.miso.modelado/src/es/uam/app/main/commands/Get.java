package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class Get extends MainCommand {

	public Get() {	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		String nameProject = this.validProjectName(rm.getText());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			File file = new File(actual.ecorePath());
			if (file.exists()) {
				SendMessageExc e=new SendMessageExc(rm.getText());
				e.setDocument(file);
				throw e;
			} else {
				throw new ProjectNotFoundException(nameProject);
			}
		} else {
			throw new ProjectNotFoundException(nameProject);
		}

	}

}
