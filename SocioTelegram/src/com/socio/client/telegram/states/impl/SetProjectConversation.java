package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class SetProjectConversation implements ConversationalState {
	private static SetProjectConversation SET_PROJECT = new SetProjectConversation();

	public static SetProjectConversation getState() {
		return SET_PROJECT;
	}

	private SetProjectConversation() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		Project project = TelegramControl.projects.get(text);
		if (project == null) {
			project = SOCIO.project(text);
		} else {
			project = SOCIO.project(project);
		}
		chat.setProject(project, message.getMessageId());
		return Chat.getDefaultState();
	}

}
