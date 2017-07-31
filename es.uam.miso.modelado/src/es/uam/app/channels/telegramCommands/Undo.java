package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main;
import es.uam.app.message.SendMessageExc;

public class Undo extends TelegramCommand {

	public Undo(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "undo";
	}

	@Override
	public String getDescription() {
		return "undo the last message";
	}

	@Override
	public void commandAction(Update update) {
		
		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());
		this.setStandardState(update.getMessage().getChatId());
		
		String project = this.getProject(update.getMessage().getChatId());
		if (project == null || project.equals("")) {
			SendMessageExc sent = new SendMessageExc(STANDARD_ERROR_MSG);
			tChannel.sendMessage(-1, update.getMessage().getChatId(), sent);
		} else {
			tChannel.write(update, Main.MainCommandEnum.UNDO.getName(), project, "");
		}
	}

}
