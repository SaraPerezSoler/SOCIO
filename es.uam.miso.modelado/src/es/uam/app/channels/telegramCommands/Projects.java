package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;

public class Projects extends TelegramCommand{

	public Projects(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "projects";
	}

	@Override
	public String getDescription() {
		return "show a list of projects";
	}

	@Override
	public void commandAction(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());
		tChannel.write(update, CommandList.PROJECTS,null,null,null);
	}

}
