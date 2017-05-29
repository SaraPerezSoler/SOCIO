package es.uam.app.main.commands;

import java.io.File;
import es.uam.app.main.exceptions.MessageException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.projects.Project;

public class Get extends MainCommand {

	public Get() {	}

	@Override
	public void execute(ReceivedMessage rm) throws MessageException, Exception {
		String nameProject = this.validProjectName(rm.getText());
		Project actual = Project.getProject(nameProject);
		if (actual != null) {
			File file = new File(actual.ecorePath());
			if (file.exists()) {
				MessageException e=new MessageException(rm.getText());
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
