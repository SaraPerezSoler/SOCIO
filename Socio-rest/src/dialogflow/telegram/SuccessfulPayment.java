package dialogflow.telegram;

public class SuccessfulPayment {
    private String currency; 
    private Integer total_amount;
    private String invoice_payload; 
    private String shipping_option_id;
    private OrderInfo order_info;
    private String telegram_payment_charge_id;
    private String provider_payment_charge_id;
    
    public SuccessfulPayment() {
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

	public String getTelegram_payment_charge_id() {
		return telegram_payment_charge_id;
	}

	public void setTelegram_payment_charge_id(String telegram_payment_charge_id) {
		this.telegram_payment_charge_id = telegram_payment_charge_id;
	}

	public String getProvider_payment_charge_id() {
		return provider_payment_charge_id;
	}

	public void setProvider_payment_charge_id(String provider_payment_charge_id) {
		this.provider_payment_charge_id = provider_payment_charge_id;
	}
    
    
}
