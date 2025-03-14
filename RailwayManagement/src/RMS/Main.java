package RMS;
import java.util.*;
import java.sql.*;
public class Main {
	public static void main(String[]args) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			ui ob1 =new ui();
			System.out.println("1.Admin");
			System.out.println("2.Customer");
			System.out.println("3.Exit");
			int c=sc.nextInt();
			
			if(c==3)
			{
				Connection con=dbconnection.getConnection();
				String s="truncate table customers";
				Statement st=con.createStatement();
				st.executeUpdate(s);
				System.out.println("Thank You....Visit us again");
				break;
			}
			
			switch(c)
			{
			case 1:
				while(true)
				{
					admin ob=new admin();
					ob1.adminui();
					
					System.out.print("                                  Enter Your Choice: ");
					
					
					int choice =sc.nextInt();
					
					if(choice==3)
						break;
					switch(choice)
					{
					case 1:
						ob.login();
						break;
					case 2:
						ob.registration();
						break;
					default:
						System.out.println("Please enter a valid input");
					}
					
				}
				break;
			case 2:
				while(true)
				{
					ob1.customerui();
					customer ob=new customer(); 
					
					System.out.print("                                  Enter Your Choice: ");
					
					
					int choice =sc.nextInt();
					
					if(choice==3)
						break;
					switch(choice)
					{
					case 1:
						ob.login();
						break;
					case 2:
						ob.registration();
						break;
					default:
						System.out.println("Please enter a valid input");
					}
				}
				
				break;
			}
			
		}
	}
}
