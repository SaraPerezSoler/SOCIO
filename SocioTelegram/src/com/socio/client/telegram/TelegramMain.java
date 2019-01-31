package com.socio.client.telegram;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

import com.socio.client.telegram.states.CommandState;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class TelegramMain {

	private static String debugFile; 
	public static void main(String[] args) {
		String debug=TelegramControl.SOCIO;
		for (int i=0; i<args.length; i++) {
			String s = args[i];
			if (s.equalsIgnoreCase("debug")) {
				debug=TelegramControl.TEST;
			}
			if (s.equalsIgnoreCase("-passfile")) {
				TelegramControl.PASS=args[i+1];
			}
			if (s.equalsIgnoreCase("-debugfile")) {
				debugFile=args[i+1];
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
