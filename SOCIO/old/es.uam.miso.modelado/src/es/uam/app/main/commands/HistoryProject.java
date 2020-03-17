package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class HistoryProject extends MainCommand {

	public static final String ERROR_MENSAGE = "I don't fine history for this parametres:";
	public static final String ERROR_MENSAGE2_START = "The project ";
	public static final String ERROR_MENSAGE2_END = " is empty.";

	public HistoryProject() {
	}

	@Override
	public void execute(Msg rm) throws Exception {

		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}
		File png=actual.getProjectHistory();
		throw new SendMessageExc(png);
	}
	
	@Override
	public String getName() {
		return "HISTORY_PROJECT";
	}

	@Override
	public String getDesc() {
		return "send back a pic with the project actions";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
