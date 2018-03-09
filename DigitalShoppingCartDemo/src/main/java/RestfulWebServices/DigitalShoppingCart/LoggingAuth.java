package RestfulWebServices.DigitalShoppingCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import java.util.*;
public class LoggingAuth {
	final static Logger logger = Logger.getLogger(LoggingAuth.class);
	List<String> Uname=new ArrayList<String>();
	List<String> Password=new ArrayList<String>();
	
	public  List<String> VerifyLogin() {
		try{
		DbmsConnection con=new DbmsConnection();
		DbmsQuerys query=new DbmsQuerys();
		String q=query.Login;
		PreparedStatement pstmt=con.getConnection().prepareStatement(q);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			//logger.info(rs.getString(1));
			//logger.info(rs.getString(2));
			Uname.add(rs.getString(1));
			Password.add(rs.getString(2));
		}
		for(String s:Uname){
			logger.info(s);
		}
		for(String p:Password){
			logger.info(p);
		}
		}catch(Exception ex){
			logger.error("exception in LoggingAuth class"+ex);
		}
		return Password;
		
	}

	public List<String> VerifyLoginU() {
		try{
			DbmsConnection con=new DbmsConnection();
			DbmsQuerys query=new DbmsQuerys();
			String q=query.Login;
			PreparedStatement pstmt=con.getConnection().prepareStatement(q);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				//logger.info(rs.getString(1));
				//logger.info(rs.getString(2));
				Uname.add(rs.getString(1));
				Password.add(rs.getString(2));
			}
			for(String s:Uname){
				logger.info(s);
			}
			for(String p:Password){
				logger.info(p);
			}
			}catch(Exception ex){
				logger.error("exception in LoggingAuth class"+ex);
			}

			
		return Uname;
	}
	
}
