package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main.MainCommandEnum;
import es.uam.app.message.SendMessageExc;

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
		tChannel.write(update, MainCommandEnum.HELP.getName(), "");
	}
	
	@Override
	public void modellingAnswer(long chatId, int msgId, String rMessageCommand, SendMessageExc sMessage) {
		String url=sMessage.getUrl();
		
		tChannel.sendMessageWithURL(chatId, sMessage, new String[][]{{"Modelling Bot help"}}, new String[][]{{url}});
		
	}

}
