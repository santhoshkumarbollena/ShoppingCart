package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RegisteringDetailsToDb {
	final static Logger logger = Logger.getLogger(RegisteringDetailsToDb.class);
	List<RegistrationClass> registerc=new ArrayList<RegistrationClass>();
	DbmsConnection con=new DbmsConnection();
	RegistrationClass rc=new RegistrationClass();
	public void RegisteringDetails() 
	{
		
	}
	
	public void addCoustomer(RegistrationClass r1) {
		registerc.add(r1);
		
		try{
			String query="insert into CustomerDetails values(?,?,?,?,?)";
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			pstmt.setString(1,r1.getFirstName() );
			pstmt.setString(2, r1.getLastName());
			pstmt.setString(3, r1.getEmail());
			pstmt.setString(4, r1.getPassword());
			pstmt.setString(5, r1.getPhoneNumber());
			int i=pstmt.executeUpdate();
			if(i!=0){
				logger.info("registered succefully");
			}
			}catch(Exception ex){
				logger.error("exception caught"+ex);
				throw new RuntimeException("",ex);				
			}
		//return r1;
		
	}
}
