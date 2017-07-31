package es.uam.app.message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.uam.app.main.ValidText;
import es.uam.app.projects.ecore.Controlador;
import projectHistory.impl.ActionImpl;
import projectHistory.impl.MsgImpl;
import socioProjects.User;
import socioProjects.impl.UserImpl;
public class ReceivedMessage extends MsgImpl implements Comparable<ReceivedMessage> {


	private String projectName; // comando
	private Map<String, List<ActionImpl>> sentences;

	private static final char [] validCharacter={' ', '_', '.', ',', ';', '\'', '"', '-', '/'};

	public ReceivedMessage(String msg, User user, Date fecha, String command,String projectName, String id) {
		super();
		this.msg = msg;
		this.user = user;
		this.date = fecha;
		this.command = ValidText.validText(command, validCharacter);
		this.projectName=ValidText.validText(projectName, validCharacter);
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getChannel() {
		return user.getChannel();
	}

	@Override
	public String toString() {
		return "ReceivedMessage [msg=" + msg + ", command=" + command + ", sentence=" + text + ", user=" + user
				+ ", date=" + date + ", id=" + id + "]";
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Map<String, List<ActionImpl>> getSentencesActions() {
		/***********************/
		
		if (sentences == null) {
			return new HashMap<String, List<ActionImpl>>();
		}
		return sentences;
	}

	public void setSentences(Map<String, List<ActionImpl>> sentences) {
		this.sentences = sentences;
	}

	public void setText(String text) {
		this.text = ValidText.validText(text, validCharacter);

	}

	public boolean isUndoable() {
		return undoable;
	}

	public void setUndoable(boolean undoable) {
		this.undoable = undoable;
	}

	@Override
	public int compareTo(ReceivedMessage o) {
		return date.compareTo(o.getDate());
	}

	public boolean hasAction(String action) {
		Set<String> sentencesKeySet= sentences.keySet();
		for (String k: sentencesKeySet){
			List<ActionImpl> ams= sentences.get(k);
			for (ActionImpl am: ams){
				if (am.getActionName().equalsIgnoreCase(action)){
					return true;
				}
			}
		}
		return false;
		
	}

	public boolean hasElement(String name) {
		Set<String> sentencesKeySet= sentences.keySet();
		for (String k: sentencesKeySet){
			List<ActionImpl> ams= sentences.get(k);
			for (ActionImpl am: ams){
				if (am.getObject().getName().equalsIgnoreCase(name)){
					return true;
				}
			}
		}
		
		return false;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public List<ActionImpl> getAllActions(){
		Set<String> sentence= sentences.keySet();
		List<ActionImpl> actions= new ArrayList<ActionImpl>();
		for (String s: sentence){
			actions.addAll(sentences.get(s));
		}
		return actions;
	}

	public boolean hasText() {
		if (text!= null && !text.equals(" ") && !text.isEmpty()){
			return true;
		}
		return false;
	}

	public List<ActionImpl> getActionsFromObject(Controlador obj) {
		List<ActionImpl> ret= new ArrayList<>();
		List<ActionImpl> actions=getAllActions();
		for(ActionImpl act: actions){
			if (act.getObject().equals(obj)){
				ret.add(act);
			}
		}
		return ret;
	}

	

}
