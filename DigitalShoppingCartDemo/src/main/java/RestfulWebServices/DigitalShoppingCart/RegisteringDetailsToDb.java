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
	DbmsQuerys q=new DbmsQuerys();
	public void RegisteringDetails() 
	{
		
	}
	
	public void addCoustomer(RegistrationClass r1) {
		registerc.add(r1);
		
		try{
			String query=q.Registering;
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			pstmt.setString(1, r1.getUserName());
			pstmt.setString(2,r1.getFirstName() );
			pstmt.setString(3, r1.getLastName());
			pstmt.setString(4, r1.getEmail());
			pstmt.setString(5, r1.getPassword());
			pstmt.setString(6, r1.getPhoneNumber());
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

	public List<String> getUserNamefromDb() {
		String query=q.UserNameval;
		List<String> Username=new ArrayList<String>();
		try{
		PreparedStatement pstmt=con.getConnection().prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Username.add(rs.getString(1));
		}
		}catch(Exception ex){
			logger.error("Error in UserName Getting From Db to verify In Registration Page");
		}
		logger.info(Username);
		return Username;
	}
}
