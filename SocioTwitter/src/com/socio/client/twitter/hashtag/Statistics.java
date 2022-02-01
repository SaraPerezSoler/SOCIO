package com.socio.client.twitter.hashtag;



import java.io.File;

import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class Statistics implements HashTag {

	private static final Statistics STATISTICS = new Statistics();

	public static Statistics getState() {
		return STATISTICS;
	}


	private Statistics() {
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project p = getProject(message);
		if (p!= null) {
			run(twitter, message, p);
		}
		
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		
		User user = getUser(message.getUser(), twitter);
		File file = SOCIO.statisticsAllActions(project, user);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "All actions", project, file);
		file = SOCIO.statisticsAthorship(project, user);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "Authoship", project, file);
		file = SOCIO.statistics(project, user, true, true);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "User actions", project, file);
		file = SOCIO.statistics(project, user, true, false);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "User actions", project, file);
		file = SOCIO.statistics(project, user, false, true);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "User messages", project, file);
		file = SOCIO.statistics(project, user, false, false);
		twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "User messages", project, file);
	}

	@Override
	public String getHashtag() {
		return "statistics";
	}

	@Override
	public String getDescription() {
		return "get the project statistics";
	}

}
