package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class ProjectManager implements CommandState {
	private static ProjectManager projectManagement = new ProjectManager();

	public static ProjectManager getState() {
		return projectManagement;
	}

	private ProjectManager() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		chat.askProject(message.getMessageId(), Chat.OWNER_LEVEL, State.getUser(message.getFrom()));
		return ProjectManagerGetProject.getState();
	}

	@Override
	public String getDescription() {
		return "Project manager: change visibility, add permision to a user.";
	}

	@Override
	public String getCommand() {
		return "projectmanager";
	}
	
	static State exit(Chat chat, Message message) throws TelegramApiException {
		chat.sendMessage("Leaving the projectManagement menu.", message.getMessageId(), false);
		return Chat.getDefaultState();
	}

}
