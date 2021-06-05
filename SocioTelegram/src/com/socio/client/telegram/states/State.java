package com.socio.client.telegram.states;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.beans.Project.Subproject;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.command.SocioCommands;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.TelegramControl;


public interface State {
	
	public State runAndNext(Chat chat, Message message)throws TelegramApiException, ResponseError, ForbiddenResponse;
	
	static final String DEFAULT = "default";
	public static Project getFather(Project project) throws ResponseError, ForbiddenResponse {
		if (project.isBranch()) {
			Project p = SOCIO().project(project.getFather().getName());
			TelegramControl.projects.put(p.getCompleteName(), p);
			return p;
		}
		return null;
	}
	
	public static SocioCommands SOCIO() {
		return TelegramControl.getTelegramControl().getSOCIO();
		
	}
	public static String printProjects(List<Project> projects) {
		String cad = "";
		for (Project p : projects) {
			cad += "*>*" + printProject(p) + "\n";
		}
		return cad;
	}

	public static String printProject(Project project) {
		String cad = "*" + project.getCompleteName() + "*\n" + "\t" + Chat.FORMATTER.format(project.getCreateDate()) + ", "
				+ project.getType()+", " + project.getVisibility() + ", " + project.getOpenStatus() + "\n";
		if (project.isBranch()) {
			cad += "\t Branch of _" + project.getFather().getName() + "_\n";
			cad += "\t Branch group: " + project.getBranchGroup() + "\n";
		} else {
			Map<String, List<Subproject>> openBranchs = project.getOpenBranchs();
			if (!openBranchs.isEmpty()) {
				cad += "\t Open branchs: \n";
				for (String key : openBranchs.keySet()) {
					cad += "\t\t -" + key + "\n";
					for (Subproject branch : openBranchs.get(key)) {
						cad += "\t\t\t + _" + branch.getName() + "_\n";
					}
				}
			}
			if (!project.getCloseBranchs().isEmpty()) {
				cad += "\t Close branchs: \n";
				for (String branchs : project.getCloseBranchs()) {
					cad += "\t\t -" + branchs.replace("\n", "\n\t\t\t") + "\n";
				}
			}
		}
		return cad;
	}

	public static String printProjectAllInfo(Project project) {
		String cad = printProject(project);
		if (project.getVisibility() == Visibility.PUBLIC) {
			return cad;
		}
		cad += "\tUsers can edit:" + "\n";
		for (User u : project.getCanEdit()) {
			cad += "\t\t· " + u.getReference()+"\n";
		}
		if (project.getVisibility() == Visibility.PROTECTED) {
			return cad;
		}
		cad += "\tUsers can read:" + "\n";
		for (User u : project.getCanRead()) {
			cad += "\t\t· " + u.getReference()+"\n";
		}
		return cad;
	}
	public static boolean hasFirstCommand(String text) {
		if (text.startsWith("/")) {
			return true;
		}
		return false;
	}
	
	public static String removeFirstCommand(String text) {
		if (text.startsWith("/")) {
			String command = "";
			if (text.contains(" ")) {
				command = text.substring(0, text.indexOf(" "));
				return text.replace(command, "");
			} else {
				return "";
			}
		}
		return text;
	}

	public static String getFirstCommand(String text) {

		if (text.startsWith("/")) {
			String ret = text.replace("/", "");
			if (ret.contains(" ")) {
				ret = ret.substring(0, ret.indexOf(" "));
			}
			if (ret.contains("@")) {
				ret = ret.substring(0, ret.indexOf("@"));
			}
			return ret;
		}
		return "";

	}
	public static User textToUser(String text) throws TelegramApiException {
		String[] split = text.split("/");
		User userToSearch;
		if (split.length == 1) {
			userToSearch = new User(TelegramControl.getTelegramControl().getChannelName(), split[0]);
		} else {
			userToSearch = new User(split[0], split[1]);
		}
		return userToSearch;
	}
	
	public static User getUser(org.telegram.telegrambots.api.objects.User from) throws TelegramApiException {
		User user = new User(TelegramControl.getTelegramControl().getChannelName(), from.getUserName(),
				from.getFirstName(), from.getId());
		return user;
	}
	
	public static String projectGroup(Map<String, List<Subproject>> openGroups) {
		String cad = "";
		Set<String> keys = openGroups.keySet();
		for (String key : keys) {
			cad += "\n*- " + key + ":*\n";
			for (Subproject project : openGroups.get(key)) {
				cad += "_\t " + project.getName() + "_\n";
			}
		}
		String msg = cad
				+ "\n\nSelect a existing branch group or write a new branch group:";
		return msg;
	}

	public static String[] projectGroupOptions(Map<String, List<Subproject>> openGroups) {
		List<String> keys = new ArrayList<>(openGroups.keySet());
		if (!keys.contains(DEFAULT)) {
			keys.add(DEFAULT);
		}
		String[] options = new String[keys.size()];
		options = keys.toArray(options);

		return options;
	}
	
	public default String getMessageId(Message message) {
		return message.getChatId() + "/" + message.getMessageId();
	}
	
	public static long getChatId(String messageId) {
		return Long.parseLong(messageId.split("/")[0]);
	}
	
	public static int getMsgId(String messageId) {
		return Integer.parseInt(messageId.split("/")[1]);
	}

	
}
