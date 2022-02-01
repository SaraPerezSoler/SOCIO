package dialogflow.request;

import java.io.IOException;
import java.util.Map;

import dialogflow.restAccess.RestAccess;
import dialogflow.telegram.Update;

public class Payload {

	private String source;
	private Map<String, Object> payload_map;
	private SNMessage payloadMessage = null;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Map<String, Object> getPayload() {
		return payload_map;
	}
	public void setPayload(Map<String, Object> playload) {
		this.payload_map = playload;
	}
	public SNMessage getPayloadMessage() {
		if (payloadMessage == null && source!=null) {
			if (source.equalsIgnoreCase("telegram")) {
				try {
					payloadMessage = RestAccess.mapper.readValue(RestAccess.mapper.writeValueAsString(payload_map.get("data")), Update.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return payloadMessage;
	}
	public void setPayloadMessage(SNMessage playloadMessage) {
		this.payloadMessage = playloadMessage;
	}
	@Override
	public String toString() {
		return "Playload [source=" + source + ", playload=" + getPayload() + ", playloadMessage=" + getPayloadMessage() + "]";
	}
	public String getId() {
		if (payloadMessage instanceof Update) {
			return ((Update)payloadMessage).getMessage().getMessage_id()+"";
		}
		return "sinId";
	}
}
