package dialogflow.request;

import java.util.List;

public class Text implements RichMessege{
	private List<String> text;

	
	public Text() {
		super();
	}

	public List<String> getText() {
		return text;
	}

	public void setText(List<String> text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Text [text=" + text + "]";
	}
	
	
}
