package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class OrderDetailsMapper {
	final static Logger logger = Logger.getLogger(OrderDetailsMapper.class);
	DbmsConnection con=new DbmsConnection();
	
	List<OrderDetails> liordd=new ArrayList<OrderDetails>();
	public 	List<OrderDetails> getOrdersOf(String userName) {
		OrderDetails ord;
		try{
			String query="select * from orderdetails where Customerid='"+userName+"'";
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				 ord=new OrderDetails();
				ord.setOrderId(rs.getString(1));
				ord.setTime(rs.getTimestamp(4).toString());
				ord.setTotal(rs.getInt(3));
				String query1="select * from ordereditems where Orderid='"+ord.getOrderId()+"'";
				PreparedStatement pstmt1=con.getConnection().prepareStatement(query1);
				ResultSet rs1=pstmt1.executeQuery();
				List<String> Orditems=new ArrayList<String>();
				List<Integer> NofItems=new ArrayList<Integer>();
				List<Integer> price=new ArrayList<Integer>();
				while(rs1.next()){
					Orditems.add(rs1.getString(2));
					NofItems.add(rs1.getInt(4));
					price.add(rs1.getInt(5));
				}
				ord.setNofitems(NofItems);
				ord.setOrdereditems(Orditems);
				ord.setPrice(price);
				liordd.add(ord);
			}
		}catch(Exception ex){
			logger.error("Exception in OrderDetailsMapper in getOrders of User"+ex);
		}
		return liordd;
	}

}
