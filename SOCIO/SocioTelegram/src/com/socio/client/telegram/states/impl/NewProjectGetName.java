package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class NewProjectGetName implements ConversationalState {

	private static NewProjectGetName NEW_PROJECT = new NewProjectGetName();

	public static NewProjectGetName getState() {
		return NEW_PROJECT;
	}

	private NewProjectGetName() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text= State.removeFirstCommand(message.getText());
		chat.askProjectVisibility(message.getMessageId());
		return NewProjectGetVisibility.getState(text);
	}


}
