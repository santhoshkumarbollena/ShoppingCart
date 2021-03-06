package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.util.*;

import org.apache.log4j.Logger;

public class Cart {
	final  Logger logger = Logger.getLogger(Cart.class);
	List<Product> li=new ArrayList<Product>();
	DbmsConnection con=new DbmsConnection();
	public  void AddProductToCart(Product p1)
	
	{
		li.add(p1);
		
		DbmsQuerys query=new DbmsQuerys();
		String AddCart=query.AddCart;
		try{
		
		if(con==null){
			logger.error("exception in connection class");
		}
		PreparedStatement pstmt=con.getConnection().prepareStatement(AddCart);
		if(pstmt==null){
			logger.error("exception in prepared statement class");
		}
		logger.info(p1.getCustomerId());
		//logger.info(p1.getOrderId());
		logger.info(p1.getName());
		logger.info(p1.getNoOfunits());
		logger.info(p1.getUnits());
		logger.info(p1.getPrice());
		pstmt.setString(1,p1.getCustomerId());
		//pstmt.setString(2,p1.getOrderId());
		pstmt.setString(2,p1.getName());
		pstmt.setDouble(3,p1.getNoOfunits());
		pstmt.setString(4,p1.getUnits());
		pstmt.setInt(5,p1.getPrice());
		int i=pstmt.executeUpdate();
		if(i!=0){
			logger.info("entered to cart succefully");
		}
		}catch(Exception ex){
			logger.error("exception in Cart calss"+ex);
		}
	}
	public void updateCart(String customer, String itemName, String noofunits, String price) {
			logger.info(customer+itemName+noofunits);
			try{
				
				String q="update cart set numberofunits='"+noofunits+"',price='"+price+"' where CustomerID='"+customer+"' and name='"+itemName+"';";
				PreparedStatement pstmt=con.getConnection().prepareStatement(q);
				pstmt.executeUpdate();
			}catch(Exception ex){
				logger.error("exception in cart updatecart "+ex);
			}
	}
}
