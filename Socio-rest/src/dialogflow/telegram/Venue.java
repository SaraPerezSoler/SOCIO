package dialogflow.telegram;

public class Venue {
    private Location location; 
    private String title; 
    private String address; 
    private String foursquare_id; 
    private String foursquare_type;
    
    public Venue() {
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFoursquare_id() {
		return foursquare_id;
	}

	public void setFoursquare_id(String foursquare_id) {
		this.foursquare_id = foursquare_id;
	}

	public String getFoursquare_type() {
		return foursquare_type;
	}

	public void setFoursquare_type(String foursquare_type) {
		this.foursquare_type = foursquare_type;
	}
    
    
}
