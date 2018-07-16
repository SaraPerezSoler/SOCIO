package com.socio.client.telegram.states.impl;

import java.io.File;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class BranchGetGroup implements ConversationalState {

	private String branchName;

	public static BranchGetGroup getState(String branchName) {
		return new BranchGetGroup(branchName);
	}

	private BranchGetGroup(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		File file=SOCIO.newBranch(chat.getProject(), State.getUser(message.getFrom()), branchName, text);
		chat.sendMessage("A branch is created", message.getMessageId(), false);
		chat.sendPhoto(file);
		return Chat.getDefaultState();
	}

}
