package es.uam.app.message;

import java.util.Date;

import branchDecision.Consensus;
import es.uam.app.channels.CommandList;
import projectHistory.Msg;
import projectHistory.impl.MsgImpl;

public class VotingTerminate extends MsgImpl {

	private Consensus consensus;
	
	
	public VotingTerminate(Consensus c, Msg msg) {
		this.consensus=c;
		setProject(c.getProject().getCompleteName());
		setUser(c.getProject().getAdmin());
		this.setId(msg.getId());
		this.setDate(new Date());
		this.setCommand(CommandList.END_CONSENSUS);
		
	}


	public Consensus getConsensus() {
		return consensus;
	}

}
