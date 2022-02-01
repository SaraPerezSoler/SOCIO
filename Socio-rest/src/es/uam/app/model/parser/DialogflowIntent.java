package es.uam.app.model.parser;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import projectHistory.Action;
import socioProjects.ModelProject;

public abstract class DialogflowIntent {
	
	protected static ObjectMapper mapper = new ObjectMapper();
	public DialogflowIntent() {
	}
	public static DialogflowIntent getIntent(String sentence) {
		DialogflowIntent ret = Create.getCreate(sentence);
		if (ret!=null) {
			return ret;
		}
		ret = UpdateRef.getUpdate(sentence);
		if (ret!=null) {
			return ret;
		}
		ret = UpdateAttr.getUpdate(sentence);
		if (ret!=null) {
			return ret;
		}
		
		return null;
	}
	public abstract List<Action> evaluete(ModelProject projs) throws Exception;

}
