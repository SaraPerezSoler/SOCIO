package com.socio.client.telegram.states.impl;

import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Projects implements CommandState {
	private static Projects PROJECTS = new Projects();

	public static Projects getState() {
		return PROJECTS;
	}

	private Projects() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		List<Project> projects = State.SOCIO().projects();
		chat.sendMessage(State.printProjects(projects), message.getMessageId(), true);
		return Chat.getDefaultState();
	}

	@Override
	public String getCommand() {
		return "projects";
	}

	@Override
	public String getDescription() {
		return "show a list of projects";
	}
}
