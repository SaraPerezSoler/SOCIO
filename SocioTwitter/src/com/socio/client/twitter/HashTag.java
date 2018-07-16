package com.socio.client.twitter;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.SaveFileServer;
import com.socio.client.command.SocioCommands;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

import twitter4j.Status;
import twitter4j.TwitterException;

public interface HashTag {
	public static final SocioCommands SOCIO= SocioCommands.getSOCIO();
	
	
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse;
	public void run(TwitterControl twitter, Status message, Project project) throws TwitterException, ResponseError, ForbiddenResponse;
	public String getHashtag();
	public String getDescription();
	
	public default String cleanText(String text) {
		String text2 = text.replace("#"+this.getHashtag(), "");
		text2 = text2.replace("@"+TwitterControl.name, "");
		text2 = text2.replace("  ", " ");
		return text2;
	}
	
	public default Project getProject(Status message) throws ResponseError, ForbiddenResponse {
		String p = getProjecName(message);
		/*if (p == null || p.isEmpty()) {
			p = cleanText(message.getText());
		}*/
		Project project = SOCIO.project(p);
		return project;
	}
	public default String getProjecName(Status message) {
		String text = message.getText();
		String p = text.substring(text.indexOf("/"));
		if (p.contains(" ")) {
			p = p.substring(0, p.indexOf(" "));
		}
		return p.substring(1);
	}
	public default User getUser(twitter4j.User user, TwitterControl twitter) {
		User u = new User(twitter.getChannelName(), user.getScreenName(), user.getName(), user.getId());
		return u;
	}
	
	public default void sendHistory (List<Message> messages, TwitterControl twitter, Status message, Project project) throws TwitterException {
		String text = Message.getHistoryFormat(messages);
		File dir =  new File("tmp");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File f = new File("tmp/"+project.getName()+"History.txt");
		
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
		sendFile(f, twitter, message, project);
	}
	
	public static final SaveFileServer server = new SaveFileServer();
	
	public default void sendFile(File file, TwitterControl twitter, Status message, Project project) throws TwitterException {
		String text = cleanText(message.getText()).replace("/" + project.getCompleteName(), "");
		String number = extractNumber(text);
		long duration = -1;
		TimeUnit unit = null;
		if (number != null && !number.isEmpty()) {
			try {
				duration = Long.parseLong(number);
				if (isMinutes(text)) {
					System.out.println("minutes");
					unit = TimeUnit.MINUTES;
				} else if (isHour(text)) {
					System.out.println("hours");
					unit = TimeUnit.HOURS;
				} else if (isDay(text)) {
					System.out.println("day");
					unit = TimeUnit.DAYS;
				}
			} catch (NumberFormatException e) {

			}
		}
		String url;
		if (unit == null) {
			url = server.saveFile(file);
		} else {
			url = server.saveFile(file, duration, unit);
		}
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "You can retrieve the file in: \n" + url,
				project, null);
	}
	
	public default String extractNumber(final String str) {

		if (str == null || str.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
				found = true;
			} else if (found) {
				// If we already found a digit before and this char is not a digit, stop looping
				break;
			}
		}
		return sb.toString();
	}

	public default boolean isMinutes(String text) {
		String regex = ".*\\d+\\s*(?i)(((m|min)(\\s|$))|minute).*";
		return Pattern.matches(regex, text);
	}

	public default boolean isHour(String text) {
		String regex = ".*\\d+\\s*(?i)(h(\\s|$)|hour).*";
		return Pattern.matches(regex, text);
	}

	public default boolean isDay(String text) {
		String regex = ".*\\d+\\s*(?i)(d(\\s|$)|day).*";
		return Pattern.matches(regex, text);
	}

	
	
}
