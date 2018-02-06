package RestfulWebServices.DigitalShoppingCart;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemsDetails {
	String ItemName;
	String Unicode;
	String Units;
	String AddedDate;
	int price;
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getUnicode() {
		return Unicode;
	}
	public void setUnicode(String unicode) {
		Unicode = unicode;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public String getAddedDate() {
		return AddedDate;
	}
	public void setAddedDate(String addedDate) {
		AddedDate = addedDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
