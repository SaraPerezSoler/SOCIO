package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Get implements CommandState {
	
	private static Get GET =new Get();

	public static Get getState() {
		return GET;
	}
	
	private Get() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text=State.removeFirstCommand(message.getText());
		if ((text==null || text.isEmpty()) && !chat.hasProject()) {
			chat.askProject(message.getMessageId(), Chat.READ_LEVEL, State.getUser(message.getFrom()));
			return GetConversational.getState();
		}
		return GetConversational.getState().runAndNext(chat, message);
	}

	@Override
	public String getCommand() {
		return "get";
	}

	@Override
	public String getDescription() {
		return "send a file with the model";
	}
}
