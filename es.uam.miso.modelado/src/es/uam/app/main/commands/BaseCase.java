package es.uam.app.main.commands;

import java.io.File;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class BaseCase extends MainCommand {

	public BaseCase() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual = searchProject(rm);

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

	}

	@Override
	public String getName() {
		return "BASE_CASE";
	}

	@Override
	public String getDesc() {
		return "Base case of the bot, analyzes a message in natural language(NL) to modify the model\n"
				+ "if the msg doesnt have a text, the bot displays the current state of the model.\n"
				+ "the user need permission to write to modify the model and permission to read to see the state";
	}

	@Override
	public String getNeeds() {
		return project()+", a sentence in NL";
	}

}
