package com.socio.client.telegram.states.impl.management;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Polling;
import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Subproject;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class ProjectManager8SelectBranchOption implements ConversationalState {

	private static final String[] SELECT_BRANCH_OPTIONS = ProjectManager7SelectBranchOption.SELECT_BRANCH_OPTIONS;

	private Project project;
	private String branchGroup;
	private String option = null;
	private List<User> users = new ArrayList<>();

	public static ProjectManager8SelectBranchOption getState(Project project, String branchGroup) {
		return new ProjectManager8SelectBranchOption(project, branchGroup);
	}

	private ProjectManager8SelectBranchOption(Project project, String branchGroup) {
		this.project = project;
		this.branchGroup = branchGroup;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {

		String text = message.getText();

		if (text.equalsIgnoreCase(SELECT_BRANCH_OPTIONS[0])) {// SELECT ONE OPTION
			option = SELECT_BRANCH_OPTIONS[0];
			askForBranch(chat, message);
			return this;
		} else if (text.equalsIgnoreCase(SELECT_BRANCH_OPTIONS[1])) {// VOTE
			option = SELECT_BRANCH_OPTIONS[1];
			askForUsers(chat, message);
			return this;
		} else {
			if (option != null) {
				if (option.equals(SELECT_BRANCH_OPTIONS[0])) {// Select one option
					Subproject selected = null;
					for (Subproject proj : project.getOpenBranchs().get(branchGroup)) {
						if (proj.getName().equalsIgnoreCase(text)) {
							selected = proj;
							break;
						}
					}
					if (selected == null) {
						chat.sendMessage(text + " is not a branch of " + project.getCompleteName(), false);
					} else {
						Project branch = SOCIO.project(selected.getName());
						File f = SOCIO.setChoice(project, State.getUser(message.getFrom()), branchGroup,
								branch.getAdmin().getChannel(), branch.getAdmin().getNick(), branch.getName(),
								getMessageId(message));
						project = SOCIO.project(project);
						chat.setProject(project, message.getMessageId());
						chat.sendMessage("Branch merged", false);
						chat.sendPhoto(f, -1);
						return Chat.getDefaultState();
					}
				} else {// vote
					if (!text.equals("end")) {
						users.add(getUser(text));
						askForUsers(chat, message);
						return this;
					} else {
						if (users.size()<2) {
							chat.sendMessage("There must be at least two users.", false);
							askForUsers(chat, message);
							return this;
						}
						File f = SOCIO.consensus(project, State.getUser(message.getFrom()), users, branchGroup,
								getMessageId(message));
						chat.sendPhoto(f);
						Polling poll = SOCIO.startPoll(project, State.getUser(message.getFrom()), branchGroup);
						
						chat.sendMessage("The "+ poll.getCardinalRound() +" round of the poll has begun. ", false);
						return Chat.getDefaultState();
					}
				}
			} // EXIT
			return ProjectManager1.exit(chat, message);
		}
	}

	private User getUser(String text) throws TelegramApiException {
		User ret;
		String[] split = text.split("/");
		if (split.length<2) {
			ret = new User(TelegramControl.getTelegramControl().getChannelName(), split[0]);
		}else {
			ret = new User(split[0], split[1]);
		}
		return ret;
	}

	private void askForBranch(Chat chat, Message message) throws TelegramApiException {
		List<Subproject> projects = project.getOpenBranchs().get(branchGroup);
		String[] projects_name = new String[projects.size()];
		for (int i = 0; i < projects.size(); i++) {
			projects_name[i] = projects.get(i).getName();
		}
		chat.sendMessageWithKeyboard("Which option?", message.getMessageId(), false, projects_name);
	}

	private void askForUsers(Chat chat, Message message) throws TelegramApiException {
		chat.sendMessageWithKeyboard("Who? (<channel>/<userNick>):", message.getMessageId(), false,
				new String[] { "end" });
	}
	

}
