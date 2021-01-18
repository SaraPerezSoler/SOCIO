package dialogflow.agent.intents;

import java.util.List;

public class Message{
	private String type;
	private String lang;
	private List<String> speech;
	private String imageUrl;
	
//	public int getType() {
//		return (int)type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
	
	public int getType() {
		try {
		return Integer.parseInt(type);
		} catch (Exception e) {
			return -1;
		}
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public List<String> getSpeech() {
		return speech;
	}
	public void setSpeech(List<String> speech) {
		this.speech = speech;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}