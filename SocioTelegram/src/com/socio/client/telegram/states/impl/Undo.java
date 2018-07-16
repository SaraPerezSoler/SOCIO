package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.Date;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Undo implements CommandState {
	private static Undo UNDO =new Undo();

	public static Undo getState() {
		return UNDO;
	}
	
	private Undo() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		File file = SOCIO.undo(chat.getProject(), State.getUser(message.getFrom()), message.getText(), message.getText(),
				new Date(), getMessageId(message));
		chat.sendPhoto(file, message.getMessageId());
		return Chat.getDefaultState();
	}

	@Override
	public String getCommand() {
		return "undo";
	}

	@Override
	public String getDescription() {
		return "undo the last message";
	}

}
