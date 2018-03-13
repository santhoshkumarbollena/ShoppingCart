package RestfulWebServices.DigitalShoppingCart;

public class DbmsQuerys {
public	String GettingProductDetails="select * from  ProductDetails";
public	String AddCart="insert into Cart values(?,?,?,?,?,?)";
public String CherryPrice="select Price from Fruits ";
public String Login="select UserName,Password from CustomerDetails";
public String Registering="insert into CustomerDetails values(?,?,?,?,?,?,?)";
public String UserNameval="select UserName from CustomerDetails";
public String CUstomerDetails="select UserName ,FirstName ,LastName ,Email ,PhoneNumber ,Address  from CustomerDetails";
}
