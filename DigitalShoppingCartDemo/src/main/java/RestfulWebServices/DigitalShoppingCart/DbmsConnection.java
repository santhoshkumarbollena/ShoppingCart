package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;

import java.sql.*;

public class DbmsConnection {
	Connection con;
	final static Logger logger = Logger.getLogger(DbmsConnection.class);
	public Connection getConnection()
	{
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String s="root";
			String pass="12345";
			String url="jdbc:mysql://localhost:3306/DigitalShoppingCart?useSSL=true";
			String q="select * from ItemsList ";
			
			Connection con=DriverManager.getConnection(url,s,pass);
			
			if(null==con)
			{
				logger.error("connection is null in connection class");
			}
			return con;
		}
		catch(Exception ex){
			logger.error("exception caught in connection  "+ex);
			logger.error("/n new ");
		}
		return con;
	}

}
