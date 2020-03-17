package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class NewProject implements CommandState{
	private static NewProject NEW_PROJECT = new NewProject();

	public static NewProject getState() {
		return NEW_PROJECT;
	}

	private NewProject() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text= State.removeFirstCommand(message.getText());
		if (text==null || text.isEmpty()) {
			askProjectName(chat, message.getMessageId());
			return NewProjectGetName.getState();
		}else {
			return NewProjectGetName.getState().runAndNext(chat, message);
		}
	}

	@Override
	public String getCommand() {
		return "newproject";
	}

	@Override
	public String getDescription() {
		return "create and set a new project";
	}

	public void askProjectName(Chat chat, int inReply) throws TelegramApiException {
		chat.sendMessageAndForceReply("How are we going to call it? Please choose a name for the project.", inReply, false);
	}

}
