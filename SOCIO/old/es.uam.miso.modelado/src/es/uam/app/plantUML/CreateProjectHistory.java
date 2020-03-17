package es.uam.app.plantUML;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import branchDecision.AdminChoice;
import branchDecision.Consensus;
import branchDecision.Decision;
import branchDecision.Round;
import socioProjects.Project;

public class CreateProjectHistory implements CreateText {

	private static final String START = "@startsalt"+ENTR+"{" + ENTR + ENTR;
	private static final String START_LIST = "{T" + ENTR + ENTR;
	private static final String END_LIST = ENTR + "}";
	private static final String END = ENTR + "}"+ENTR+"@endsalt";
	private static final String LEVEL_CARACTER = "+";
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	public CreateProjectHistory() {

	}

	public String createHistory(Project project) {
		String cad = START + START_LIST;
		int i = 1;
		cad += level(i) + project.getCompleteName()+ENTR;
		i++;
		cad += level(i) + df.format(project.getCreateDate()) + ": ** project creation **"+ENTR;
		cad+=branchs(project, i);
		cad += END_LIST + END;
		return cad;
	}

	private String level(int i) {
		String ret = "";
		for (int j = 0; j < i; j++) {
			ret += LEVEL_CARACTER;
		}
		return ret+" ";
	}

	private String branchs(Project project, int i) {
		Map<String, List<Project>> openGroups = project.getAllOpenBranchsGroup();

		Map<Date, String> branchs_date = new HashMap<>(); // open y close.
		Set<String> keySet = openGroups.keySet();
		for (String key : keySet) {
			List<Project> list = openGroups.get(key);
			Collections.sort(list, new Comparator<Project>() {
				@Override
				public int compare(Project o1, Project o2) {
					return o1.getCreateDate().compareTo(o2.getCreateDate());
				}
			});
			openGroups.put(key, list);

			branchs_date.put(list.get(0).getCreateDate(), key);
		}
		Map<String, Decision> closeBranchs = new HashMap<>();
		for (Decision d : project.getCloseBranchs()) {
			closeBranchs.put(d.getName(), d);
			List<Project> list = d.getBranchs();
			Collections.sort(list, new Comparator<Project>() {
				@Override
				public int compare(Project o1, Project o2) {
					return o1.getCreateDate().compareTo(o2.getCreateDate());
				}
			});
			branchs_date.put(list.get(0).getCreateDate(), d.getName());
		}

		String cad = "";
		List<Date> dates = new ArrayList<Date>(branchs_date.keySet());
		Collections.sort(dates);
		for (Date date : dates) {
			String group = branchs_date.get(date);
			List<Project> branchs = openGroups.get(group);

			if (branchs != null) {
				cad += level(i) + df.format(date) + ": <&lock-unlocked> ** branch group \"" + group + "\"**"+ENTR;
				cad+=printProjects(branchs, null, i+1);

			} else {
				cad += level(i) + df.format(date) + ": <&lock-locked> ** branch group \"" + group + "\"**"+ENTR;
				Decision d = closeBranchs.get(group);
				cad+=printProjects(d.getBranchs(), d.getChosenBranch(), i+1);
				if (d instanceof AdminChoice){
					cad+=level(i+1)+df.format(d.getMergedDate())+": \""+d.getChosenBranch().getName()+"\" is chosen"+ENTR;
					
				}else{
					for (Round r: ((Consensus)d).getPreferencesRound()){
						cad+=level(i+1)+df.format(r.getRoundDate())+": Consensus round "+(r.getRoundId()+1)+" measure = "+String.format("%.2f",r.getConsensusMeasure())+ENTR;
					}
				}
				cad+=level(i)+df.format(d.getMergedDate())+": ** merge branch \""+d.getChosenBranch().getName()+" \"**"+ENTR;
				cad+=level(i)+df.format(d.getMergedDate())+": ** close branch group \""+d.getName()+" \"**"+ENTR;
			}
			
			
			
		}
		return cad;

	}

	private String printProjects(List<Project> list, Project winner, int i) {
		String cad = "";
		for (Project o : list) {
			if (winner != null && o.equals(winner)) {
				cad += level(i) + df.format(o.getCreateDate()) + ":  [<&heart>] ** branch \"" + o.getName() + "\"**" + ENTR;
			} else {
				cad += level(i) + df.format(o.getCreateDate()) + ": // branch \"" + o.getName() + "\"//" + ENTR;

			}
		}
		return cad;
	}
}
