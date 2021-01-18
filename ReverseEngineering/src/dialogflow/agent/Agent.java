package dialogflow.agent;

import java.util.ArrayList;
import java.util.List;

import dialogflow.agent.entities.Entity;
import dialogflow.agent.intents.Context;
import dialogflow.agent.intents.Intent;

public class Agent {
	
	private String name;
	private String language;
	private Webhook webhook;
	private List<String> supportedLanguages = new ArrayList<>();
	private List<Intent> intents= new ArrayList<>();
	private List<Entity> entities= new ArrayList<>();
	
	public Agent() {
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	public void setWebhook(Webhook webhook) {
		this.webhook = webhook;
	}
	public Webhook getWebhook() {
		return webhook;
	}
	@Override
	public String toString() {
		return "Agent [language=" + language + ", webhook=" + webhook + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSupportedLanguages() {
		return supportedLanguages;
	}
	public void setSupportedLanguages(List<String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}
	public List<Intent> getIntents() {
		return intents;
	}
	public List<Intent> getIntents(Context context) {
		List<Intent> intents = new ArrayList<Intent>();
		
		for (Intent intent : getIntents()) {
			if (intent.getContext().contains(context.getName())) {
				intents.add(intent);
			}
		}
		return intents;
	}
	public void setIntents(List<Intent> intents) {
		this.intents = intents;
	}
	public List<Entity> getEntities() {
		if (entities == null) {
			entities = new ArrayList<>();
		}
		return entities;
	}
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
}
