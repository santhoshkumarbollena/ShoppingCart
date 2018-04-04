package RestfulWebServices.DigitalShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
	String OrderId="";
	String time="";
	List<String> Ordereditems=new ArrayList<String>();
	int total=0;
	List<Float> Nofitems=new ArrayList<Float>();
	List<Integer> Price=new ArrayList<Integer>();
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<String> getOrdereditems() {
		return Ordereditems;
	}
	public void setOrdereditems(List<String> ordereditems) {
		Ordereditems = ordereditems;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Float> getNofitems() {
		return Nofitems;
	}
	public void setNofitems(List<Float> nofitems) {
		Nofitems = nofitems;
	}
	public List<Integer> getPrice() {
		return Price;
	}
	public void setPrice(List<Integer> price) {
		Price = price;
	}
	
}
