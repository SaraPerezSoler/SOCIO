package com.socio.client.telegram.states.impl.management;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManager2GetProject implements ConversationalState {

	static final String[] OPTIONS = { "Change project visibility",  };
	static final String [] NO_PUBLIC_OPTION= {"Manage project users"};
	static final String[] BRANCH_OPTIONS = { "Change branch group" };
	static final String[] WITH_BRANCH_OPTIONS = { "Select a branch" };
	static final String EXIT = "Exit";
	private static ProjectManager2GetProject projectManagement = new ProjectManager2GetProject();

	public static ProjectManager2GetProject getState() {
		return projectManagement;
	}

	private ProjectManager2GetProject() {
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {

		String text = message.getText();
		Project project = TelegramControl.projects.get(text);
		if (project == null) {
			project = SOCIO.project(text);
		} else {
			project = SOCIO.project(project);
		}
		TelegramControl.projects.put(project.getCompleteName(), project);
		String[] options;
		List<String> lisOptions= new ArrayList<>();
		for (String op: OPTIONS) {
			lisOptions.add(op);
		}
		if (project.getVisibility() != Visibility.PUBLIC) {
			for (String op: NO_PUBLIC_OPTION) {
				lisOptions.add(op);
			}
		}
		if (project.isBranch()) {
			for (String op: BRANCH_OPTIONS) {
				lisOptions.add(op);
			}	

		} else {
			if (!project.getOpenBranchs().isEmpty()) {
				for (String op: WITH_BRANCH_OPTIONS) {
					lisOptions.add(op);
				}
			}
		}
		lisOptions.add(EXIT);
		options= new String[lisOptions.size()];
		options= lisOptions.toArray(options);
		
		chat.sendMessageWithKeyboard(State.printProjectAllInfo(project) + "\n\nWhat do you want to do?",
				message.getMessageId(), true, options);
		return ProjectManager3Option.getState(project);
	}

}
