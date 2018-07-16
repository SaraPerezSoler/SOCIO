package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManagerBranchGroup implements ConversationalState {
	//private Project project;

	public static ProjectManagerBranchGroup getState(Project project) {
		return new ProjectManagerBranchGroup(project);
	}

	private ProjectManagerBranchGroup(Project project) {
		//this.project = project;
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		//String text = message.getText();
		chat.sendMessage("Under construction", message.getMessageId(), false);
		return Chat.getDefaultState();
	}

}
