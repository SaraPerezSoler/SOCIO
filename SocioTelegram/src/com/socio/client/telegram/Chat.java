package com.socio.client.telegram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.states.State;
import com.socio.client.telegram.states.impl.TalkConversation;
import com.socio.client.telegram.states.impl.management.EndVote;
import com.socio.client.telegram.states.impl.management.EndVoteAdmin;
import com.socio.client.telegram.states.impl.management.Vote;

public class Chat {

	public static final int READ_LEVEL = 0;
	public static final int EDIT_LEVEL = 1;
	public static final int OWNER_LEVEL = 2;

	private static final State DEFAULT_STATE = TalkConversation.getState();
	private static final String USER_QUESTION = "Who? (channel/nick)";
	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");

	private long id;
	private State state;
	private Project project = null;

	public Chat(long id) {
		super();
		this.id = id;
		this.state = DEFAULT_STATE;
	}

	public void onReciveMessage(org.telegram.telegrambots.api.objects.Message update) throws TelegramApiException {
		if (update.hasText()) {
			String text = update.getText();
			if (State.hasFirstCommand(text)) {
				State command = TelegramControl.commandState.get(State.getFirstCommand(text));
				if (command == null) {
					sendMessage("I don't understand this command", update.getMessageId(), false);
					this.state = DEFAULT_STATE;
				} else {
					exeState(command, update);
				}
			} else {
				exeState(this.state, update);
			}

		} else {
			sendMessage("Sorry, but I only understand text", update.getMessageId(), false);
			this.state = DEFAULT_STATE;
		}
	}

	private void exeState(State state, org.telegram.telegrambots.api.objects.Message update)
			throws TelegramApiException {
		try {
			this.state = state.runAndNext(this, update);
		} catch (TelegramApiException | ResponseError e) {
			sendMessage("Unexpected internal error has ocurrred", false);
			this.state = DEFAULT_STATE;
		} catch (ForbiddenResponse e) {
			sendMessage("This action has not been completed: " + e.getMessage(), false);
			this.state = DEFAULT_STATE;
		}
	}
	public void onEndPolling (EndConsensus cons) throws TelegramApiException{
		exeState(EndVote.getState(cons), null);
	}
	
	public void onEndPollingAdmin (EndConsensus cons) throws TelegramApiException{
		exeState(EndVoteAdmin.getState(cons), null);
	}
	public void onStartPolling (Project project, String branchGroup, Map<String, File> branchs) throws TelegramApiException {
		exeState(Vote.getState(project, branchGroup, branchs), null);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project, int inReply) throws TelegramApiException {
		TelegramControl.projects.put(project.getCompleteName(), project);
		sendMessage(State.printProjectAllInfo(project), inReply, true);
		this.project = project;
	}

	public void updateProject(Project project) {
		if (this.project == null || project == null) {
			return;
		}
		if (project.getId() != this.project.getId()) {
			return;
		}
		this.project = project;
	}

	public boolean hasProject() {
		if (project != null) {
			return true;
		}
		return false;
	}

	public long getId() {
		return id;
	}

	public void sendMessage(String message, boolean markDown) throws TelegramApiException {
		sendMessage(message, -1, markDown);
	}

	public void sendMessage(String message, int inReply, boolean markDown) throws TelegramApiException {
		ReplyKeyboardRemove replyremove = new ReplyKeyboardRemove();
		replyremove.setSelective(true);
		sendMessage(message, inReply, markDown, replyremove);

	}

	public void sendMessageAndForceReply(String message, int inReply, boolean markDown) throws TelegramApiException {
		ForceReplyKeyboard replyK = new ForceReplyKeyboard();
		replyK.setSelective(true);
		sendMessage(message, inReply, markDown, replyK);

	}

	public void askUser(int inReply) throws TelegramApiException {
		sendMessageAndForceReply(USER_QUESTION, inReply, false);
	}

	public void askProjectVisibility(int inReply) throws TelegramApiException {
		sendMessageWithKeyboard("Select the project visibility", inReply, false,
				new String[] { "Public", "Protected", "Private" });
	}

	public void askProject(int inReply, int level, User user)
			throws ResponseError, ForbiddenResponse, TelegramApiException {
		List<Project> projects = new ArrayList<>();
		if (level <= READ_LEVEL) {
			projects.addAll(State.SOCIO.projects(user, false));
		}
		if (level <= EDIT_LEVEL) {
			projects.addAll(State.SOCIO.projects(user, true));

		}
		projects.addAll(State.SOCIO.projects(user));
		String[] projOptions = new String[projects.size()];
		for (int i = 0; i < projects.size(); i++) {
			projOptions[i] = projects.get(i).getCompleteName();
			TelegramControl.projects.put(projOptions[i], projects.get(i));
		}
		sendMessageWithKeyboard(State.printProjects(projects) + "\n\nWhich project?", inReply, true, projOptions);
	}

	public void sendMessageWithKeyboard(String message, int inReply, boolean markdown, String[] options)
			throws TelegramApiException {
		List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
		if (options.length <= 4) {
			for (String option : options) {
				KeyboardRow row = new KeyboardRow();
				KeyboardButton button = new KeyboardButton();
				button.setText(option);
				row.add(button);
				rows.add(row);
			}
		} else {
			int cols = 2;
			int i = 0;
			KeyboardRow row = null;
			for (String option : options) {
				if (i % cols == 0) {
					if (row != null) {
						rows.add(row);
					}
					row = new KeyboardRow();
				}

				KeyboardButton button = new KeyboardButton();
				button.setText(option);
				row.add(button);
				i++;
			}
			rows.add(row);
		}
		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		keyboardMarkup.setOneTimeKeyboard(true);
		keyboardMarkup.setResizeKeyboard(true);
		keyboardMarkup.setKeyboard(rows);
		sendMessage(message, inReply, markdown, keyboardMarkup);
	}

	public void sendMessage(String message, int inReply, boolean markDown, ReplyKeyboard keyboard)
			throws TelegramApiException {
		SendMessage msg = new SendMessage(this.id, message);
		msg.setReplyMarkup(keyboard);
		if (inReply != -1) {
			msg.setReplyToMessageId(inReply);
		}
		if (markDown) {
			msg.setParseMode("Markdown");
		}
		TelegramControl.getTelegramControl().sendMessage(msg);
	}

	public void sendPhoto(File message) throws TelegramApiException {
		sendPhoto(message, -1);
	}

	public void sendPhoto(File message, int inReply) throws TelegramApiException {
		ReplyKeyboardRemove replyremove = new ReplyKeyboardRemove();
		replyremove.setSelective(true);
		SendPhoto msg = new SendPhoto();
		msg.setChatId(this.id);
		msg.setNewPhoto(message);
		msg.setReplyMarkup(replyremove);
		if (inReply != -1) {
			msg.setReplyToMessageId(inReply);
		}
		TelegramControl.getTelegramControl().sendPhoto(msg);
	}

	public void sendDocument(File message) throws TelegramApiException {
		sendDocument(message, -1);
	}

	public void sendDocument(File message, int inReply) throws TelegramApiException {
		ReplyKeyboardRemove replyremove = new ReplyKeyboardRemove();
		replyremove.setSelective(true);
		SendDocument msg = new SendDocument();
		msg.setChatId(this.id);
		msg.setNewDocument(message);
		msg.setReplyMarkup(replyremove);
		if (inReply != -1) {
			msg.setReplyToMessageId(inReply);
		}
		TelegramControl.getTelegramControl().sendDocument(msg);
	}

	public static State getDefaultState() {
		return DEFAULT_STATE;
	}

	public void sendHistory(List<Message> messages, int inReply) throws TelegramApiException {
		String text = Message.getHistoryFormat(messages);
		

		if (text.length() > 1500) {
			File f = new File("history.txt");
			FileWriter fichero =null;
			PrintWriter pw = null;
			try {
				
				fichero = new FileWriter(f);
				pw = new PrintWriter(fichero);
				pw.println(text);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != fichero)
						fichero.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			sendDocument(f, inReply);
		} else {
			sendMessage(text, inReply, false);
		}

	}

	public void askProjectGroup(Project project, int inReply) throws TelegramApiException {
		String msg = State.projectGroup(project.getOpenBranchs());
		String[] options = State.projectGroupOptions(project.getOpenBranchs());
		sendMessageWithKeyboard(msg, inReply, true, options);
	}

}
