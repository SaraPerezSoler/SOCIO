package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Undoplus implements CommandState{

	private static final String UNDOPLUS_MSG = "How many undos do you want?";
	private static Undoplus UNDO_PLUS = new Undoplus();

	public static Undoplus getState() {
		return UNDO_PLUS;
	}
	
	private Undoplus() {
	}
	
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text= State.removeFirstCommand(message.getText());
		if (text==null || text.isEmpty()) {
			chat.sendMessageAndForceReply(UNDOPLUS_MSG, message.getMessageId(), false);
			return UnduplusAsk.getState();
		}else {
			return UnduplusAsk.getState().runAndNext(chat, message);
		}
	}

	@Override
	public String getCommand() {
		
		return "undo+";
	}

	@Override
	public String getDescription() {
		return "undo the last N messages";
	}

}
