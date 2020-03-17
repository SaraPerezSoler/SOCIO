package dialogflow.telegram;

public class ShippingAddress {

    private String country_code;
    private String state;
    private String city; 
    private String street_line1; 
    private String street_line2; 
    private String post_code; 
    
    public ShippingAddress() {
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet_line1() {
		return street_line1;
	}

	public void setStreet_line1(String street_line1) {
		this.street_line1 = street_line1;
	}

	public String getStreet_line2() {
		return street_line2;
	}

	public void setStreet_line2(String street_line2) {
		this.street_line2 = street_line2;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
    
    
}
