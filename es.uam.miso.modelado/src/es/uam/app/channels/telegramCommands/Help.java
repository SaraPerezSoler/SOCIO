package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;

public class Help extends TelegramCommand {

	
	
	public Help(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "help";
	}

	@Override
	public String getDescription() {
		return "see a command list";
	}

	@Override
	public void commandAction(Update update) {

		this.removerUserTalk(update.getMessage().getChatId(), update.getMessage().getFrom());
		this.setState(update.getMessage().getChatId());
		tChannel.write(update, CommandList.HELP, "", "");
	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, Msg rMessageCommand, SendMessageExc sMessage) {
		String url=sMessage.getUrl();
		
		tChannel.sendMessageWithURL(chatId, sMessage, new String[][]{{"Modelling Bot help"}}, new String[][]{{url}});
		
	}

}
