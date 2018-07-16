package es.uam.app.main.commands.old;

import java.util.ArrayList;
import java.util.List;

import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.main.commands.DataFormat;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class StartConsensus extends MainCommand implements DataFormat{

	public StartConsensus() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		
		Project actual=searchProject(rm);
		if (!rm.getUser().isAdmin(actual)){
			throw new NotAccessException("You need to be a project Admin");
		}
		List<User> users=new ArrayList<User>();
		String[] split=rm.getUserToSearch().split("-");
		for(String s: split){
			User u=searchUser(s);
			if (u!=null){
				users.add(u);
			}
		}
		
		rm.setText(validProjectName(rm.getText()));
		if (actual.getOpenBranchGroup(rm.getText()).isEmpty()){
			throw new SendMessageExc("The project "+actual.getCompleteName()+" doesn't have the group "+rm.getText());
		}
		
		SocioData.getSocioData().startConsensus(actual, rm.getText(), users, rm.getDate());
		Decision d=actual.getDecision(rm.getText());
		
		
		throw new SendMessageExc("Projects:\n "+this.printProject(d.getBranchs())+"\nUsers:\n"+printUsers(users));
		
		
	}

	@Override
	public String getName() {
		return "START_CONSENSUS";
	}

	@Override
	public String getDesc() {
		return "start the necesary process to discurs about the branchs";
	}

	@Override
	public String getNeeds() {
		return project()+", branchs about debate (text field), users to debate(userstosearch field <user1>-<user2>-...)";
	}

}
