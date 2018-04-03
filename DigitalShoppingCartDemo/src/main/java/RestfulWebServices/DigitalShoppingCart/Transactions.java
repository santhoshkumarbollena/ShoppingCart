package RestfulWebServices.DigitalShoppingCart;

public class Transactions {
	String OrderId="";
	String CustomerId="";
	int TotalPurchasedPrice=0;
	String TimeOfPurchase="";
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public int getTotalPurchasedPrice() {
		return TotalPurchasedPrice;
	}
	public void setTotalPurchasedPrice(int totalPurchasedPrice) {
		TotalPurchasedPrice = totalPurchasedPrice;
	}
	public String getTimeOfPurchase() {
		return TimeOfPurchase;
	}
	public void setTimeOfPurchase(String timeOfPurchase) {
		TimeOfPurchase = timeOfPurchase;
	}
	
}
