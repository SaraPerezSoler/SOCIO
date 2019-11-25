package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class NewProjectGetVisibility implements ConversationalState {
	
	private String name;

	public static NewProjectGetVisibility getState(String name) {
		return new NewProjectGetVisibility(name);
	}

	private NewProjectGetVisibility(String name) {
		this.name= name;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		Visibility visibility= Visibility.valueOf(message.getText().toUpperCase());
		if (visibility==null) {
			visibility=Visibility.PUBLIC;
		}
		Project project = State.SOCIO().newProject(name, State.getUser(message.getFrom()), visibility);
		chat.sendMessage("Project created:", message.getMessageId(), false);
		chat.setProject(project, -1);
		return Chat.getDefaultState();
	}

}
