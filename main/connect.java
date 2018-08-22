import java.sql.*;
import java.net.*;

public class connect
{
	 public Connection cs;   
	 public Statement st;
	 public ResultSet rs;

	public Statement connect()
	{
		
		try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//cs=DriverManager.getConnection("jdbc:odbc:lesta");
		Class.forName("com.mysql.jdbc.Driver");
		cs=DriverManager.getConnection("jdbc:mysql://localhost:3306/lesta","root","admin");
         

			st=cs.createStatement();
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return st;
		
	}
}
