package com.socio.client.twitter.hashtag;


import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.TwitterException;

public class NewProject implements HashTag {
	private static NewProject NEW_PROJECT = new NewProject();

	public static NewProject getState() {
		return NEW_PROJECT;
	}

	private NewProject() {
	}

	@Override
	public String getHashtag() {
		return "newproject";
	}

	@Override
	public String getDescription() {
		return "create and set a new project";
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		String project = null;
		HashtagEntity[] hashtags = message.getHashtagEntities();
		for (HashtagEntity hashtag : hashtags) {
			if (!hashtag.getText().equalsIgnoreCase(getHashtag())) {
				project = hashtag.getText();
				break;
			}
		}
		Visibility v = Visibility.PUBLIC;

		String text = cleanText(message.getText());
		String[] split = text.split(" ");
		
		for (String s : split) {
			if (Visibility.isVisibility(s)) {
				v = Visibility.valueOf(s.toUpperCase());
				text = text.replace(s, "");
				break;
			}
		}
		
		if (project == null) {
			project = text;
		}

		if (project != null && !project.isEmpty()) {
			Project p = SOCIO.newProject(project, user, v);
			twitter.sendMessage(message.getId(), message.getUser().getScreenName(), "", p, null);
			return;
		}

		throw new ForbiddenResponse(
				"The project hasn't been created. To create a new project you must send me: #newproject <public, private or protected> <project_name>");

	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		run(twitter, message);
	}

}
