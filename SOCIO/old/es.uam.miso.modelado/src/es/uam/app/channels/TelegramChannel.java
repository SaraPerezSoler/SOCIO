package es.uam.app.channels;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.generics.BotSession;

import es.uam.app.channels.telegramCommands.TelegramCommand;
import es.uam.app.channels.telegramCommands.TelegramControl;
import es.uam.app.channels.telegramCommands.secrect.SecretCommand;
import es.uam.app.main.Main;
import es.uam.app.message.PrivateMsg;
import es.uam.app.message.ConsensusMsg;
import es.uam.app.message.SendMessageExc;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import projectHistory.Msg;
import socioProjects.User;

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
		
		List<Class<? extends SecretCommand>> secretCommands=new ArrayList<Class<? extends SecretCommand>>();
		new FastClasspathScanner(SecretCommand.class.getPackage().getName())
		.matchSubclassesOf(SecretCommand.class, secretCommands::add).scan();
		
		for (Class<? extends SecretCommand> tc: secretCommands){
			SecretCommand.regiterTelegramSecretCommand(tc, telegramControl);
		}
	}
	@Override
	public void run() {
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			telegramControl = new TelegramControl(this);
			init();
			BotSession bot=botsApi.registerBot(telegramControl);
		}catch (Exception e) {
			//Main21.log.error(e);
			e.printStackTrace();
		}catch (Throwable e) {
			Main.log.fatal(e);
		}
	}

	@Override
	public void answerMessage(Msg rMessage, SendMessageExc sMessage) {
		telegramControl.sendAnswerMessage(rMessage, sMessage);
	}

	@Override
	public void updateProject(SendMessageExc sMessage) {
		// TODO Auto-generated method stub

	}
	public TelegramControl getTelegramControl() {
		return telegramControl;
	}

	@Override
	public void sendPrivateMsg(Msg msg, PrivateMsg e) {
		
		if (e instanceof ConsensusMsg){
			telegramControl.sendConsensusMessage(msg, (ConsensusMsg)e);
		}else{
			telegramControl.sendPrivateMessage(msg, e);
		}
	}


}
