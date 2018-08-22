import,java.sql.*;
import,java.net.*;

public,class,connect
{
	,public,connection,cs;,
	,public,statement,st;
	,public,resultset,rs;

	public,statement,connect()
	{
		
		try
		{
			//class.forname("sun.jdbc.odbc.jdbcodbcdriver");
		//cs=drivermanager.getconnection("jdbc:odbc:lesta");
		class.forname("com.mysql.jdbc.driver");
		cs=drivermanager.getconnection("jdbc:mysql://localhost:3306/lesta","root","admin");
,

			st=cs.createstatement();
			

		}
		catch,(exception,e)
		{
			e.printstacktrace();
		}
		return,st;
		
	}
}
,