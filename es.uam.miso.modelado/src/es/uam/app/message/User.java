package es.uam.app.message;

import java.util.List;

public class User {
	private String name;
	private long id;
	private String nick;
	private String channel;
	
	
	public User(String name, long id, String nick, String channel) {
		super();
		this.name = name;
		this.id = id;
		this.nick = nick;
		this.channel=channel;
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

	public boolean same(long id) {
		if (this.id==id){
			return true;
		}
		return false;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public static User find(List<User> users, long id){
		for (User u:users){
			if (u.same(id)){
				return u;
			}
		}
		return null;
	}


	public String getUML() {
		String cad="{[<&person> "+this.name+"]\n";
		cad+=this.nick+"}";
		return cad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (id != other.id)
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", nick=" + nick + ", channel=" + channel + "]";
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}
	

}
