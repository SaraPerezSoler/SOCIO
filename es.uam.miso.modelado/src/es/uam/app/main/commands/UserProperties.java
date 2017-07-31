package es.uam.app.main.commands;

import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.message.User;
import es.uam.app.projects.LocalProjects;

public class UserProperties extends MainCommand{

	public static final int ADD_USERS=0;
	public static final int REMOVE_USERS=1;
	public static final int CREATE_LIST=2;
	
	private int option;
	
	public UserProperties(int option) {
		this.option=option;
	}

	@Override
	public void execute(ReceivedMessage rm) throws SendMessageExc, Exception {
		
		String nameProject = validProjectName(rm.getProjectName());
		LocalProjects actual = LocalProjects.getProject(nameProject);
		if (actual == null) {
			throw new ProjectNotFoundException(nameProject);
		}
		if (!rm.getUser().isRoot() && !(rm.getUser().isAdmin(actual))){
			throw new NotAccessException("");
		}
		
		if (option==ADD_USERS){
			String text = rm.getText();
			String split[]=text.split("/");
			for (String s: split){
				if (s.startsWith("edit:")){
					s.replace("edit:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						us.addEditUser(actual);
					}
				}else if (s.startsWith("read:")){
					s.replace("read:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						us.addReadUser(actual);
					}
				}
			}
			
		}else if (option==REMOVE_USERS){
			String text = rm.getText();
			String split[]=text.split("/");
			for (String s: split){
				if (s.startsWith("edit:")){
					s.replace("edit:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						actual.removeEditUser(us);
					}
				}else if (s.startsWith("read:")){
					s.replace("read:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						actual.removeReadUser(us);
					}
				}
			}
		}else{
			String text = rm.getText();
			String split[]=text.split("/");
			actual.removeAccess();
			for (String s: split){
				if (s.startsWith("edit:")){
					s.replace("edit:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						actual.addEditUser(us);
					}
				}else if (s.startsWith("read:")){
					s.replace("read:", "");
					String[] users=s.split(";");
					for (String u:users){
						User us= new User("", -1, u, "");
						actual.addReadUser(us);
					}
				}
			}
		}
		
	}

}
