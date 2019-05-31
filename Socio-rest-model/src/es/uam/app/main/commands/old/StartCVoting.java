/*package es.uam.app.main.commands.old;

import java.io.File;

import branchDecision.Consensus;
import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.main.commands.MainCommand;
import es.uam.app.main.exceptions.NotAccessException;
import es.uam.app.message.ConsensusMsg;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class StartCVoting extends MainCommand {

	public StartCVoting() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual = searchProject(rm);
		if (!rm.getUser().isAdmin(actual)) {
			throw new NotAccessException("You need to be a project Admin");
		}

		Decision d = actual.getDecision(validProjectName(rm.getText()));
		if (d == null) {
			throw new SendMessageExc("The consensus doesn't exits");
		}
		if (!(d instanceof Consensus)) {
			throw new SendMessageExc("The consensus doesn't exits");
		}

		int nRound = ((Consensus) d).getPreferencesRound().size();

		long time = 600000;

		SocioData.getSocioData().startVoting(actual, (Consensus) d, time, rm, rm.getDate());
		File png = actual.getPng(null);
		String text = "Start the 1st voting round in " + actual.getCompleteName() + " for the branch group " + d.getName();
		ConsensusMsg sends = new ConsensusMsg(actual.getCompleteName(), d.getName(), text, png, ConsensusMsg.START);
		if (nRound == 0) {

			for (Project p : d.getBranchs()) {
				sends.addOption(p.getCompleteName(), p.getPng(null, true));
			}
			for (User u : ((Consensus) d).getUsers()) {
				sends.addUser(u, "");
			}
			
		}else{
			String number=getNumber(nRound+1);
			text = "Start the "+number+" voting round in " + actual.getCompleteName() + " for the branch group " + d.getName();
			sends.setText(text);

			for (Project p : d.getBranchs()) {
				sends.addOption(p.getCompleteName(), p.getPng(null, true));
			}
			for (User u : ((Consensus) d).getUsersReVote(nRound).keySet()) {
				sends.addUser(u, "");
			}
		}
		
		throw sends;
	}
	
	private String getNumber(int nRound){
		String number=nRound+"";
		if (nRound%10==1 && nRound!=11){
			number+="st";
		}else if (nRound==2){
			number+="nd";
		}else if (nRound==3){
			number+="rd";
		}else{
			number+="th";
		}
		return number;
	}

	@Override
	public String getName() {
		return "START_C_VOTING";
	}

	@Override
	public String getDesc() {
		return "start the necesary process to discurs about the branchs";
	}

	@Override
	public String getNeeds() {
		return project()
				+ ",group branch name about debate (text field), users to debate(userstosearch field <user1>-<user2>-...)";
	}

}*/
