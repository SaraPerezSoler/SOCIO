package com.socio.client.twitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStreamAdapter;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Message;
import com.socio.client.beans.Polling;
import com.socio.client.beans.Project;
import com.socio.client.command.Channel;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public class TwitterControl extends UserStreamAdapter {

	public static final String TEST = "Test";
	public static final String MISO_TEST = "MisoTest";
	public static final String SOCIO = "SOCIO";

	private static final String NICK = "Nick";
	private static final String CONSUMER_KEY = "Consumer_Key";
	private static final String CONSUMER_SECRET = "Consumer_Secret";
	private static final String ACCESS_TOKEN = "Access_Token";
	private static final String ACCESS_TOKEN_SECRET = "Access_Token_Secret";

	private static final String PASS = "pass.json";

	public static Map<String, HashTag> hashtagCommand = new HashMap<>();
	private Twitter twitter;
	private TwitterStream twitterStream;
	private TwitterChannel channel = new TwitterChannel();
	private Map<String, ProjectRef> projects = new HashMap<>();
	private String name;
	
	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yy");
	
	
	private static TwitterControl TC = null;
	
	public static TwitterControl getTwitterControl(String debug) throws TwitterException {
		if (TC == null) {
			TC = new TwitterControl(debug);
		}
		return TC;
	}
	
	public static TwitterControl getTwitterControl() throws TwitterException {
		if (TC == null) {
			TC = new TwitterControl(SOCIO);
		}
		return TC;
	}
	
	private TwitterControl(String debug) throws TwitterException {

		if (!debug.equals(TEST) && !debug.equals(MISO_TEST) && !debug.equals(SOCIO)) {
			debug = SOCIO;
		}
		String text = readPass();
		JSONObject object = new JSONObject(text);
		if (!object.has(debug)) {
			throw new TwitterException("Impossible to read the bot tokens: Bot Name");
		}
		JSONObject bot = object.getJSONObject(debug);
		if (!bot.has(NICK) || !bot.has(CONSUMER_KEY) || !bot.has(CONSUMER_SECRET) || !bot.has(ACCESS_TOKEN)
				|| !bot.has(ACCESS_TOKEN_SECRET)) {
			throw new TwitterException("Impossible to read the bot tokens: Bot info");
		}
		this.setName(bot.getString(NICK));
		String key = bot.getString(CONSUMER_KEY);
		String secret = bot.getString(CONSUMER_SECRET);
		String token = bot.getString(ACCESS_TOKEN);
		String token_secret = bot.getString(ACCESS_TOKEN_SECRET);
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true).setOAuthConsumerKey(key).setOAuthConsumerSecret(secret)
				.setOAuthAccessToken(token).setOAuthAccessTokenSecret(token_secret);
		Configuration conf = cb.build();
		
		try {

			TwitterFactory tf = new TwitterFactory(conf);
			twitter = tf.getInstance();
			twitter.verifyCredentials();

			TwitterStreamFactory tsf = new TwitterStreamFactory(conf);
			twitterStream = tsf.getInstance();
			twitterStream.addListener(this);
			twitterStream.user(Long.toString(twitter.getId()));

		} catch (TwitterException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	private String readPass() {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String text = "";
		try {
			file = new File(PASS);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// Lectura del fichero

			String line;
			while ((line = br.readLine()) != null)
				text += "\n" + line;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return text;
	}

	/*
	 * public void sendMessage(String msg, File file) throws TwitterException {
	 * sendMessage(-1, "", msg, file); }
	 */

	public void sendMessage(long id, String screenName, String msg, Project project, File file)
			throws TwitterException {

		StatusUpdate status;
		String text = msg;
		if (project != null) {
			addProject(project);
			text = printProject(project) + msg;
		}

		if (id != -1) {

			text = "@" + screenName + " " + text;
			if (text.length() > 280) {
				text = text.substring(0, 275) + "...";
			}
			status = new StatusUpdate(text);
			status.setInReplyToStatusId(id);
		} else {
			if (text.length() > 280) {
				text = text.substring(0, 275) + "...";
			}
			status = new StatusUpdate(text);
		}

		if (file != null) {
			status.setMedia(file);
		}
		twitter.updateStatus(status);

	}

	public void onStatus(Status status) {
		ProjectRef ref = null;
		try {
			if (status.getUser().getId() != twitter.getId()) {
				ref = getInReplyProject(status);
				HashtagEntity[] hashtags = status.getHashtagEntities();
				HashTag actual = null;
				for (HashtagEntity hashtag : hashtags) {
					actual = hashtagCommand.get(hashtag.getText().toLowerCase());
					if (actual != null) {
						break;
					}
				}
				if (actual == null) {
					actual = hashtagCommand.get("talk");
				}
				if (ref != null) {
					actual.run(this, status, ref.getProject());
				} else {
					actual.run(this, status);
				}

			}
		} catch (ResponseError | ForbiddenResponse e) {
			try {
				if (ref != null) {
					this.sendMessage(status.getId(), status.getUser().getScreenName(), e.getMessage(), ref.getProject(),
							null);
				} else {
					this.sendMessage(status.getId(), status.getUser().getScreenName(), e.getMessage(), null, null);
				}
			} catch (TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IllegalStateException | TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
	}

	private ProjectRef getInReplyProject(Status status) throws TwitterException, ResponseError, ForbiddenResponse {
		if (status.getInReplyToStatusId() != -1) {
			Status inReply = twitter.showStatus(status.getInReplyToStatusId());
			if (inReply != null) {
				String name = inReply.getInReplyToScreenName();
				String text = inReply.getText().replace("@" + name + " ", "");
				String projectName = text.split("\n")[0];
				ProjectRef ref = this.projects.get(projectName);
				if (ref == null) {
					try {
						Project proj = HashTag.SOCIO.project(projectName);
						ref = new ProjectRef(proj);
						projects.put(proj.getCompleteName(), ref);
					} catch (Exception e) {
						return null;
					}
				}
				return ref;
			}
		}
		return null;
	}

	public String getChannelName() {
		return channel.getChannelName();
	}

	public static void regiterCommandHashtag(Class<? extends HashTag> tHashtag) {
		try {
			Method meth = tHashtag.getMethod("getState");
			HashTag state = (HashTag) meth.invoke(null);
			hashtagCommand.put(state.getHashtag().toLowerCase(), state);
		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("I cant register the command " + tHashtag.getName() + "\n" + e.getMessage());
		}
	}

	public void addProject(Project project) {
		ProjectRef ref = projects.get(project.getCompleteName());
		if (ref == null) {
			ref = new ProjectRef(project);
			projects.put(project.getCompleteName(), ref);
		} else {
			ref.setProject(project);
		}
	}

	public static String printProject(Project project) {
		String cad = "" + project.getCompleteName() + "\n" + "\t" + FORMATTER.format(project.getCreateDate()) + ", "
				+ project.getType() + ", " + project.getVisibility() + ", " + project.getOpenStatus() + "\n";
		if (project.isBranch()) {
			cad += "\t Branch of " + project.getFather().getName() + "\n";
			cad += "\t Branch group: " + project.getBranchGroup() + "\n";
		}
		return cad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private class TwitterChannel extends Channel {

		public TwitterChannel() {
			super();
		}

		@Override
		public String getChannelName() {
			return "twitter";
		}

		@Override
		public void onUpdate(Project p, List<Message> msgs, File f) {
			try {
				if (!msgs.get(msgs.size() - 1).getUser().getChannel().equals(getChannelName())) {
					String text = "";
					for (Message msg : msgs) {
						text += "\t - " + msg.getUser().getReference() + ": " + msg.getText() + "\n";
					}
					sendMessage(-1, null, text, p, f);
				}
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		public void onPolling(Polling polling) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onEndConsensus(EndConsensus cons) {
			// TODO Auto-generated method stub
			
		}

	}

}
