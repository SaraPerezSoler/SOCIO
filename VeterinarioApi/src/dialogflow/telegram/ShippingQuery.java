package dialogflow.telegram;

public class ShippingQuery {
    private String id; 
    private User from; 
    private String invoice_payload; 
    private ShippingAddress shipping_address;
    
    public ShippingQuery() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public String getInvoice_payload() {
		return invoice_payload;
	}

	public void setInvoice_payload(String invoice_payload) {
		this.invoice_payload = invoice_payload;
	}

	public ShippingAddress getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(ShippingAddress shipping_address) {
		this.shipping_address = shipping_address;
	}
    
    
}
