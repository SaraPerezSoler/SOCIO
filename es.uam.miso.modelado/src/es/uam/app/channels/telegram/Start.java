package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.message.SendMessageExc;

public class Start extends TelegramCommand {

	public Start(TelegramControl tChannel) {
		super(tChannel);
	}

	private static final String WELCOME = "I can help you create and manager models.";
	
	
	
	@Override
	public String getCommand() {
		return "start";
	}

	@Override
	public String getDescription() {
		return "start or restart the bot";
	}

	@Override
	public void commandAction(Update update) {
		
		
		this.setState(update.getMessage().getChatId());
		this.setProject(update.getMessage().getChatId(), "");
		this.removerAllUserTalk(update.getMessage().getChatId());

		SendMessageExc sent = new SendMessageExc(getStartMsg());
		tChannel.sendMessage(-1, update.getMessage().getChatId(), sent);

	}

	public static String getStartMsg(){
		String ret= WELCOME+"\n\n";
		for (TelegramCommand s:TelegramCommand.commands){
			ret+="/"+s.getCommand()+" - "+s.getDescription()+"\n";
		}
		return ret;
	}

}
