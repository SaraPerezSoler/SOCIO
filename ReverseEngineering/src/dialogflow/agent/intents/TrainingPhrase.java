package dialogflow.agent.intents;

import java.util.List;

public class TrainingPhrase {
	
	private List<Data> data;
	private boolean isTemplate;
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public boolean isTemplate() {
		return isTemplate;
	}
	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}
	
}
