package dialogflow.telegram;

public class PreCheckoutQuery {
    private String id; 
    private User from; 
    private String currency; 
    private Integer total_amount;
    private String invoice_payload; 
    private String shipping_option_id;
    private OrderInfo order_info;
    
    public PreCheckoutQuery() {
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public String getInvoice_payload() {
		return invoice_payload;
	}

	public void setInvoice_payload(String invoice_payload) {
		this.invoice_payload = invoice_payload;
	}

	public String getShipping_option_id() {
		return shipping_option_id;
	}

	public void setShipping_option_id(String shipping_option_id) {
		this.shipping_option_id = shipping_option_id;
	}

	public OrderInfo getOrder_info() {
		return order_info;
	}

	public void setOrder_info(OrderInfo order_info) {
		this.order_info = order_info;
	}
    
    
}
