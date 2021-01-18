package dialogflow.agent.entities;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	
	private String name;
	private boolean isEnum;
	private List<EntryLanguage> entriesLanguage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnum() {
		return isEnum;
	}
	public void setEnum(boolean isEnum) {
		this.isEnum = isEnum;
	}
	public List<EntryLanguage> getEntriesLanguage() {
		return entriesLanguage;
	}
	public void setEntriesLanguage(List<EntryLanguage> entriesLanguage) {
		this.entriesLanguage = entriesLanguage;
	}
	
	public void addEntry (EntryLanguage entry) {
		if (entriesLanguage == null) {
			entriesLanguage = new ArrayList<EntryLanguage>();
		}
		entriesLanguage.add(entry);
	}
	

}
