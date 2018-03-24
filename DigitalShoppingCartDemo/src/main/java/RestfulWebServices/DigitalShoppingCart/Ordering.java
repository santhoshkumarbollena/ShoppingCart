package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

public class Ordering {
	final static Logger logger = Logger.getLogger(Ordering.class);
	DbmsConnection con=new DbmsConnection();
	public void addOrder(String userName) {
		try{
			String q="select * from cart where CustomerID='"+userName+"'";
			String q1="insert into ordereditems values(?,?,?,?,?)";
			String q2="insert into orderdetails values(?,?,?,?)";
			PreparedStatement pstmt=con.getConnection().prepareStatement(q);
			PreparedStatement pstmt1=con.getConnection().prepareStatement(q1);
			PreparedStatement pstmt2=con.getConnection().prepareStatement(q2);
			ResultSet rs=pstmt.executeQuery();
			UUID id=UUID.randomUUID();
			String ran=id.toString().substring(10);
			String Orderid="order"+ran.substring(5);
			logger.info(Orderid);
			//String time="2:00";
			Date d1=new Date();
			Timestamp t1=new Timestamp(d1.getTime());
			int total=0;
			while(rs.next()){
				logger.info(rs.getString(1));
				pstmt1.setString(1, Orderid);
				pstmt1.setString(2, rs.getString(2));
				pstmt1.setInt(3,rs.getInt(5));
				pstmt1.setInt(4, rs.getInt(3));
				pstmt1.setInt(5,rs.getInt(5)* rs.getInt(3));
				total=total+rs.getInt(5)* rs.getInt(3);
				int itemor=pstmt1.executeUpdate();
				if(itemor==0){
					logger.info("Not entered items to ordered items");
				}
			}
			pstmt2.setString(1, Orderid);
			pstmt2.setString(2,userName);
			pstmt2.setInt(3, total);
			pstmt2.setTimestamp(4,t1);
			int orderde=pstmt2.executeUpdate();
			if(orderde==0){
				logger.info("Not entered details to ordred details");
			}
		}
		catch(Exception ex){
			logger.error("Exception in Ordering in Add Order Remove from ordereditems,ordereddetails"+ex);
		}
	}
	

}
