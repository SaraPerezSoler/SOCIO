package dialogflow.request;

import java.util.List;

public class QuickReplies implements RichMessege{
	
	private String title;
	private List<String> quickReplies;
	
	public QuickReplies() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getQuickReplies() {
		return quickReplies;
	}

	public void setQuickReplies(List<String> quickReplies) {
		this.quickReplies = quickReplies;
	}

	@Override
	public String toString() {
		return "QuickReplies [title=" + title + ", quickReplies=" + quickReplies + "]";
	}

	
	
	

}
