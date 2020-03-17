package es.uam.app.main.commands;

import java.util.HashMap;
import java.util.Map;

import branchDecision.Consensus;
import branchDecision.Decision;
import es.uam.app.main.SocioData;
import es.uam.app.message.SendMessageExc;
import projectHistory.Msg;
import socioProjects.Project;

public class AddPoll extends MainCommand {

	public AddPoll() {
	}

	@Override
	public void execute(Msg rm) throws SendMessageExc, Exception {
		Project actual=searchProject(rm);
		String [] split=rm.getText().split("#");
		if(split.length<2){
			throw new SendMessageExc("Poorly developed text");
		}
		
		
		Decision d=actual.getDecision(validProjectName(split[0]));
		if (!(d instanceof Consensus)){
			throw new SendMessageExc("Poorly developed text");
		}
		if (!((Consensus)d).getUsers().contains(rm.getUser())){
			throw new SendMessageExc("Poorly developed text");
		}
		String[]branchs=split[1].split("-");
		if (branchs.length!=((Consensus)d).getBranchs().size()){
			throw new SendMessageExc("Poorly developed text");
		}
		
		
		Map<String, Integer> pos=new HashMap<>();
		for (int i=0; i<branchs.length; i++){
			String[] s=branchs[i].split(":");
			if (s.length!=2){
				throw new SendMessageExc("Poorly developed text");
			}
			try{
				int p=Integer.parseInt(s[1]);
				pos.put(s[0], p);
			}catch (NumberFormatException e) {
				throw new SendMessageExc("Poorly developed text");
			}
			
		}
		 
		
		SocioData.getSocioData().addPreference(actual, (Consensus)d, rm.getUser(),pos);
		
		
		
		
	}

	@Override
	public String getName() {
		return "ADD_POLL";
	}

	@Override
	public String getDesc() {
		return "Add a voting in a consensus decision.";
	}

	@Override
	public String getNeeds() {
		return project()+", <consensusName>#<Option1>:<Pos>-<Option2>:<pos>-...";
	}

}
