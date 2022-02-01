package es.uam.app.main.commands;

import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Help extends MainCommand {

	public static final String HELP = "https://saraperezsoler.github.io/ModellingBot/";
	private static final String HELP_MSG="You can get help to modelling bot here:\n";


	public Help() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		SendMessageExc send= new SendMessageExc(HELP_MSG);
		send.setUrl(HELP);
		throw send;

	}

	@Override
	public String getName() {
		return "HELP";
	}

	@Override
	public String getDesc() {
		return "redirects to a web page with tips and examples to work with SOCIO";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
