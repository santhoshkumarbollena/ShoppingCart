package RestfulWebServices.DigitalShoppingCart;

public class DbmsQuerys {
public	String GettingProductDetails="select * from  ProductDetails";
public	String AddCart="insert into Cart values(?,?,?,?,?,?)";
public String CherryPrice="select Price from Fruits ";
public String Login="select Email,Password from CustomerDetails";
}
