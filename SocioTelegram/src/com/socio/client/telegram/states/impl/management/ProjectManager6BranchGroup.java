package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManager6BranchGroup implements ConversationalState {
	private Project project;

	public static ProjectManager6BranchGroup getState(Project project) {
		return new ProjectManager6BranchGroup(project);
	}

	private ProjectManager6BranchGroup(Project project) {
		this.project = project;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		Project p = SOCIO.branchGroup(project, State.getUser(message.getFrom()), text);
		chat.sendMessage("The branch group has been updated \n"+State.printProjectAllInfo(p), message.getMessageId(), true);
		return Chat.getDefaultState();
	}

}
