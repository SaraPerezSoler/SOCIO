package com.socio.client.telegram.states.impl;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.NotProjectException;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Branch implements CommandState{

	private static final String BRANCH_MSG="Alright, a new branch. How are we going to call it? "
			+ "Please choose a name for the branch.";
	private static Branch BRANCH = new Branch();

	public static Branch getState() {
		return BRANCH;
	}

	private Branch() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		if (!chat.hasProject()) {
			throw new NotProjectException();
		}
		String text = State.removeFirstCommand(message.getText());
	
		if (text==null || text.isEmpty()) {
			chat.sendMessageAndForceReply(BRANCH_MSG, message.getMessageId(), false);
			return BranchGetBranchName.getState();
		}else {
			return BranchGetBranchName.getState().runAndNext(chat, message);
		}
		
	}

	@Override
	public String getCommand() {
		return "branch";
	}

	@Override
	public String getDescription() {
		return "create a new branch for a project";
	}

}
