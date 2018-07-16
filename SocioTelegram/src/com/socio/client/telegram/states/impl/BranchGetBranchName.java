package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class BranchGetBranchName implements ConversationalState {

	
	private static BranchGetBranchName BRANCH = new BranchGetBranchName();

	public static BranchGetBranchName getState() {
		return BRANCH;
	}

	private BranchGetBranchName() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = State.removeFirstCommand(message.getText());
		Project project = SOCIO.project(chat.getProject());
		chat.updateProject(project);
//		String msg = projectGroup(project.getOpenBranchs());
//		String [] options =projectGroupOptions(project.getOpenBranchs());
//		chat.sendMessageWithKeyboard(msg, message.getMessageId(), true, options);
		chat.askProjectGroup(project, message.getMessageId());
		return BranchGetGroup.getState(text);
	}

	

}
