package com.socio.client.telegram;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import com.socio.client.telegram.states.CommandState;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class TelegramMain {

	public static void main(String[] args) {
		String debug=TelegramControl.SOCIO;
		for (String s: args) {
			if (s.equalsIgnoreCase("debug")) {
				debug=TelegramControl.TEST;
			}
		}
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			init();
			TelegramControl telegramControl = TelegramControl.createTelegramControl(debug);
			botsApi.registerBot(telegramControl);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws Exception{
		List<Class<? extends CommandState>> commands=new ArrayList<Class<? extends CommandState>>();
		new FastClasspathScanner(CommandState.class.getPackage().getName())
		.matchClassesImplementing(CommandState.class, commands::add).scan();
		
		for (Class<? extends CommandState> tc: commands){
			TelegramControl.regiterTelegramCommand(tc);
		}
	}
}
