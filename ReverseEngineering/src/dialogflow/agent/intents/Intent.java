package dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

public class Intent {
	
	private String name;
	private List<String> context = new ArrayList<>();
	private List<Response> responses = new ArrayList<>();
	private boolean webhookUsed;
	private boolean fallbackIntent;
	private List<UserSaysLanguage> usersays= new ArrayList<>();
	
		
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getContext() {
		return context;
	}


	public void setContext(List<String> context) {
		this.context = context;
	}


	public List<Response> getResponses() {
		return responses;
	}


	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}


	public boolean isWebhookUsed() {
		return webhookUsed;
	}


	public void setWebhookUsed(boolean webhookUsed) {
		this.webhookUsed = webhookUsed;
	}


	public boolean isFallbackIntent() {
		return fallbackIntent;
	}


	public void setFallbackIntent(boolean fallbackIntent) {
		this.fallbackIntent = fallbackIntent;
	}


	public List<UserSaysLanguage> getUsersays() {
		return usersays;
	}


	public void setUsersays(List<UserSaysLanguage> usersays) {
		this.usersays = usersays;
	}


	public void addUsersays(UserSaysLanguage userSaysLanguage) {
		if (this.usersays == null) {
			this.usersays = new ArrayList<UserSaysLanguage>();
		}
		this.usersays.add(userSaysLanguage);
	}


	

}

