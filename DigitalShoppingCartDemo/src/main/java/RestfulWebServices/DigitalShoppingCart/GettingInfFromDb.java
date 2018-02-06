package RestfulWebServices.DigitalShoppingCart;
import java.sql.*;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class GettingInfFromDb 
{
	
	ItemsDetails id=new ItemsDetails();
	DbmsConnection con=new DbmsConnection();
	List<ItemsDetails> li=new ArrayList<ItemsDetails>();
	public  List<ItemsDetails> getDetails()
	{
		
		
		String query="select * from ItemsList";
		try{
			Connection connection=con.getConnection();
			if(connection==null){
				System.out.println("connection is null");
			}
		PreparedStatement pstmt=connection.prepareStatement(query);
		if(pstmt==null){
			System.out.println("pstmt is null");
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
			System.out.println(id.getItemName());
			System.out.println(id.getUnicode());
			System.out.println(id.getAddedDate());
			System.out.println(id.getPrice());
			System.out.println(id.getUnits());
		}
		
		
		}
		catch(Exception ex){
			System.out.println("exception caught"+ex);
		}
		return li;
	}
}