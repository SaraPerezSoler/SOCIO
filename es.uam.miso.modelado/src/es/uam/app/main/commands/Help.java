package es.uam.app.main.commands;

import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;

public class Help extends MainCommand {

	public static final String HELP = "https://saraperezsoler.github.io/ModellingBot/";
	private static final String HELP_MSG="You can get help to modelling bot here:\n";


	public Help() {
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		SendMessageExc send= new SendMessageExc(HELP_MSG);
		send.setUrl(HELP);
		throw send;

	}

}
