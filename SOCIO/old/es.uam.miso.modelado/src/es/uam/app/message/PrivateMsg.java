package es.uam.app.message;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import socioProjects.User;

public class PrivateMsg extends SendMessageExc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<User, String> msgs= new HashMap<User, String>();

	public PrivateMsg(String message) {
		super(message);
	}

	public PrivateMsg(String message, File png) {
		super(message, png);
	}

	public PrivateMsg(File png) {
		super(png);
	}
/*	public void addUser(User u){
		msgs.put(u, "");
	}*/
	public void addUser(User u, String msg){
		msgs.put(u, msg);
	}
	public void setUsers(Map<User, String> msgs) {
		this.msgs=msgs;
	}

	public List<User> getUsers() {
		List<User> ret= new ArrayList<User>();
		ret.addAll(msgs.keySet());
		return ret;
	}
	
	public String getUserMsg(User u){
		return getMessage()+"\n"+ msgs.get(u);
	}

}
