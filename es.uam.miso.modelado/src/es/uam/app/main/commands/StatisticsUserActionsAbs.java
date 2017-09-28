package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class StatisticsUserActionsAbs extends MainCommand {


	public StatisticsUserActionsAbs() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual = searchProject(rm);

		File jpg = actual.getStatisticsUserActionAbs();
		throw new SendMessageExc(jpg);

	}

	@Override
	public String getName() {
		return "STA_USER_ACTIONS_ABS";
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
