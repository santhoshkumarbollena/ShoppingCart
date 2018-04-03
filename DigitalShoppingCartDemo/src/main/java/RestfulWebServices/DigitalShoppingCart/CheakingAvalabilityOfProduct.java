package RestfulWebServices.DigitalShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CheakingAvalabilityOfProduct {
	final  Logger logger=Logger.getLogger(CheakingAvalabilityOfProduct.class);
	DbmsConnection con=new DbmsConnection();
	List<String> li=new ArrayList<String>();
	public List<String> cheakfruits() {
		try{
			String query="select Availability from fruits";
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				logger.info(rs.getString(1));
				li.add(rs.getString(1));
			}
		}
		catch(Exception ex){
			logger.error("error in cheaking avalability calss in fruits cheaking "+ex);
		}	
		return li;
	}
	public List<String> cheakAva(String productName) {
		try{
			String query="select Availability from "+productName+" ";
			logger.info(query);
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				logger.info(rs.getString(1));
				li.add(rs.getString(1));
			}
		}
		catch(Exception ex){
			logger.error("error in cheaking avalability calss in fruits cheaking cheakava "+ex);
		}	
		return li;
	}

}
