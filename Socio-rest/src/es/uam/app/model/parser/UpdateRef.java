package es.uam.app.model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.models.CreateObject;
import es.uam.app.actions.models.UpdateSetReference;
import es.uam.app.main.exceptions.InternalException;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import projectHistory.Action;
import socioProjects.ModelProject;

public class UpdateRef extends DialogflowIntent {

	private String srcClass;
	private String trgClass;
	private Map<String, List<Object>> srcId;
	private String refName;
	private Map<String, List<Object>> trgId;

	private Map<Integer, IsEObject> lastSrc = new HashMap<>();
	public UpdateRef() {
	}

	@Override
	public List<Action> evaluete(ModelProject projs) throws Exception {
		List<Action> actions = new ArrayList<>();
		int n = Integer.MAX_VALUE;
		for (String key : trgId.keySet()) {
			if (n > trgId.get(key).size()) {
				n = trgId.get(key).size();
			}
		}
		for (int i = 0; i < n; i++) {
			
			IsEObject isSrc = getsrc(projs, i, actions);
			
			Map<String, Object> ids = new HashMap<>();
			for (String key : trgId.keySet()) {
				ids.put(key, trgId.get(key).get(i));
			}
			
			EObjectControl trg = projs.getObject(trgClass, ids);
			IsEObject isTrg = trg;
			if (trg == null) {
				isTrg = new CreateObject(projs, trgClass, ids);
				actions.add(((CreateObject) isTrg).getAction());
			}
			UpdateSetReference references = new UpdateSetReference(projs, isSrc, refName, isTrg);
			actions.add(references.getAction());
		}


		return actions;

	}

	private IsEObject getsrc(ModelProject projs, int i, List<Action> actions) throws Exception {
		int n = Integer.MAX_VALUE;
		for (String key : srcId.keySet()) {
			if (n > srcId.get(key).size()) {
				n = srcId.get(key).size();
			}
		}
		Map<String, Object> ids = new HashMap<>();
		if (n > i) {
			for (String key : srcId.keySet()) {
				ids.put(key, srcId.get(key).get(i));
			}
			
			EObjectControl src = projs.getObject(srcClass, ids);
			IsEObject isSrc = src;
			if (src == null) {
				isSrc = new CreateObject(projs, srcClass, ids);
				actions.add(((CreateObject) isSrc).getAction());
			}
			lastSrc.put(i, isSrc);
			return isSrc;
			
			
		} else {
			return lastSrc.get(n-1);
		}
		
	}

	public String getSrcClass() {
		return srcClass;
	}

	public void setSrcClass(String srcClass) {
		this.srcClass = srcClass;
	}

	public String getTrgClass() {
		return trgClass;
	}

	public void setTrgClass(String trgClass) {
		this.trgClass = trgClass;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public static UpdateRef getUpdate(String sentence) {
		try {
			UpdateRef ret = mapper.readValue(sentence, UpdateRef.class);
			return ret;
		} catch (Exception e) {
			return null;
		}
	}

	public Map<String, List<Object>> getSrcId() {
		return srcId;
	}

	public void setSrcId(Map<String, List<Object>> srcId) {
		this.srcId = srcId;
	}

	public Map<String, List<Object>> getTrgId() {
		return trgId;
	}

	public void setTrgId(Map<String, List<Object>> trgId) {
		this.trgId = trgId;
	}


}
