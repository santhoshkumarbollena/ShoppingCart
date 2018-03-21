package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;


public class LoggingMapper {
	final static Logger logger = Logger.getLogger(LoggingMapper.class);
	
	public boolean verify(LoginDetails l1) {
		boolean loggedin=false;
		String UserName=l1.getUserName();
		String Password=l1.getPassword();
		//String UserName="santhosh12";
		//String  Password="demo123";
		try{
		DbmsConnection con=new DbmsConnection();
		String query="select UserName,Password from CustomerDetails";
		PreparedStatement pstmt=con.getConnection().prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			if(UserName.equals(rs.getString(1))&&Password.equals(rs.getString(2))){
				loggedin=true;
				logger.info("logged in "+UserName);
			}
		}
		
		}
		catch(Exception ex){
				logger.error("exception in LoggingMapper "+ex);
		}
		return loggedin;
	}

}
