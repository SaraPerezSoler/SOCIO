package es.uam.app.channels.telegramCommands.secrect;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.channels.telegramCommands.TelegramControl;

public class Reload extends SecretCommand {

	public Reload(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "reload";
	}

	@Override
	public void commandAction(Update update) {
		this.setStandardState(update.getMessage().getChatId());
		this.removerAllUserTalk(update.getMessage().getChatId());
		
		tChannel.write(update, CommandList.RELOAD, null,null,null);
	}

}
