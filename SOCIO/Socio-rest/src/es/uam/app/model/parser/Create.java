package es.uam.app.model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.models.CreateObject;
import es.uam.app.actions.models.UpdateSetAttribute;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import projectHistory.Action;
import socioProjects.ModelProject;

public class Create extends DialogflowIntent{
	private String className;
	private int n = 1;
	private Map<String, List<Object>> ids; 
	private Map<String, List<Object>> notIds;

	public Create() {
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

	public Map<String, List<Object>> getNotIds() {
		return notIds;
	}

	public void setNotIds(Map<String, List<Object>> notIds) {
		this.notIds = notIds;
	}
	
	public static Create getCreate(String sentece) {
		try {
			Create ret = mapper.readValue(sentece, Create.class);
			return ret;
		}catch (Exception e) {
			return null;
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public List<Action> evaluete(ModelProject proj) throws Exception {
		List<Action> actions = new ArrayList<>();
		for (String key: ids.keySet()) {
			if (ids.get(key).size()<n) {
				throw new InternalException("To create "+n+" elements i need "+n+" ids, and for "+key+" I have "+ids.get(key).size());
			}
		}
		
		for (int i = 0; i < n; i++) {
			Map<String, Object> id = new HashMap<>();
			for (String key: ids.keySet()) {
				id.put(key, ids.get(key).get(i));
			}
			EObjectControl object = proj.getObject(className, id);
			IsEObject isObject = object;
			if (object == null) {
				isObject = new CreateObject(proj, className, id);
				actions.add(((CreateObject)isObject).getAction());
			}
			for (String key : notIds.keySet()) {
				if (notIds.get(key).size()>n) {
					UpdateSetAttribute updateAttribute = new UpdateSetAttribute(proj, isObject, key, notIds.get(key).get(i));
					actions.add(updateAttribute.getAction());
				}
			}
		}
		
		
		return actions;
	}

}
