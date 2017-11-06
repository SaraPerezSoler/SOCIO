package es.uam.app.main.commands;

import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class StartDecision extends MainCommand implements DataFormat{

	public StartDecision() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {

		Project actual=searchProject(rm);
		if (!rm.getUser().isAdmin(actual)){
			throw new SendMessageExc("Only the admins can start a decision");
		}
		rm.setText(validProjectName(rm.getText()));
		if (actual.getOpenBranchGroup(rm.getText()).isEmpty()){
			throw new SendMessageExc("The project "+actual.getCompleteName()+" doesn't have the group "+rm.getText());
		}
		
		SocioData.getSocioData().startDecision(actual, rm.getText());
		Decision d=actual.getDecision(rm.getText());
		throw new SendMessageExc(this.printProject(d.getBranchs()));
		
		
	}

	@Override
	public String getName() {
		return "START_DECISION";
	}

	@Override
	public String getDesc() {
		return "start a Admin decision";
	}

	@Override
	public String getNeeds() {
		return project()+ ", branch group (text field)";
	}

}
