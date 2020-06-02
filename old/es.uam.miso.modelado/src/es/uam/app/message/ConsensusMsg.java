package es.uam.app.message;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import socioProjects.User;

public class ConsensusMsg extends PrivateMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int START=0;
	public static final int END=1;
	public static final int ALMOST_END=2;
	public static final int CONTINUE=3;
	
	private int state;
	
	private String consensusName;
	private String projectName;
	
	private Map<String, File> branchs=new HashMap<String,File>();


	private Map<User, Double> reVote=new HashMap<User,Double>();
	public ConsensusMsg(String projectName, String consensusName, String message, File png, int state) {
		super(message, png);
		this.state=state;
		this.projectName=projectName;
		this.consensusName=consensusName;
	}
	
	public void addOption(String projectName, File png){
		branchs.put(projectName, png);
	}

	public String getConsensusName() {
		return consensusName;
	}

	public void setConsensusName(String consensusName) {
		this.consensusName = consensusName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Map<String, File> getBranchs() {
		return branchs;
	}
	
	public boolean start() {
		return this.state==START;
	}
	
	public boolean continuo() {
		return this.state==CONTINUE;
	}
	
	public boolean end() {
		return this.state==END;
	}
	
	public boolean almostEnd() {
		return this.state==ALMOST_END;
	}
	
	public Map<User, Double> getReVote() {
		return reVote;
	}

	public void setReVote(Map<User, Double> reVote) {
		this.reVote = reVote;
	}


	

}
