package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class StatisticsUserMsgAbs extends MainCommand {

	public StatisticsUserMsgAbs() {

	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}

		File jpg = actual.getStatisticsUserMsgAbs();
		throw new SendMessageExc(jpg);
	}

	@Override
	public String getName() {
		return "STA_USER_MSG_ABS";
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
