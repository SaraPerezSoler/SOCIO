package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class RedoplusAsk implements ConversationalState{
	private static final String REDOPLUS_MSG = "How many redos do you want?";
	private static final String REDOPLUS_MSG1 = "The value must be a number.";
	private static RedoplusAsk REDO_PLUS = new RedoplusAsk();

	public static RedoplusAsk getState() {
		return REDO_PLUS;
	}
	
	private RedoplusAsk() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		if (text == null || text.isEmpty()) {
			chat.sendMessageAndForceReply(REDOPLUS_MSG, message.getMessageId(), false);
			return this;
		} else {
			try {
				int i = Integer.parseInt(text.replaceAll(" ", ""));
				File file = null;
				for (int j = 0; j < i; j++) {
					file = State.SOCIO().redo(chat.getProject(), State.getUser(message.getFrom()), message.getText(),
							message.getText(), new Date(), getMessageId(message));
				}
				if (file == null) {
					chat.sendMessageAndForceReply("There is not change", message.getMessageId(), false);
				}
				chat.sendPhoto(file, message.getMessageId());
				return Chat.getDefaultState();
			} catch (NumberFormatException e) {
				chat.sendMessageAndForceReply(REDOPLUS_MSG1+REDOPLUS_MSG, message.getMessageId(), false);
				return this;
			}
		}
	}

}
