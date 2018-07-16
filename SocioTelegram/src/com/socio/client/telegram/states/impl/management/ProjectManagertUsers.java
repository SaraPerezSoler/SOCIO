package com.socio.client.telegram.states.impl.management;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManagertUsers implements ConversationalState {
	public static final int REMOVE = 0;
	public static final int CHANGE = 1;
	public static final int ADD = 2;

	private static final String REMOVE_MSG = " has been removed";
	private static final String ADD_MSG = " has been added";
	private static final String CHANGE_MSG = " has been changed";

	private static final String[] ADD_OPTIONS = { "Read", "Write" };
	private Project project;
	private int managementUserAction;
	private User userToSearch = null;
	private Boolean edit = null;

	public static ProjectManagertUsers getState(Project project, int action) {
		return new ProjectManagertUsers(project, action);
	}

	private ProjectManagertUsers(Project project, int action) {
		this.project = project;
		this.managementUserAction = action;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		String text = message.getText();
		boolean flag = false;
		if (userToSearch == null) {
			flag = true;
			userToSearch = State.textToUser(text);
		}

		Project p;
		String msg = "The user " + userToSearch.getReference();
		if (this.managementUserAction == REMOVE) {
			p = SOCIO.removeUserFromProject(project, State.getUser(message.getFrom()), userToSearch);
			msg += REMOVE_MSG;
		} else if (this.managementUserAction == CHANGE) {
			p = SOCIO.updateUserInProject(project, State.getUser(message.getFrom()), userToSearch);
			msg += CHANGE_MSG;
		} else {
			if (flag) {
				 if (project.getVisibility() == Visibility.PROTECTED) {
					edit = true;
				} else {
					chat.sendMessageWithKeyboard("With what privileges?", message.getMessageId(), false, ADD_OPTIONS);
					return this;
				}

			} else {
				if (text.equalsIgnoreCase(ADD_OPTIONS[0])) {// Read
					edit = false;
				} else {// Write
					edit = true;
				}
			}
			p = SOCIO.addUserToProject(project, State.getUser(message.getFrom()), userToSearch, edit);
			msg += ADD_MSG;
		}
		TelegramControl.projects.put(p.getCompleteName(), p);
		chat.sendMessage(msg + State.printProjectAllInfo(p), message.getMessageId(), true);

		return Chat.getDefaultState();
	}

}
