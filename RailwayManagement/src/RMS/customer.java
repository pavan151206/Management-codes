package RMS;
import java.util.*;
import java.sql.*;
public class customer extends trains{
	Scanner sc=new Scanner(System.in);
	void login() throws SQLException
	{
		Connection con=dbconnection.getConnection();
		System.out.println("Enter your usename");
		String username=sc.nextLine();
		System.out.println("Enter your password");
		String pass=sc.nextLine();
		String query="select * from customer where userid= ? and pass=?;";
		PreparedStatement pas=con.prepareStatement(query);
		pas.setString(1, username);
		pas.setString(2, pass);
		ResultSet rs=pas.executeQuery();
		if(rs.next())
		{
			while(true)
			{
				System.out.println("[1] Book a ticket");
				System.out.println("[2] Cancel a ticket");
				System.out.println("[3] Exit");
				int choice =sc.nextInt();
				if(choice==3)
				{
					billls(username);
					break;
				}
				switch(choice)
				{
				case 1:
					book();
					break;
				case 2:
					cancel();
					break;
				default:
					System.out.println("Please enter a valid input");
				}
			}
		}
		else
		{
			System.out.println("Invalid password or username");
		}
		
	}
	
	void registration()
	{
		try {
			Connection con=dbconnection.getConnection();
			
			String query="insert into customer values(?,?,?,?);";
			System.out.println("Enter your username");
			String username=sc.nextLine();
			System.out.println("Enter your password");
			String pass=sc.nextLine();
			System.out.println("Enter your phone number");
			String phone=sc.nextLine();
			System.out.println("Enter your email id");
			String email=sc.nextLine();
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, pass);
			pst.setString(3, phone);
			pst.setString(4, email);
			
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
