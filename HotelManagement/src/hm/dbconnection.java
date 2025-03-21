package hm;

import java.sql.*;


public class dbconnection {
	private static final String url="jdbc:mysql://localhost:3306/hotel";
	private static final String username="root";
	private static final String pass="Pav@156sai";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,username,pass);
	}
}
