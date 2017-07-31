package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.LocalProjects;

public class BaseCase extends MainCommand {

	public BaseCase() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects actual = LocalProjects.getProject(nameProject);

		if (actual != null) {
			if (rm.hasText()) {
				if (rm.getUser().canEdit(actual)) {
					File png = actual.execute(rm);
					throw new SendMessageExc(rm.getCommand(), png);
				} else {
					throw new NotAccessException("You don't have editing permissions in this project.");
				}
			} else {
				if (rm.getUser().canRead(actual)) {
					File png = actual.execute(rm);
					throw new SendMessageExc(rm.getCommand(), png);
				} else {
					throw new NotAccessException("You don't have reading permissions in this project.");
				}
			}
		} else {
			throw new ProjectNotFoundException(nameProject);
		}
	}

}
