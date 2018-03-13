package RestfulWebServices.DigitalShoppingCart;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationClass {
	String FirstName = "";
	String LastName = "";
	String Email = "";
	String Password = "";
	String PhoneNumber = "";
	String UserName="";
	String Address="";
	@XmlElement(name="Address")
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@XmlElement(name="UserName")
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@XmlElement(name = "FirstName")
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	@XmlElement(name = "LastName")
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@XmlElement(name = "Email")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@XmlElement(name = "Password")
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@XmlElement(name = "PhoneNumber")
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "RegistrationClass [FirstName=" + FirstName + ", LastName="
				+ LastName + ", Email=" + Email + ", Password=" + Password
				+ ", PhoneNumber=" + PhoneNumber + "]";
	}

}
