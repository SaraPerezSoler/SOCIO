package com.socio.client.twitter.hashtag;


import java.util.ArrayList;
import java.util.List;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Projects implements HashTag {
	private static Projects PROJECTS = new Projects();

	public static Projects getState() {
		return PROJECTS;
	}

	private Projects() {
	}

	@Override
	public String getHashtag() {
		return "projects";
	}

	@Override
	public String getDescription() {
		return "show a list of projects";
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		List<Project> projects = new ArrayList<>();
		projects.addAll(SOCIO.projects(user, false));
		projects.addAll(SOCIO.projects(user, true));
		projects.addAll(SOCIO.projects(user));
		for (Project project : projects) {
			twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", project, null);
		}
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		run(twitter, message);
		
	}
}
