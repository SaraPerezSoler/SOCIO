package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class StatisticsUserAuthorship extends MainCommand {

	public StatisticsUserAuthorship() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}
		File jpg = actual.percentOfAuthorship();
		throw new SendMessageExc(jpg);

	}

	@Override
	public String getName() {
		return "PERCENT_AUTHORSHIP";
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getNeeds() {
		return project();
	}

}
