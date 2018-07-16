package com.socio.client.telegram.states.impl.management;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManagerGetOption implements ConversationalState {

	private static final String[] OPTIONS = ProjectManagerGetProject.OPTIONS;
	private static final String[] NO_PUBLIC_OPTIONS = ProjectManagerGetProject.NO_PUBLIC_OPTION;
	private static final String[] BRANCH_OPTIONS = ProjectManagerGetProject.BRANCH_OPTIONS;
	private static final String[] WITH_BRANCH_OPTIONS = ProjectManagerGetProject.WITH_BRANCH_OPTIONS;
	private static final String[] USER_OPTIONS = { "Add an user to the project", "Remove an user to the project",
			"Change an user access" };
	private Project project;

	public static ProjectManagerGetOption getState(Project project) {
		return new ProjectManagerGetOption(project);
	}

	private ProjectManagerGetOption(Project project) {
		this.project = project;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		if (text.equalsIgnoreCase(OPTIONS[0])) {// Change project visibility
			chat.askProjectVisibility(message.getMessageId());
			return ProjectManagerChangeVisibility.getState(project);
		} else if (text.equalsIgnoreCase(NO_PUBLIC_OPTIONS[0])) {// Manage project users
			String[] options = new String[] { USER_OPTIONS[0], USER_OPTIONS[1], USER_OPTIONS[2],
					ProjectManagerGetProject.EXIT };
			chat.sendMessageWithKeyboard("Select one:", message.getMessageId(), false, options);
			return this;
		} else if (text.equalsIgnoreCase(BRANCH_OPTIONS[0])) {// Change branch group
			chat.askProjectGroup(State.getFather(project), message.getMessageId());
			return ProjectManagerBranchGroup.getState(project);
		} else if (text.equalsIgnoreCase(WITH_BRANCH_OPTIONS[0])) {// Select a branch
			chat.sendMessage("Under construction", message.getMessageId(), false);
			return Chat.getDefaultState();
		} else if (text.equalsIgnoreCase(USER_OPTIONS[0])) {// Add an user to the project
			chat.askUser(message.getMessageId());
			return ProjectManagertUsers.getState(project, ProjectManagertUsers.ADD);
		} else if (text.equalsIgnoreCase(USER_OPTIONS[1])) {// Remove an user to the project
			usersProject(chat, message, project);
			return ProjectManagertUsers.getState(project, ProjectManagertUsers.REMOVE);
		} else if (text.equalsIgnoreCase(USER_OPTIONS[2])) {// Change an user access
			usersProject(chat, message, project);
			return ProjectManagertUsers.getState(project, ProjectManagertUsers.CHANGE);
		} else {
			return ProjectManager.exit(chat, message);

		}
	}

	private void usersProject(Chat chat, Message message, Project project) throws TelegramApiException {
		List<User> users = new ArrayList<>();
		if (project.getVisibility() == Visibility.PROTECTED) {
			users.addAll(project.getCanEdit());
		} else {
			users.addAll(project.getCanEdit());
			users.addAll(project.getCanRead());
		}

		String[] options = new String[users.size()];
		for (int i = 0; i < users.size(); i++) {
			options[i] = users.get(i).getReference();
		}
		chat.sendMessageWithKeyboard("Who?", message.getMessageId(), false, options);
	}

}
