package RMS;
import java.util.*;
import java.sql.*;
public class admin extends trains{
	Scanner sc=new Scanner(System.in);
	
	
	void login() throws SQLException
	{
		System.out.println("Enter your username");
		String user=sc.nextLine();
		System.out.println("Enter your password");
		String pass=sc.nextLine();
		Connection con=dbconnection.getConnection();
		String query="select * from admin where userid = ? and pass =?;";
		PreparedStatement pas=con.prepareStatement(query);
		pas.setString(1, user);
		pas.setString(2, pass);
		ResultSet rs=pas.executeQuery();
		if(rs.next())
		{
			while(true)
			{
				trains ob=new trains();
				System.out.println("[1] Transactions");
				System.out.println("[2] Add Trains");
				System.out.println("[3] Display Customer name");
				System.out.println("[4] Display Trains");
				System.out.println("[5] Exit");
				int choicea=sc.nextInt();
				if(choicea==5)
						break;
				switch(choicea)
				{
				case 2:
					ob.add();
					break;
				case 4:
					ob.display();
					break;
				case 1:
					displaytransaction();
					break;
				case 3:
					customers();
					break;
				default:
					System.out.println("Please enter a valid input");
				}
			}
		}else
		{
			System.out.println("Invalid username or password!!!");
		}
	}
		void registration()
		{
			try {
				Connection con=dbconnection.getConnection();
				
				System.out.println("Enter your username");
				String username=sc.nextLine();
				System.out.println("Enter your password");
				String pass=sc.nextLine();
				String query="insert into admin values(?,?);";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, username);
				pst.setString(2, pass);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Username already exists");
			}
		}
		
		void customers()
		{
			try {
				Connection con=dbconnection.getConnection();
				
				Statement st=con.createStatement();
				String query="select userid, phone, email from customer";
				ResultSet rs=st.executeQuery(query);
				System.out.printf("%-15s%-15s%-15s\n", "username","phone","email");
				System.out.println("**********************************************************************************************");
				while(rs.next())
				{
					System.out.printf("%-15s%-15s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3));
				}
				System.out.println("**********************************************************************************************");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	


	

