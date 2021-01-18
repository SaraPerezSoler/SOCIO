package dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

public class Response {
	private List<Context> affectedContext = new ArrayList<Context>();
	private List<Parameter> parameters = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();

	public List<Context> getAffectedContext() {
		return affectedContext;
	}

	public void setAffectedContext(List<Context> affectedContext) {
		this.affectedContext = affectedContext;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}