package es.uam.app.consensus;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import branchDecision.Consensus;
import es.uam.app.main.SocioData;

public class ConsensusTimeOut extends TimerTask {

	private Consensus consensus;
	private ServletContext context;
	private boolean isExecute=false;
	public ConsensusTimeOut(ServletContext context, Consensus c) {
		consensus=c;
	}

	@Override
	public void run(){
		if (isExecute==false){
				try {
					SocioData.getSocioData(context).endVoting(consensus.getBranchGroup().getFather(), consensus);
				} catch (Exception e) {
					e.printStackTrace();
				}
			isExecute=true;
		}
	}
	
	public String getName(){
		return consensus.getName();
	}
	
	public void addVoting(){
		
	}

}
