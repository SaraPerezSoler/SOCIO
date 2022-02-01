package com.socio.client.twitter.hashtag;


import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class DelProject implements HashTag {
	private static DelProject DEL_PROJECT = new DelProject();
	private static final String messageError = "The project hasn't been deleted. To delete a project you must send me: #delproject <project_name>, or reply one of my tweets that contains the project name with: #delproject.";

	public static DelProject getState() {
		return DEL_PROJECT;
	}

	private DelProject() {
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project project = getProject(message);
		if (project != null) {
			run(twitter, message, project);
		}
		throw new ForbiddenResponse(messageError);
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		if (project != null) {
			String s = SOCIO.removeProject(project, user);
			twitter.sendMessage(message.getId(), message.getUser().getScreenName(), s, project, null);
			return;
		}
		throw new ForbiddenResponse(messageError);
	}

	@Override
	public String getDescription() {
		return "delete a project";
	}

	@Override
	public String getHashtag() {
		return "delproject";
	}

}
