package com.socio.client.twitter.hashtag;

import java.io.File;
import java.util.Date;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Talk implements HashTag {

	private static Talk TALK = null;

	public static Talk getState() {
		if (TALK == null) {
			TALK = new Talk();
		}
		return TALK;
	}

	private Talk() {
	}

	@Override
	public String getHashtag() {
		return "talk";
	}

	@Override
	public String getDescription() {
		return "start a conversation with the bot";
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project project = getProject(message);
		if (project != null) {
			run(twitter, message, project);
			return;
		}
		throw new ForbiddenResponse(
				"The action hasn't been did. To modify a model you must send: #<project_name> <sentences>, or reply one of my tweets that contains the project name with: <sentence>");

	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		String text = cleanText(message.getText());
		File f = SOCIO.edit(project, user, message.getText(), text, new Date(),
				Long.toString(message.getId()));
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", project, f);
	}

}
