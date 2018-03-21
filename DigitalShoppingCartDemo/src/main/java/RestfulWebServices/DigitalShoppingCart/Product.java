package RestfulWebServices.DigitalShoppingCart;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {
	String CustomerId="";
	//String OrderId="";
	String Name="";
	double NoOfunits;
	String Units="";
	int Price;
	@XmlElement(name="CustomerId")
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	@XmlElement(name="Name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@XmlElement(name="NoOfunits")
	public double getNoOfunits() {
		return NoOfunits;
	}
	public void setNoOfunits(double noOfunits) {
		NoOfunits = noOfunits;
	}
	@XmlElement(name="Units")
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	@XmlElement(name="Price")
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
		
}
