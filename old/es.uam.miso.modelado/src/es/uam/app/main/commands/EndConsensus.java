package es.uam.app.main.commands;

import java.io.File;
import java.util.List;

import branchDecision.Consensus;
import es.uam.app.main.SocioData;
import es.uam.app.message.ConsensusMsg;
import es.uam.app.message.SendMessageExc;
import es.uam.app.message.VotingTerminate;
import projectHistory.Msg;
import socioProjects.Project;
import socioProjects.User;

public class EndConsensus extends MainCommand implements DataFormat {

	private static final String SUCCESSFULLY = "*Consensus* has been reached!\n";

	public EndConsensus() {

	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		if (!(rm instanceof VotingTerminate)) {
			throw new SendMessageExc("This action is not well formed");
		}
		Consensus consensus = ((VotingTerminate) rm).getConsensus();
		Project actual = searchProject(rm);

		String notVoted;
		List<User> users =consensus.getUsersNoVoted();
		if (users.isEmpty()) {
			notVoted = "All users have voted";
		} else {
			notVoted = "Users don't have voted:\n " + printUsers(users);
		}
		double con = SocioData.getSocioData().endVoting(actual,consensus);
		String measure = "The consensus measure for the branch group *"+consensus.getName()
				+ "* is " + String.format("%.2f", con) + " and the required one is "
				+String.format("%.2f", consensus.getConsensusRequired());
		
		List<Project> order = consensus.getOrder();
		String orderString = " The general preference order is:\n" + printOrderProject(order);
		

		String msgStandarText = measure + ".\n" + notVoted + ".\n" + orderString + "\n";

		String text="";
		File png=null;
		int consensusState;
		// Todos los usuarios han votado y se ha llegado a un nivel de consenso:
		if (con >= consensus.getConsensusRequired() && users.isEmpty()) {

			Project p = consensus.getConsensusFirstOption();
			png = SocioData.getSocioData().makeDecision(actual, consensus, p, rm.getDate());
			String makeDecision = "The branch " + p.getCompleteName() + " is merged with the project "
					+ actual.getCompleteName();

			text=SUCCESSFULLY + msgStandarText + makeDecision;
			consensusState=ConsensusMsg.END;
			/*ConsensusMsg msg = new ConsensusMsg(, png, ConsensusMsg.END);
			msg.setGroupMsg(SUCCESSFULLY + msgStandarText + makeDecision);
			msg.setGroupPng(png);
			msg.setUsers(vrm.getConsensus().getUsers());
			throw msg;*/

			// No han votado todos los usuarios pero se ha llegado a un nivel de
			// consenso.
		} else if (con >= consensus.getConsensusRequired()) {
			
			text=SUCCESSFULLY +msgStandarText;
			png=actual.getPng(null);
			consensusState=ConsensusMsg.ALMOST_END;
			/*ConsensusMsg msg = new ConsensusMsg(,
					actual.getPng(null), ConsensusMsg.ALMOST_END);
			msg.setGroupMsg(notVoted + "\n" + measure + "\n" + orderString + "\n");
			msg.setUsers(vrm.getConsensus().getUsers());
			msg.setUsersNotVoted(vrm.getConsensus().getUsersNoVoted());
			throw msg;*/

			// No se ha llegado a nivel de consenso.
		} else {
			notVoted+=", but no consensus is reached";
			text=measure + ".\n" + notVoted + ".\n" + orderString + "\n";
			png=actual.getPng(null);
			consensusState=ConsensusMsg.CONTINUE;
			/*PrivateMsg msg = new PrivateMsg(msgStandarText);
			msg.setGroupMsg(notVoted + "\n" + measure + "\n" + orderString + "\n");
			msg.setUsers(vrm.getConsensus().getUsers());
			throw msg;*/
		}
		
		ConsensusMsg msg = new ConsensusMsg(actual.getCompleteName(), consensus.getName(), text, png, consensusState);
		
		for (Project p : consensus.getBranchs()) {
			msg.addOption(p.getCompleteName(), p.getPng(null));
		}
		for (User u : consensus.getUsers()) {
			List<Project> userOrder = consensus.getUserOrder(u);
			String userMsg = " Your preference order is:\n" + printOrderProject(userOrder);
			if (consensus.isRevoteCandidate(u)){
				userMsg+="\nYou are far from collective solution.";
			}else{
				userMsg+="\nYou are close to collective solution.";
			}
			
			msg.addUser(u, userMsg);
			
		}
		
		throw msg;
	}

	
	@Override
	public String getName() {
		return "END_CONSENSUS";
	}

	@Override
	public String getDesc() {
		return "Don't use this command";
	}

	@Override
	public String getNeeds() {
		return "nothing";
	}

}
