package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Redoplus implements CommandState{

	
	private static final String REDOPLUS_MSG = "How many redos do you want?";
	private static Redoplus REDO_PLUS = new Redoplus();

	public static Redoplus getState() {
		return REDO_PLUS;
	}
	
	private Redoplus() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text= State.removeFirstCommand(message.getText());
		if (text==null || text.isEmpty()) {
			chat.sendMessageAndForceReply(REDOPLUS_MSG, message.getMessageId(), false);
			return RedoplusAsk.getState();
		}else {
			return RedoplusAsk.getState().runAndNext(chat, message);
		}
	}

	@Override
	public String getCommand() {
		return "redoplus";
	}

	@Override
	public String getDescription() {
		return "redo the last N undos";
	}

}
