package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TransactionDetails {
	final Logger logger = Logger.getLogger(TransactionDetails.class);
	List<Transactions> li=new ArrayList<Transactions>();
	public List<Transactions> getTransactions() {
	DbmsConnection con=new DbmsConnection();
		try{
			String Query="select * from orderdetails";
			PreparedStatement pstmt=con.getConnection().prepareStatement(Query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Transactions t=new Transactions();
				t.setOrderId(rs.getString(1));
				t.setCustomerId(rs.getString(2));
				t.setTotalPurchasedPrice(rs.getInt(3));
				t.setTimeOfPurchase(rs.getTimestamp(4).toString());
				li.add(t);
				logger.info(t.getCustomerId());
			}
			
		}catch(Exception ex){
			logger.error("Exception in Tansaction Details getTra() "+ex); 
		}
		return li;
	}

}
