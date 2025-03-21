package hm;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class adminpage implements ActionListener{
	JButton nrooms,book,logout;
	JLabel label;
	DefaultTableModel table;
	JFrame frame;
	adminpage()
	{
		frame=new JFrame("HOME");
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		ImageIcon image=new ImageIcon("gow.png");
		frame.setIconImage(image.getImage());
		nrooms=new JButton("Rooms Available");
		nrooms.setPreferredSize(new Dimension(150,30));
		nrooms.setBounds(30,100,150,30);
		nrooms.setFocusable(false);
		nrooms.setBorder(null);
		nrooms.addActionListener(this);
		ImageIcon image1=new ImageIcon("goww.png");
		label=new JLabel();
		label.setIcon(image1);
		
		logout=new JButton("Logout");
		logout.setPreferredSize(new Dimension(150,30));
		logout.setBounds(30,180,150,30);
		logout.setBorder(null);
		logout.setFocusable(false);
		logout.addActionListener(this);
		
		book=new JButton("Book Room");
		book.setFocusable(false);
		book.setPreferredSize(new Dimension(150,30));
		book.setBounds(30,140,150,30);
		book.addActionListener(this);
		book.setBorder(null);
		label.setBounds(170,30,300,250);
		frame.getContentPane().setBackground(Color.black);
		frame.add(logout);
		frame.add(label);
		frame.add(book);
		frame.add(nrooms);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nrooms)
		{
			String names[]= {"Id","Status","Type","Bed"};
			table=new DefaultTableModel(names,0);
			fetchdata();
			JTable tabel =new JTable(table);
			JScrollPane sp=new JScrollPane(tabel);
			sp.setBounds(220,30,250,250);
			frame.add(sp);
			label.setVisible(false);
			frame.setVisible(true);
		}
		if(e.getSource()==book)
		{
			new bookingPage();
		}
		if(e.getSource()==logout)
		{
			new mainpage();
			frame.dispose();
		}
	}
	
	void fetchdata()
	{
		try {
			Connection con=dbconnection.getConnection();
			String query="select * from rooms;";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				int no=rs.getInt(1);
				String avai=rs.getString(2);
				String type=rs.getString(3);
				String bed=rs.getString(4);
				table.addRow(new Object[] {no,avai,type,bed});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
