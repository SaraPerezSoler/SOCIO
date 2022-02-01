package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class Get extends MainCommand {

	public Get() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual=searchProject(rm);
		if (!(rm.getUser().canEdit(actual))) {
			throw new NotAccessException("");
		}

		File file = new File(actual.getFilePath());
		if (file.exists()) {
			SendMessageExc e = new SendMessageExc(rm.getText());
			e.setDocument(file);
			throw e;
		} else {
			throw new ProjectNotFoundException(actual.getName());
		}

	}

	@Override
	public String getName() {
		return "GET";
	}

	@Override
	public String getDesc() {
		return "downloads the meta-model in ecore format, the user needs permission to read";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
