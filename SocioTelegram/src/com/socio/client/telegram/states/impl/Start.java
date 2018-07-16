package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Start implements CommandState {

	private static final String WELCOME = "I can help you create and manager models.";

	private static Start START=null;
	public static Start getState() {
		if (START==null) {
			START=new Start();
		}
		return START;
	}
	
	private Start() {	
	}
	
	@Override
	public String getCommand() {
		return "start";
	}

	@Override
	public String getDescription() {
		return "starts the bot";
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException {
		chat.sendMessage(getStartMsg(), message.getMessageId(), false);
		return Chat.getDefaultState();
	}

	private static String getStartMsg() {
		String ret = WELCOME + "\n\n";
		for (String key : TelegramControl.commandState.keySet()) {
			ret += "/" + TelegramControl.commandState.get(key).getCommand() + " - "
					+ TelegramControl.commandState.get(key).getDescription() + "\n";
		}
		return ret;
	}
}
