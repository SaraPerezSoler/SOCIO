package dialogflow.request;

public class Image implements RichMessege{
	private String imageUri;
	private String accessibilityText;
	
	public Image() {
		super();
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getAccessibilityText() {
		return accessibilityText;
	}

	public void setAccessibilityText(String accessibilityText) {
		this.accessibilityText = accessibilityText;
	}

	@Override
	public String toString() {
		return "Image [imageUri=" + imageUri + ", accessibilityText=" + accessibilityText + "]";
	}
	
	

}
