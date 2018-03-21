package RestfulWebServices.DigitalShoppingCart;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class LoginDetails {
	String UserName="";
	String Password="";
	@XmlElement(name="UserName")
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	@XmlElement(name="Password")
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

}
