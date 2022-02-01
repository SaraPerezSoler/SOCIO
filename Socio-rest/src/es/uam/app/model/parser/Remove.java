package es.uam.app.model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.models.RemoveObject;
import es.uam.app.projects.emf.model.EObjectControl;
import projectHistory.Action;
import socioProjects.ModelProject;

public class Remove extends DialogflowIntent{
	
	private String className;
	private Map<String, List<Object>> ids;
	
	public Remove() {
	}

	@Override
	public List<Action> evaluete(ModelProject proj) throws Exception {
		int n = Integer.MIN_VALUE;
		List<Action> actions = new ArrayList<>();
		for (String key : ids.keySet()) {
			if (n > ids.get(key).size()) {
				n = ids.get(key).size();
			}
		}
		
		for (int i = 0; i < n; i++) {
			Map<String, Object> id = new HashMap<>();
			for (String key: ids.keySet()) {
				id.put(key, ids.get(key).get(i));
			}
			EObjectControl object = proj.getObject(className, id);
			if (object != null) {
				RemoveObject remove = new RemoveObject(proj, object);
				actions.add(((RemoveObject)remove).getAction());
			}
		}
		
		
		return actions;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Map<String, List<Object>> getIds() {
		return ids;
	}

	public void setIds(Map<String, List<Object>> ids) {
		this.ids = ids;
	}

}
