package dialogflow.agent.intents;

import java.util.List;

public class UserSaysLanguage {

	private String language;
	private List<TrainingPhrase> phrases;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<TrainingPhrase> getPhrases() {
		return phrases;
	}
	public void setPhrases(List<TrainingPhrase> phrases) {
		this.phrases = phrases;
	}
	
	
}
