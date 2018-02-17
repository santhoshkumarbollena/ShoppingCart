package RestfulWebServices.DigitalShoppingCart;
import java.sql.*;

public class DbmsConnection {
	Connection con;
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
				System.out.println("connection is null in connection class");
			}
			return con;
		}
		catch(Exception ex){
			System.out.println("exception caught in connection  "+ex);
			System.out.println("/n new ");
		}
		return con;
	}

}
