package RMS;
import java.util.*;
import java.sql.*;
public class bills {
	void billls(String username) throws SQLException
	{
		Connection con=dbconnection.getConnection();
		String query="select count(*) from customers";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
			
				String qq="select * from customers";
				ResultSet rst=st.executeQuery(qq);
				System.out.println("                    Thank You!! Have a Safe and Happy Journey");
				System.out.println("*****************************************************************************************");
				System.out.println("      Bill NO:1111              Tours && Travels                 2025-12-15");
				System.out.println("*****************************************************************************************");
				System.out.println("Name :"+username);
				System.out.printf("%-30s%-30s%-15s%-15s\n","Train no","Train name","Seats","Total Price");
				while(rst.next())
				{
					System.out.printf("%-30s%-30s%-15s%-15s\n",rst.getString(3),rst.getString(2),rst.getInt(6),rst.getInt(7));

				}
				System.out.println("*****************************************************************************************");

			
		}
	}
}
