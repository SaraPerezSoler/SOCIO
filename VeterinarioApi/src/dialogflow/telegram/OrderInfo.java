package dialogflow.telegram;

public class OrderInfo {
    private String name; 
    private String phone_number;
    private String email; 
    private ShippingAddress shipping_address;
    
    public OrderInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ShippingAddress getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(ShippingAddress shipping_address) {
		this.shipping_address = shipping_address;
	}
    
    
}
