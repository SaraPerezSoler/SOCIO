package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Validate implements CommandState {
	private static Validate VALIDATE = new Validate();

	public static Validate getState() {
		return VALIDATE;
	}

	private Validate() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		String response = SOCIO.validate(chat.getProject(), State.getUser(message.getFrom()));
		chat.sendMessage(response, message.getMessageId(), false);
		return Chat.getDefaultState();
	}

	@Override
	public String getCommand() {
		return "validate";
	}

	@Override
	public String getDescription() {
		return "validate the model";
	}

}
