package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class ProjectManager1 implements CommandState {
	private static ProjectManager1 projectManagement = new ProjectManager1();

	public static ProjectManager1 getState() {
		return projectManagement;
	}

	private ProjectManager1() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		chat.askProject(message.getMessageId(), Chat.OWNER_LEVEL, State.getUser(message.getFrom()));
		return ProjectManager2GetProject.getState();
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
