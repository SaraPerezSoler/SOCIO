package dialogflow.telegram;

public class Invoice {

	private String title;
	private String description;
	private String start_parameter;
	private String currency;
	private int total_amount;
    private PhotoSize photo; 
    
    public Invoice() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_parameter() {
		return start_parameter;
	}

	public void setStart_parameter(String start_parameter) {
		this.start_parameter = start_parameter;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public PhotoSize getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoSize photo) {
		this.photo = photo;
	}
    
    
}
