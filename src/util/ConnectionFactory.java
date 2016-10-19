package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
	static 
	{
		try 
		{
			Class.forName ("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection ("jdbc:mysql://localhost/caixa?user=root&password=@#*sM561*#@");
	}
}