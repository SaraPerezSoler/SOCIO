package dialogflow.agent.intents;

public class Data {
	private String text;
	private boolean userDefined;
	private String alias;
	private String meta;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isUserDefined() {
		return userDefined;
	}
	public void setUserDefined(boolean userDefined) {
		this.userDefined = userDefined;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	
	

}
