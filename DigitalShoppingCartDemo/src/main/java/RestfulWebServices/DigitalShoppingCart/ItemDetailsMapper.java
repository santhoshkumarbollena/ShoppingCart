package RestfulWebServices.DigitalShoppingCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
public class ItemDetailsMapper
{
	final static Logger logger = Logger.getLogger(ItemDetailsMapper.class);
	ItemsDetails id=new ItemsDetails();
	DbmsConnection con=new DbmsConnection();
	List<ItemsDetails> li=new ArrayList<ItemsDetails>();
	public  List<ItemsDetails> getDetails()
	{
		
		
		String query="select * from ItemsList";
		try{
			Connection connection=con.getConnection();
			if(connection==null){
				logger.error("connection is null");
			}
		PreparedStatement pstmt=connection.prepareStatement(query);
		if(pstmt==null){
			logger.error("pstmt is null");
		}
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			id.setItemName(rs.getString(1));
			id.setUnicode(rs.getString(2));
			id.setUnits(rs.getString(3));
			id.setAddedDate(rs.getString(4));
			id.setPrice(rs.getInt(5));
			li.add(id);
			logger.info(li);
			logger.info("---------");
		}
		
		
		}
		catch(Exception ex){
			System.out.println("exception caught"+ex);
		}
		System.out.println(li.toString());
		return li;
	}
	public void create(ItemsDetails i1) {
		System.out.println(i1.getAddedDate());
		li.add(i1);
		try{
	  for(ItemsDetails item:li){
		  System.out.println(item.getPrice());
		  System.out.println(item.getAddedDate());
		  System.out.println(item.getItemName());
		  System.out.println(item.getUnicode());
		  System.out.println(item.getUnits());
		  String query="insert into  ItemsList values(?,?,?,?,?)"; 
		  PreparedStatement pstmt=con.getConnection().prepareStatement(query);
		  pstmt.setInt(5,item.getPrice() );
		  pstmt.setString(4,item.getAddedDate() );
		  pstmt.setString(1,item.getItemName() );
		  pstmt.setString(2,item.getUnicode() );
		  pstmt.setString(3,item.getUnits() );
		  pstmt.executeUpdate();
		 
	  }
		}
	  catch(Exception ex){}
	
	}
}