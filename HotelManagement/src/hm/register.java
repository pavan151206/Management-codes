package hm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class register implements ActionListener {
	JFrame frame;
	JLabel label;
	JTextField username,email,phone;
	JPasswordField pass;
	JPanel panel,panel1;
	JButton submit;
	register()
	{
		frame=new JFrame("Registration");
		ImageIcon image=new ImageIcon("gow.png");
		frame.setIconImage(image.getImage());
		username=new JTextField();
		email=new JTextField();
		phone=new JTextField();
		pass=new JPasswordField();
		
		username.setPreferredSize(new Dimension(150,40));
		email.setPreferredSize(new Dimension(150,40));
		phone.setPreferredSize(new Dimension(150,40));
		pass.setPreferredSize(new Dimension(150,40));
		label=new JLabel();
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,1,10,10));
		panel.add(username);
		panel.add(email);
		panel.add(phone);
		panel.add(pass);
		
		panel.setBounds(190,90,150,150);
		
		JLabel label1=new JLabel("Username :");
		JLabel label2=new JLabel("Email :");
		JLabel label3=new JLabel("Phonenumber :");
		JLabel label4=new JLabel("Password :");
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(4,1,10,10));
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.setBounds(100,90,90,150);
		
		submit=new JButton("submit");
		submit.setPreferredSize(new Dimension(90,40));
		submit.setFocusable(false);
		submit.setBorder(null);
		submit.setBounds(200,250,110,30);
		submit.addActionListener(this);
		
		frame.setSize(500,400);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(panel1);
		frame.add(panel);
		frame.add(submit);
		frame.setLayout(null);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit)
		{
			String user=username.getText();
			String ema=email.getText();
			String pho=phone.getText();
			char []pa=pass.getPassword();
			String pass=new String(pa);
			try {
				Connection con=dbconnection.getConnection();
				String query="insert into users values(?,?,?,?);";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, user);
				pst.setString(2, pass);
				pst.setString(3, ema);
				pst.setString(4, pho);
				pst.executeUpdate();
				frame.dispose();
				return;

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
