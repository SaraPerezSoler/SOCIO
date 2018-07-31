package com.socio.client.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Message{

	private User user;
	private String msg;
	private String text;
	private long date;
	private String id;
	private List<String> actions = new ArrayList<>();

	public static Message createMessage(JSONObject object) {
		if (object.isNull("user") || object.isNull("date") || object.isNull("msg") || object.isNull("actions")) {
			return null;
		}
		Message msg = new Message();
		msg.setUser(User.createUser(object.getJSONObject("user")));
		msg.setDate(object.getLong("date"));
		msg.setMsg(object.getString("msg"));
		JSONArray actionsJSON = object.getJSONArray("actions");
		List<String> actions = new ArrayList<>();
		for (int i = 0; i < actionsJSON.length(); i++) {
			actions.add(actionsJSON.getString(i));
		}
		msg.setActions(actions);
		if (!object.isNull("text")) {
			msg.setText(object.getString("text"));
		}
		if (!object.isNull("id")) {
			msg.setId(object.getString("id"));
		}

		return msg;
	}

	public Message() {
		super();
	}

	public Message(User user, String msg, String text, Date date, String id) {
		super();
		this.user = user;
		this.msg = msg;
		this.text = text;
		this.date = date.getTime();
		this.id = id;
	}

	public Message(User user, String msg, String text, long date, String id) {
		super();
		this.user = user;
		this.msg = msg;
		this.text = text;
		this.date = date;
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateDate() {
		return new Date(date);
	}

	public void setDateDate(Date date) {
		this.date = date.getTime();
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message [user=" + user + ", msg=" + msg + ", text=" + text + ", date=" + getDateDate() + ", id=" + id
				+ ", actions=" + actions + "]";
	}

	public String getHistoryFormat() {
		String actions = "";
		for (String act : getActions()) {
			actions += "\t · " + act + "\n";
		}
		return "User: " + getUser().getNick() + " at " + FORMATTER1.format(getDate()) + " in " + getUser().getChannel()
				+ "\n" + "Sends: " + getMsg() + "\n" + "The message caused these actions:\n" + actions
				+ "------------------------\n";
	}

	public static final SimpleDateFormat FORMATTER1 = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

	public static String getHistoryFormat(List<Message> messages) {
		String text = "";
		for (Message msg : messages) {
			text += msg.getHistoryFormat();
			
		}
		return text;
	}
}
