package hm;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class bookingPage implements ActionListener{
	JFrame frame;
	JTextField name,email,phone,address;
	JLabel name1,email1,phone1,address1,rootype1,bd1;
	JCheckBox male,female;
	JPanel panel;
	JButton submit;
	JComboBox type,bd;
	bookingPage()
	{
		frame=new JFrame("Booking Page");
		frame.setSize(500,400);
		ImageIcon image=new ImageIcon("gow.png");
		frame.setIconImage(image.getImage());

		String []typee= {"AC","NonAC"};
		String []bedd= {"single","double"};
		
		name=new JTextField();
		email=new JTextField();
		phone=new JTextField();
		address=new JTextField();
		type=new JComboBox(typee);
		bd=new JComboBox(bedd);
		name.setPreferredSize(new Dimension(250,40));
		email.setPreferredSize(new Dimension(250,40));
		phone.setPreferredSize(new Dimension(250,40));
		address.setPreferredSize(new Dimension(250,40));
		
		name.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					email.requestFocus();
				}
			}
		});
		
		email.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                phone.requestFocus(); // Moves to next field
	            }
	        }
	    });
		
		phone.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					address.requestFocus();
				}
			}
		});
		
		panel=new JPanel();
		panel.add(name);
		panel.add(email);
		panel.add(phone);
		panel.add(address);
		panel.add(type);
		panel.add(bd);
		panel.setLayout(new GridLayout(6,1,10,10));
		panel.setBounds(150,60,200,200);
		
		name1=new JLabel("Name :");
		email1=new JLabel("Email :");
		phone1=new JLabel("Phone :");
		address1=new JLabel("Address :");
		rootype1=new JLabel("Room type :");
		bd1=new JLabel("Bed Type :");
		
		submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(150,40));
		submit.setBounds(190,270,100,30);
		submit.addActionListener(this);
		JPanel panel1=new JPanel();
		panel1.add(name1);
		panel1.add(email1);
		panel1.add(phone1);
		panel1.add(address1);
		panel1.add(rootype1);
		panel1.add(bd1);
		panel1.setLayout(new GridLayout(6,1,10,10));
		panel1.setBounds(50,65,150,190);
		
		//frame.getContentPane().setBackground(Color.black);
		frame.add(panel);
		frame.add(panel1);
		frame.add(submit);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit)
		{
			try {
				Connection con=dbconnection.getConnection();
				String nam=name.getText();
				String ema=email.getText();
				String pho=phone.getText();
				String addr=address.getText();
				String roo=(String)type.getSelectedItem();
				String bd2=(String)bd.getSelectedItem();
				String q="select roomno from rooms where available='available' and type=? and bed=?;";
				PreparedStatement pst=con.prepareStatement(q);
				pst.setString(1, roo);
				pst.setString(2, bd2);
				ResultSet rs=pst.executeQuery();
				int roomnumber=0;
				if(rs.next())
				{
					roomnumber=rs.getInt(1)
				}
				
				if(!nam.isEmpty() && !ema.isEmpty() && !pho.isEmpty() && !addr.isEmpty() && !roo.isEmpty() && !bd2.isEmpty())
				{
					String query="insert into customers values(?,?,?,?,?,?);";
					PreparedStatement pst1=con.prepareStatement(query);
					pst1.setString(1,nam);
					pst1.setString(2,ema);
					pst1.setString(3,pho);
					pst1.setString(4,addr);
					pst1.setString(5,"Paid");
					pst1.setInt(6,roomnumber);
					pst1.executeUpdate();
					String qq="update rooms set available='occupied' where roomno=?;";
					PreparedStatement p=con.prepareStatement(qq);
					p.setInt(1, roomnumber);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null,"Room Confirmed. Have a Good Day!!!");
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Please fill all the datas");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
