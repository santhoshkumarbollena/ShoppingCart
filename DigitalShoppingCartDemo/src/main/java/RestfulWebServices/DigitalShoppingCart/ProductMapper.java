package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	

}
