package com.socio.client.beans;

import org.json.JSONObject;

public class User{

	private String channel;
	private String nick;
	private String name;
	private long id;
	
	public static User createUser(JSONObject object) {
		String channel="";
		if (!object.isNull("channel")) {
			channel=object.getString("channel");
		}
		String nick="";
		if (!object.isNull("nick")) {
			nick=object.getString("nick");
		}
		String name="";
		if (!object.isNull("name")) {
			name=object.getString("name");
		}
		long id=-1;
		if (!object.isNull("id")) {
			id=object.getLong("id");
		}
		return new User(channel, nick, name, id);
	}
	
	public User() {
		super();
	}
	public User(String channel, String nick, String name, long id) {
		super();
		this.channel = channel;
		this.nick = nick;
		this.name = name;
		this.id = id;
	}
	
	public User(String channel, String nick) {
		super();
		this.channel = channel;
		this.nick = nick;
		this.name = "";
		this.id = -1;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getReference() {
		return getChannel()+"/"+getNick();
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [channel=" + channel + ", nick=" + nick + ", name=" + name + ", id=" + id + "]";
	}
}
