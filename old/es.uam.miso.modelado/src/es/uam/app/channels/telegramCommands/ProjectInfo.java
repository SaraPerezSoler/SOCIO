package es.uam.app.channels.telegramCommands;


import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.message.SendMessageExc;

public class ProjectInfo extends TelegramCommand {

	

	public ProjectInfo(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "projectinfo";
	}

	@Override
	public String getDescription() {
		return "gets information about the project that is selected in the chat";
	}

	@Override
	public void commandAction(Update update) {
		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());

		this.setStandardState(update.getMessage().getChatId());
		
		String project = this.getProject(update.getMessage().getChatId());
		// Comprobamos si el chat tiene un proyecto asignado
		if (project == null || project.equals("")) {
			this.setStandardState(update.getMessage().getChatId());
			SendMessageExc msg = new SendMessageExc(STANDARD_ERROR_MSG);
			tChannel.sendMessage(update.getMessage().getMessageId(), update.getMessage().getChatId(), msg);

		} else {
			tChannel.write(update, CommandList.PROJECT_INFO, project, null, null);
		}

	}

}
