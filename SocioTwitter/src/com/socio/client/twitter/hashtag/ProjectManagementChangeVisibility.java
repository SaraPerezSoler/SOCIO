package com.socio.client.twitter.hashtag;


import com.socio.client.beans.Project;
import com.socio.client.beans.Project.Visibility;
import com.socio.client.beans.User;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.twitter.HashTag;
import com.socio.client.twitter.TwitterControl;

import twitter4j.Status;
import twitter4j.TwitterException;

public class ProjectManagementChangeVisibility implements HashTag {

	private static ProjectManagementChangeVisibility PROJECT_MANAGEMENT = new ProjectManagementChangeVisibility();
	public static ProjectManagementChangeVisibility getState() {
		return PROJECT_MANAGEMENT;
	}

	private ProjectManagementChangeVisibility() {
	}

	@Override
	public void run(TwitterControl twitter, Status message) throws TwitterException, ResponseError, ForbiddenResponse {
		Project p = getProject(message);
		if (p != null) {
			run(twitter, message, p);
		}
	}

	@Override
	public void run(TwitterControl twitter, Status message, Project project)
			throws TwitterException, ResponseError, ForbiddenResponse {
		User user = getUser(message.getUser(), twitter);
		Visibility v = null;
		String text = cleanText(message.getText());
		String[] split = text.split(" ");

		for (String s : split) {
			if (Visibility.isVisibility(s)) {
				v = Visibility.valueOf(s.toUpperCase());
				text = text.replace(s, "");
				break;
			}
		}
		if (v != null) {
			project = SOCIO.changeVisibility(project, user, v);
		}
		throw new ForbiddenResponse(
				"The project hasn't been changed. To change the project visibility you must send me: #" + getHashtag()
						+ " <public, private or protected> <project_name>  or reply one of my tweets that contains the project name with: #"
						+ getHashtag() + " <public, private or protected>. ");
	}

	@Override
	public String getHashtag() {
		return "setvisibility";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
