package es.uam.app.channels.telegram;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main.MainCommandEnum;
import es.uam.app.message.SentMessage;

public class Help extends TelegramCommand {

	private static final String[][] OPTIONS={{"Text", "Picture", "Commands"}};
	private static final String HELP_MSG="Choose how you get the help:\n";
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
		SentMessage sMessage= new SentMessage();
		sMessage.setText(HELP_MSG);
		tChannel.sendMessageWithChoose(update.getMessage().getChatId(), sMessage, OPTIONS, getCommand());
	}
	
	@Override
	public void userAnswer(Update update) {
		if (update.hasCallbackQuery()){
			String[] split=update.getCallbackQuery().getData().split(TelegramControl.CALL_BACK_SEPARATOR);
			String text= split[1];
			if (text.equals(OPTIONS[0][2])){
				SentMessage sMessage= new SentMessage();
				sMessage.setText(Start.getStartMsg());
				tChannel.sendMessage(-1, update.getCallbackQuery().getMessage().getChatId(), sMessage);
			}else if(text.equals(OPTIONS[0][1])){
				tChannel.write(update, MainCommandEnum.HELP_PICTURE.getName(), "");
			}else if(text.equals(OPTIONS[0][0])){
				tChannel.write(update, MainCommandEnum.HELP_TEXT.getName(), "");
			}
		}
	}

}
