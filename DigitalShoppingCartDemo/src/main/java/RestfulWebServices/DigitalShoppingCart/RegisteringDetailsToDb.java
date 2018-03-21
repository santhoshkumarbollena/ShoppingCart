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
			pstmt.setString(7, r1.getAddress());
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

	public List<RegistrationClass> getDetailsOfCustomer(String UserName) {
		String query="select UserName ,FirstName ,LastName ,Email ,PhoneNumber ,Address  from CustomerDetails";
		List<RegistrationClass> Details=new ArrayList<RegistrationClass>();
		try{
		PreparedStatement pstmt=con.getConnection().prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		int i=0;
		while(rs.next()){
			if(rs.getString(1).equals(UserName)){
			rc.setUserName(rs.getString(1));
			rc.setFirstName(rs.getString(2));
			rc.setLastName(rs.getString(3));
			rc.setEmail(rs.getString(4));
			rc.setPhoneNumber(rs.getString(5));
			rc.setAddress(rs.getString(6));
			
			Details.add(i,rc);
			
			i++;
			}
		}
		}catch(Exception ex){
			logger.error("Error in UserName Getting From Db to verify In Registration Page");
		}
		logger.info(Details);
		return Details;
		
	}

	public List<RegistrationClass> updateDetailsOfCustomer(RegistrationClass r1,String userName) {
		try{
		//	String query="update CustomerDetails set FirstName='Santhuu',LastName='kumarr',Email='boll', PhoneNumber='9999999999',Address='Demo' where UserName='santhosh'";
		String query="update CustomerDetails set FirstName='"+r1.getFirstName()+"',LastName='"+r1.getLastName()+"',Email='"+r1.getEmail()+"',PhoneNumber='"+r1.getPhoneNumber()+"',Address='"+r1.getAddress()+"' where UserName='"+userName+"';";
			
			logger.info(r1.getFirstName());
			logger.info(r1.getLastName());
			logger.info(r1.getEmail());
			logger.info(r1.getPhoneNumber());
			logger.info(r1.getAddress());
			PreparedStatement pstmt=con.getConnection().prepareStatement(query);
			int i=pstmt.executeUpdate();
			if(i==1)
			{
				logger.info("updated succesfully");
			}
		}catch(Exception ex){
			logger.error("error in updatedetails of customer"+ex);
		}
		return null;
	}
}
