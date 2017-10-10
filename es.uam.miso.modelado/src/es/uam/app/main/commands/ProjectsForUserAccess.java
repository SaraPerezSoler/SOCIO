package es.uam.app.main.commands;

import java.util.List;

import es.uam.app.main.SocioData;
import es.uam.app.main.exceptions.FatalException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;
import socioProjects.Visibility;

public class ProjectsForUserAccess extends MainCommand implements DataFormat {


	public ProjectsForUserAccess() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, FatalException {
		User user=rm.getUser();
		
		List<Project> own=SocioData.getSocioData().getProjects(user);
		List<Project> write=SocioData.getSocioData().getProjectsForUserCanWrite(user);
		List<Project> read=SocioData.getSocioData().getProjectsForUserCanRead(user);
		List<Project> public_=SocioData.getSocioData().getProjectsForVisibility(Visibility.PUBLIC);
		
		String list=this.printOwnProject(user, own);
		list+="\n"+this.printProjectCanWrite(user, write);
		list+="\n"+this.printProjectCanRead(user, read);
		list+="\n"+this.printVisibilityProjects(Visibility.PUBLIC, public_);
		throw new SendMessageExc(list);
	}

	@Override
	public String getName() {
		return "PROJECT_USER_ACCESS";
	}

	@Override
	public String getDesc() {
		
		return "sends all the project that the user who sends the msg has some access";
	}

	@Override
	public String getNeeds() {
		return "";
	}

}
