package RestfulWebServices.DigitalShoppingCart;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class GetPrice {
	
	
	final  Logger logger=Logger.getLogger(GetPrice.class);
	public  int getPrice(String prod) {
		int  price=0;
		try{
		DbmsConnection con=new DbmsConnection();
		if(con==null)
		{
			logger.error("Connection object is null");
		}
		//DbmsQuerys query=new DbmsQuerys();
		String query="select name,price from Fruits ";
		PreparedStatement pstmt=con.getConnection().prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString(1).equals(prod))
		 price=rs.getInt(2);
		logger.info(price);
		}
		}catch(Exception ex){
			logger.error("Exception in GetPrice"+ex);
		}
		
		return price;
	}

}
