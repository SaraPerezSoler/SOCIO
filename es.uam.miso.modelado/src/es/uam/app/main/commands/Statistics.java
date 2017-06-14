package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.projects.Project;

public class Statistics extends MainCommand {

	public static final int USER_MSG = 0;
	public static final int USER_ACTION = 2;
	public static final int ACTION = 4;

	private int option;

	public Statistics(int option) {
		this.option = option;
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {

		String nameProject = validProjectName(rm.getProjectName());
		Project actual = Project.getProject(nameProject);
		if (actual == null) {
			throw new ProjectNotFoundException(nameProject);
		}
		if (option == USER_MSG) {
			if (!rm.hasText()) {
				File jpg = actual.getStatisticsUserMsg();
				throw new SendMessageExc(jpg);
			}else{
				File jpg =actual.getStatisticsUserMsg(rm.getText());
				throw new SendMessageExc(jpg);
			}
		}else if (option== USER_ACTION){
			if (!rm.hasText()) {
				File jpg = actual.getStatisticsUserAction();
				throw new SendMessageExc(jpg);
			}else{
				File jpg =actual.getStatisticsUserAction(rm.getText());
				throw new SendMessageExc(jpg);
			}
		}else{
			File jpg = actual.getStatisticsActions();
			throw new SendMessageExc(jpg);
		}

	}

}
