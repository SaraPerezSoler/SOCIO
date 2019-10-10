package dialogflow.telegram.replykeyboard.buttons;

import com.fasterxml.jackson.annotation.JsonProperty;




public class KeyboardButton {

    private static final String TEXT_FIELD = "text";
    private static final String REQUEST_CONTACT_FIELD = "request_contact";
    private static final String REQUEST_LOCATION_FIELD = "request_location";
   
    @JsonProperty(TEXT_FIELD)
    private String text;
    
    @JsonProperty(REQUEST_CONTACT_FIELD)
    private Boolean requestContact = false;
    
    @JsonProperty(REQUEST_LOCATION_FIELD)
    private Boolean requestLocation = false;

    public KeyboardButton() {
        super();
    }

    public KeyboardButton(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public KeyboardButton setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public KeyboardButton setRequestContact(Boolean requestContact) {
        this.requestContact = requestContact;
        return this;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }

    public KeyboardButton setRequestLocation(Boolean requestLocation) {
        this.requestLocation = requestLocation;
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestContact == null) ? 0 : requestContact.hashCode());
		result = prime * result + ((requestLocation == null) ? 0 : requestLocation.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyboardButton other = (KeyboardButton) obj;
		if (requestContact == null) {
			if (other.requestContact != null)
				return false;
		} else if (!requestContact.equals(other.requestContact))
			return false;
		if (requestLocation == null) {
			if (other.requestLocation != null)
				return false;
		} else if (!requestLocation.equals(other.requestLocation))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KeyboardButton [text=" + text + ", requestContact=" + requestContact + ", requestLocation="
				+ requestLocation + "]";
	}

 
}
