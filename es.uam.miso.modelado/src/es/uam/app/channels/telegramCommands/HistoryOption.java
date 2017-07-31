package es.uam.app.channels.telegramCommands;

import org.telegram.telegrambots.api.objects.Update;


public abstract class HistoryOption {

	protected final String BACK = "\u2b05\ufe0f" + " Back";
	protected final String WHO="Who?";
	

	
	protected History history;

	public HistoryOption(History history) {
		super();
		this.history = history;
	}
	
	public abstract void userAnswerText(Update update);
	public abstract void start(Update update);
}
