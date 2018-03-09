package RestfulWebServices.DigitalShoppingCart;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class GetPrice {
	
	
	final  Logger logger=Logger.getLogger(GetPrice.class);
	public  int getPrice() {
		int  price=0;
		try{
		DbmsConnection con=new DbmsConnection();
		if(con==null)
		{
			logger.error("Connection object is null");
		}
		DbmsQuerys query=new DbmsQuerys();
		PreparedStatement pstmt=con.getConnection().prepareStatement(query.CherryPrice);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		 price=rs.getInt(1);
		logger.info(price);
		}catch(Exception ex){
			logger.error("Exception in GetPrice"+ex);
		}
		
		return price;
	}

}
