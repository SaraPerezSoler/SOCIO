package es.uam.app.main.commands.old;

/*import java.io.File;

import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class MakeDecision extends MainCommand {

	public MakeDecision() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=super.searchProject(rm);
		if (!rm.getUser().isAdmin(actual)){
			throw new NotAccessException("Must be the admin");
		}
		String [] split=rm.getText().split("-");
		if (split.length!=2){
			throw new SendMessageExc("I need the branchGroup and the project winner (<group>-<winner>)");
		}
		Decision d=actual.getDecision(validProjectName(split[0]));
		if (d==null){
			throw new SendMessageExc(validProjectName(split[0])+" is not a close branch group in the project "+ actual.getCompleteName());
		}
		Project p=d.getBranch(validProjectName(split[1]));
		if (p==null){
			throw new SendMessageExc(validProjectName(split[1])+" is not a close branch in the group "+ d.getName());
		}
		
		File png=SocioData.getSocioData().makeDecision(actual, d, p, rm.getDate());
		throw new SendMessageExc( "The branch "+p.getCompleteName()+" is merged with the project "+actual.getCompleteName(), png);
	}

	@Override
	public String getName() {
		return "MAKE_DECISION";
	}

	@Override
	public String getDesc() {
		return "Select a project in a decision group";
	}

	@Override
	public String getNeeds() {
		return project()+", branchGroup and the project winner (<group>-<winner>) in text field";
	}

}*/
