package es.uam.app.channels;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import es.uam.app.channels.telegram.TelegramCommand;
import es.uam.app.channels.telegram.TelegramControl;
import es.uam.app.main.Main;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class TelegramChannel extends Channel {

	private TelegramControl telegramControl;

	public TelegramChannel(Pipe p) throws Exception {
		super("Telegram", p);
		
	}
	
	private void init() throws Exception{
		List<Class<? extends TelegramCommand>> commands=new ArrayList<Class<? extends TelegramCommand>>();
		new FastClasspathScanner(TelegramCommand.class.getPackage().getName())
		.matchSubclassesOf(TelegramCommand.class, commands::add).scan();
		
		for (Class<? extends TelegramCommand> tc: commands){
			TelegramCommand.regiterTelegramCommand(tc, telegramControl);
		}
	}
	@Override
	public void run() {
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			telegramControl = new TelegramControl(this);
			init();
			botsApi.registerBot(telegramControl);
		}catch (Exception e) {
			//Main21.log.error(e);
			e.printStackTrace();
		}catch (Throwable e) {
			Main.log.fatal(e);
		}
	}

	@Override
	public void answerMessage(ReceivedMessage rMessage, SendMessageExc sMessage) {
		telegramControl.sendAnswerMessage(rMessage, sMessage);
	}

	@Override
	public void updateProject(SendMessageExc sMessage) {
		// TODO Auto-generated method stub

	}
	public TelegramControl getTelegramControl() {
		return telegramControl;
	}

}
