package RestfulWebServices.DigitalShoppingCart;

public class Items {
	String itemName="";
	String Units="";
	int Price;
	String Avalability="";
	String category="";
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getAvalability() {
		return Avalability;
	}
	public void setAvalability(String avalability) {
		Avalability = avalability;
	}
	

}
