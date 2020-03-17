package es.uam.app.consensus;

import java.util.TimerTask;

import branchDecision.Consensus;
import es.uam.app.main.Main;
import es.uam.app.message.VotingTerminate;
import projectHistory.Msg;

public class ConsensusTimeOut extends TimerTask {

	private Consensus consensus;
	private boolean isExecute=false;
	private Msg msg;
	public ConsensusTimeOut(Consensus c, Msg msg) {
		consensus=c;
		this.msg=msg;
	}

	@Override
	public void run(){
		if (isExecute==false){
			VotingTerminate m=new VotingTerminate(consensus, msg);
			Main.getPipe().write(m);
			isExecute=true;
		}
	}
	
	public String getName(){
		return consensus.getName();
	}
	
	public void addVoting(){
		
	}

}
