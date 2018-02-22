package RestfulWebServices.DigitalShoppingCart;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class ItemsDetails {
	String ItemName;
	String Unicode;
	String Units;
	String AddedDate;
	int price;
	@XmlElement(name="ItemName")
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	@XmlElement(name="Unicode")
	public String getUnicode() {
		return Unicode;
	}
	public void setUnicode(String unicode) {
		Unicode = unicode;
	}
	@XmlElement(name="Units")
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	@XmlElement(name="AddedDate")
	public String getAddedDate() {
		return AddedDate;
	}
	public void setAddedDate(String addedDate) {
		AddedDate = addedDate;
	}
	@XmlElement(name="price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
