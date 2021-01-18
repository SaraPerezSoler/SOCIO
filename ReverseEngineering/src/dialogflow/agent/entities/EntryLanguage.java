package dialogflow.agent.entities;

import java.util.List;

public class EntryLanguage {

	private String Language;
	private List<Entry> entries;
	
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public List<Entry> getEntries() {
		return entries;
	}
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
}
