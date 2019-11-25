package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManager4Visibility implements ConversationalState{

	private Project project;

	public static ProjectManager4Visibility getState(Project project) {
		return new ProjectManager4Visibility(project);
	}

	private ProjectManager4Visibility(Project project) {
		this.project = project;
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		Visibility v= Visibility.valueOf(message.getText().toUpperCase());
		project=State.SOCIO().changeVisibility(project, State.getUser(message.getFrom()), v);
		chat.sendMessage("The project visibility has been updated \n"+State.printProjectAllInfo(project), message.getMessageId(), true);
		return Chat.getDefaultState();
	}

}
