package dialogflow.request;

public class Card implements RichMessege{
	
	private String title;
	private String subtitle;
	private String imageUri;
	private Button buttons;
	public Card() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public Button getButtons() {
		return buttons;
	}
	public void setButtons(Button buttons) {
		this.buttons = buttons;
	}
	@Override
	public String toString() {
		return "Card [title=" + title + ", subtitle=" + subtitle + ", imageUri=" + imageUri + ", buttons=" + buttons
				+ "]";
	}
	
	

}
