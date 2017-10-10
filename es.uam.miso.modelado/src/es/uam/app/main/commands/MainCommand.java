package es.uam.app.main.commands;

import java.util.ArrayList;
import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.ValidText;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.main.exceptions.ProjectNotFoundException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public abstract class MainCommand {
	private static final char[] validProjectCharacteres = { '_' };

	public abstract void execute(Msg rm) throws SendMessageExc, Exception;

	protected String validProjectName(String text) {
		return ValidText.validText(text, validProjectCharacteres, 30);
	}

	public abstract String getName();
	public abstract String getDesc();
	public abstract String getNeeds();

	public Project searchProject(Msg msg) throws FatalException, ProjectNotFoundException {
		Project ret = null;
		String msgError = ". I don't have enough  data.";
		if (msg.hasProjectId()) {
			ret = SocioData.getSocioData().getProject(msg.getProjectId());
			msgError = " with the id= " + msg.getProjectId();
		} else if (msg.hasProjectName()) {
			String[] split = msg.getProject().split("/");

			if (split.length == 3) {
				User user = SocioData.getSocioData().getUser(split[1], split[0]);
				if (user != null) {
					ret = SocioData.getSocioData().getProject(validProjectName(split[2]), user);
				}
				msgError = " with the name= " + split[0] + "/" + split[1] + "/" + validProjectName(split[2]);
			} else {
				ret = SocioData.getSocioData().getProject(validProjectName(msg.getProject()), msg.getUser());
				msgError = " with the name= " + msg.getChannel() + "/" + msg.getUser().getNick() + "/" + validProjectName(msg.getProject());
			}

		}
		if (ret == null) {
			throw new ProjectNotFoundException(msgError);
		} else {
			return ret;
		}
	}
	
	public User searchUser(String text) throws FatalException{
		String [] split=text.split("/");
		User u;
		if (split.length<2){
			try{
				Long id=Long.parseLong(text);
				u=SocioData.getSocioData().getUser(id);
			}catch (NumberFormatException e) {
				u=SocioData.getSocioData().getUser(text);
			}
			
		}else{
			try{
				Long id=Long.parseLong(split[1]);
				u=SocioData.getSocioData().getUser(id, split[0]);
			}catch (NumberFormatException e) {
				u=SocioData.getSocioData().getUser(split[1], split[0]);
			}
		}
		return u;
	}
	
	public List<User> searchAllUser(String text) throws FatalException{
		String [] split=text.split("/");
		List<User> u=new ArrayList<User>();
		if (split.length<2){
			try{
				Long id=Long.parseLong(text);
				u.addAll(SocioData.getSocioData().getAllUser(id));
			}catch (NumberFormatException e) {
				u.addAll(SocioData.getSocioData().getAllUser(text));
			}
			
		}else{
			try{
				Long id=Long.parseLong(split[1]);
				u.add(SocioData.getSocioData().getUser(id, split[0]));
			}catch (NumberFormatException e) {
				u.add(SocioData.getSocioData().getUser(split[1], split[0]));
			}
		}
		return u;
	}
	
	public String project(){
		return "a project (channel/usernick/projectName or projectId)";
	}
	public String userToSearch(){
		return "a user to search (channel/usernick)";
	}
}
