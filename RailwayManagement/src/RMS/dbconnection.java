package RMS;

import java.sql.*;

public class dbconnection {
	private static final String url="jdbc:mysql://localhost:3306/railwaymanagement";
	private static final String username="root";
	private static final String pass="Pav@156sai";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,username,pass);
	}
}
