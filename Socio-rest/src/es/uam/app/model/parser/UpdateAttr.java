package es.uam.app.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.uam.app.actions.models.CreateObject;
import es.uam.app.actions.models.UpdateSetAttribute;
import es.uam.app.projects.IsEObject;
import es.uam.app.projects.emf.model.EObjectControl;
import projectHistory.Action;
import socioProjects.ModelProject;

public class UpdateAttr extends DialogflowIntent {

	private String srcClass;
	private Map<String, Object> srcId;
	private String attrName;
	private Object value;

	public UpdateAttr() {
	}

	@Override
	public List<Action> evaluete(ModelProject projs) throws Exception {
		List<Action> actions = new ArrayList<>();
		
		EObjectControl src = projs.getObject(srcClass, srcId);
		IsEObject isSrc = src;
		if (src == null) {
			isSrc = new CreateObject(projs, srcClass, srcId);
			actions.add(((CreateObject)isSrc).getAction());
		}
		
		UpdateSetAttribute updateSetAttribute = new UpdateSetAttribute(projs, isSrc, attrName, value);
		actions.add(updateSetAttribute.getAction());
		return actions;
	}

	public String getSrcClass() {
		return srcClass;
	}

	public void setClassName(String srcClass) {
		this.srcClass = srcClass;
	}

	public Map<String, Object> getSrcId() {
		return srcId;
	}

	public void setId(Map<String, Object> srcId) {
		this.srcId = srcId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static UpdateAttr getUpdate(String sentence) {
		try {
			UpdateAttr ret = mapper.readValue(sentence, UpdateAttr.class);
			return ret;
		}catch (Exception e) {
			return null;
		}
	}

}
