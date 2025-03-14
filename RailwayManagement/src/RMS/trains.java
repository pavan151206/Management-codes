package RMS;
import java.util.*;
import java.sql.*;
public class trains extends bills{

	Scanner sc=new Scanner(System.in);
	void add() throws SQLException
	{
		Connection con=dbconnection.getConnection();
		
		String query="insert into trains values(?,?,?,?,?,?,?);";
		PreparedStatement pst=con.prepareStatement(query);
		System.out.println("Enter the id no");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the train number");
		String trainno=sc.nextLine();
		System.out.println("Enter the train name");
		String trainname=sc.nextLine();
		System.out.println("Enter the train source");
		String source=sc.nextLine();
		System.out.println("Enter the train destination");
		String destination=sc.nextLine();
		System.out.println("Enter the available seats");
		int seats=sc.nextInt();
		System.out.println("Enter the ticket price");
		int price=sc.nextInt();
		pst.setInt(1, id);
		pst.setString(2, trainno);
		pst.setString(3, trainname);
		pst.setString(4, source);
		pst.setString(5, destination);
		pst.setInt(6, seats);
		pst.setInt(7, price);

		pst.executeUpdate();
		
		System.out.println("Train added successfully!!!");
		
	}
	void display() throws SQLException
	{
		Connection con=dbconnection.getConnection();
		String query="select * from trains;";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("x-----------------------------------------------------------------------------------------------------------x");
		System.out.println("|                                         Available Trains                                                  |");
		System.out.println("x-----------------------------------------------------------------------------------------------------------x");
		System.out.printf("|  %-10s%-12s%-30s%-12s%-20s%-12s%-5s    |\n", "Id","Train no","Train name","Source","Destiny","Seats","Price");
		System.out.println();
		while(rs.next())
		{
			System.out.printf("|  %-10s%-12s%-30s%-12s%-20s%-12s%-5s    |\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
		}
		System.out.println("x-----------------------------------------------------------------------------------------------------------x");
		
	}
	
	void book() throws SQLException
	{
		display();
		System.out.println("Enter the train index no to book the train");
		int id=sc.nextInt();
		System.out.println("Enter the amount of tickets");
		int seats=sc.nextInt();
		String seatsquery="select * from trains where id ="+id;
		
		Connection con=dbconnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(seatsquery);
		int available=0;
		String trainame="",traino="",tsourcee="",tdestinationn="";
		int price=0;
		if(rs.next())
		{
			trainame=rs.getString(2);
			traino=rs.getString(3);
			tsourcee=rs.getString(4);
			tdestinationn=rs.getString(5);
			available=rs.getInt(6);
			price =rs.getInt(7);
		}
		if(available<seats)
		{
			System.out.println("There is not that much seats available");
		}
		else
		{
			int tprice=price*seats;
			System.out.println("Tickets booked successfully");
			String query="insert into customers values(?,?,?,?,?,?,?);";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, "hello");
			pst.setString(3, traino);
			pst.setString(2, trainame);
			pst.setString(4, tsourcee);
			pst.setString(5, tdestinationn);
			pst.setInt(6, seats);
			pst.setInt(7, tprice);
			pst.executeUpdate();
			String qq="update trains set available = "+(available-seats)+" where id ="+id;
			st.executeUpdate(qq);

		}
	}
	
	void cancel() 
	{
		try {
			Connection con=dbconnection.getConnection();
			String query="select * from customers";
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery(query);int i=1;String trainnumber="";
			System.out.printf("%-5s%-30s%-30s%-15s%-15s\n","Id","Train no","Train name","Seats","Total Price");
			while(rst.next())
			{
				System.out.printf("%-5s%-30s%-30s%-15s%-15s\n",i,rst.getString(3),rst.getString(2),rst.getInt(6),rst.getInt(7));
				trainnumber=rst.getString(2);
				i++;
			}
			System.out.println("Enter the ticket to be cancelled");
			int id=sc.nextInt();
			String qq="delete from customers where trainnumber = "+trainnumber;
			st.executeUpdate(qq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	void displaytransaction() 
	{
		Connection con;
		try {
			con = dbconnection.getConnection();
			String query="select * from customers";
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery(query);int i=1;String trainnumber="";
			System.out.println("*************************************************************************************************************");
			System.out.printf("%-5s%-30s%-30s%-15s%-15s\n","Id","Train no","Train name","Seats","Total Price");
			while(rst.next())
			{
				System.out.printf("%-5s%-30s%-30s%-15s%-15s\n",i,rst.getString(3),rst.getString(2),rst.getInt(6),rst.getInt(7));
				trainnumber=rst.getString(2);
				i++;
			}
			System.out.println("*************************************************************************************************************");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
