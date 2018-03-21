package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;




import java.sql.*;
import java.util.ArrayList;

public class ProductMapper {
	Product pr=new Product();
	DbmsQuerys q=new DbmsQuerys();
	DbmsConnection con=new DbmsConnection();
	final static Logger logger = Logger.getLogger(ProductMapper.class);
	public Product getDetails() {
		try{
		PreparedStatement pst=con.getConnection().prepareStatement(q.GettingProductDetails);
		if(pst==null){
			logger.error("null in pst");
		}
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			pr.setName(rs.getString(1));
			pr.setNoOfunits(rs.getInt(2));
			pr.setUnits(rs.getString(3));
			pr.setPrice(rs.getInt(4));
			logger.info(pr.getName());
		}
		}catch(Exception ex){
			logger.error(ex);
		}
		return pr;
	}
	public ArrayList<Product> getCart(String userName) {
		ArrayList<Product> al=new ArrayList<Product>();
		String query="select * from Cart where CustomerID='"+userName+"';";
		try{
			
			
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				logger.info(rs.getString(1));
				logger.info(rs.getString(2));
				logger.info(rs.getDouble(3));
				logger.info(rs.getString(4));
				logger.info(rs.getInt(5));
				Product p1=new Product();
				p1.setCustomerId(rs.getString(1));
				p1.setName(rs.getString(2));
				p1.setNoOfunits(rs.getDouble(3));
				p1.setUnits(rs.getString(4));
				p1.setPrice(rs.getInt(5));
				al.add( p1);
				
			}
		}catch(Exception ex){
			logger.error("exception in product mapper getcart "+ex);
		}
		return al;
	}
	public boolean deleteProductFromCart(String UserName,String productName) {
		boolean f=false;
		try{
			String query="delete from Cart where CustomerID='"+UserName+" 'and name='"+productName+"'";
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			f=pstmt.execute();
			logger.info(f);
		}catch(Exception ex){
			logger.info("Exception in product mapper in deleteProduct"+ex);
		}
		return f;
	}
	
	

}
