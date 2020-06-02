package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class StatisticsUserMsg extends MainCommand {

	public StatisticsUserMsg() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual = searchProject(rm);

		if (!(rm.getUser().canRead(actual))) {
			throw new NotAccessException("");
		}

		if (!rm.hasUserToSearch()) {
			File jpg = actual.getStatisticsUserMsg();
			throw new SendMessageExc(jpg);
		} else {
			User u=searchUser(rm.getUserToSearch());
			File jpg = actual.getStatisticsUserMsg(u);
			throw new SendMessageExc(jpg);
		}
	}

	@Override
	public String getName() {
		return "STA_USER_MSG";
	}

	@Override
	public String getDesc() {
		return "";
	}

	@Override
	public String getNeeds() {
		return project()+", optional: "+userToSearch();
	}

}
