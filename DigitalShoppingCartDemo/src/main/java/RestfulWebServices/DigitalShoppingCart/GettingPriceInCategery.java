package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class GettingPriceInCategery {
	
	final static Logger logger = Logger.getLogger(GettingPriceInCategery.class);
	static DbmsConnection con=new DbmsConnection();
	List<Integer> AllProductPrices=new ArrayList<Integer>();
	public  List<Integer> getPriceInCategory(String product) {
		try{
			String query="select price from "+product;
			logger.info(query);
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				logger.info(rs.getInt(1));
				AllProductPrices.add(rs.getInt(1));
			}
		}
		catch(Exception ex){
			
		}
		return AllProductPrices;
	}
}
