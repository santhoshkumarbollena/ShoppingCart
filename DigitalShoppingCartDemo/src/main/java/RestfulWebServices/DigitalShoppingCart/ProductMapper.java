package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;







import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
	public boolean deleteProductFromCartAfterOrdering(String userName) {
		boolean f=false;
		try{
			String query="delete from Cart where CustomerID='"+userName+"'";
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			f=pstmt.execute();
			logger.info(f);
		}catch(Exception ex){
			logger.info("Exception in product mapper in deleteProduct"+ex);
		}
		return f;
		
	}
	public List<Items> geAllProducts() {
		List<Items> items=new ArrayList<Items>();
		try{
			String fruits="select * from fruits";
			String cakes="select * from cakes";
			String vegitables="select * from vegitables";
			String dryfruits="select * from dryfruits";
			String softdrinks="select * from softdrinks";
			String icecreams="select * from icecreams";
			PreparedStatement pstmt1=con.getConnection().prepareStatement(fruits);
			ResultSet rs=pstmt1.executeQuery();
			while(rs.next()){
				Items it=new Items();
				it.setItemName(rs.getString(1));
				it.setUnits(rs.getString(2));
				it.setPrice(rs.getInt(3));
				it.setAvalability(rs.getString(4));
				it.setCategory("fruits");
				items.add(it);
			}
			PreparedStatement pstmt2=con.getConnection().prepareStatement(cakes);
			ResultSet rs2=pstmt2.executeQuery();
			while(rs2.next()){
				Items it=new Items();
				it.setItemName(rs2.getString(1));
				it.setUnits(rs2.getString(2));
				it.setPrice(rs2.getInt(3));
				it.setAvalability(rs2.getString(4));
				it.setCategory("cakes");
				//logger.info(it.getAvalability());
				items.add(it);
			}
			PreparedStatement pstmt3=con.getConnection().prepareStatement(vegitables);
			ResultSet rs3=pstmt3.executeQuery();
			while(rs3.next()){
				Items it=new Items();
				it.setItemName(rs3.getString(1));
				it.setUnits(rs3.getString(2));
				it.setPrice(rs3.getInt(3));
				it.setAvalability(rs3.getString(4));
				it.setCategory("vegitables");
				items.add(it);
			}
			PreparedStatement pstmt4=con.getConnection().prepareStatement(dryfruits);
			ResultSet rs4=pstmt4.executeQuery();
			while(rs4.next()){
				Items it=new Items();
				it.setItemName(rs4.getString(1));
				it.setUnits(rs4.getString(2));
				it.setPrice(rs4.getInt(3));
				it.setAvalability(rs4.getString(4));
				it.setCategory("dryfruits");
				items.add(it);
			}
			PreparedStatement pstmt5=con.getConnection().prepareStatement(softdrinks);
			ResultSet rs5=pstmt5.executeQuery();
			while(rs5.next()){
				Items it=new Items();
				it.setItemName(rs5.getString(1));
				it.setUnits(rs5.getString(2));
				it.setPrice(rs5.getInt(3));
				it.setAvalability(rs5.getString(4));
				it.setCategory("softdrinks");
				items.add(it);
			}
			PreparedStatement pstmt6=con.getConnection().prepareStatement(icecreams);
			ResultSet rs6=pstmt6.executeQuery();
			while(rs6.next()){
				Items it=new Items();
				it.setItemName(rs6.getString(1));
				it.setUnits(rs6.getString(2));
				it.setPrice(rs6.getInt(3));
				it.setAvalability(rs6.getString(4));
				it.setCategory("icecreams");
				items.add(it);
			}
		}catch(Exception ex){
			logger.error("exception in ProductMapper in get All products "+ex);
		}
		return items;
	}
	public void updateProductPriceAndAvalability(String category,String itemName, String price, String avalability) {
		try{
			String query="update "+category+" set Price='"+price+"',Availability='"+avalability+"' where Name='"+itemName+"'";
			logger.info(query);
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			pstmt.executeUpdate();
		}catch(Exception ex){
			logger.error("exception in ProductMapper updatePanaA "+ex);
		}
		
	}
	
	

}
