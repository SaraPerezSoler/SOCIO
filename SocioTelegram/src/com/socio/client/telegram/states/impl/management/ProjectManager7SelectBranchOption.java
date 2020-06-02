package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManager7SelectBranchOption  implements ConversationalState{
	
	public static final String[] SELECT_BRANCH_OPTIONS = { "Select one option", "Vote for one option", ProjectManager2GetProject.EXIT};
	private Project project;

	public static ProjectManager7SelectBranchOption getState(Project project) {
		return new ProjectManager7SelectBranchOption(project);
	}

	private ProjectManager7SelectBranchOption(Project project) {
		this.project = project;
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		if (project.getOpenBranchs().get(text) == null) {
			chat.sendMessage(text + " is not a branch group of "+project.getCompleteName(), message.getMessageId(), false);
			return ProjectManager1.exit(chat, message);
		}
		chat.sendMessageWithKeyboard("How?", message.getMessageId(), false, SELECT_BRANCH_OPTIONS);
		return ProjectManager8SelectBranchOption.getState(project, text);
	}

}
