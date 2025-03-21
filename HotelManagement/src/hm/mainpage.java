package hm;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class mainpage  implements ActionListener{
	JButton login,register;
	JLabel label;
	JPanel panel;
	JTextField username;
	JPasswordField pass;
	JFrame frame;
	mainpage()
	{
		
		login=new JButton("Login");
		frame=new JFrame();
		panel=new JPanel();
		username=new JTextField();
		pass=new JPasswordField();
		
		username.setPreferredSize(new Dimension(150,40));
		pass.setPreferredSize(new Dimension(150,40));
		
		JLabel userlabel=new JLabel("Username");
		userlabel.setForeground(Color.white);
		JLabel passlabel=new JLabel("Password");
		passlabel.setForeground(Color.white);

		userlabel.setBounds(10,115,70,50);
		passlabel.setBounds(10,165,70,50);

	    username.setBounds(90,120,150,40);
	    username.setBorder(new EmptyBorder(0, 10, 0, 0));
	    pass.setBounds(90,170,150,40);
	    pass.setBorder(new EmptyBorder(0, 10, 0, 0));
		
	    ImageIcon image=new ImageIcon("gow.png");
	    ImageIcon image1=new ImageIcon("final-image.jpg");

	    username.addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                pass.requestFocus(); // Moves to next field
	            }
	        }
	    });
	    
	    pass.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	    			login.doClick();
	    		}
	    	}
	    });
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(image.getImage());
		frame.setTitle("Login");
		frame.setLayout(null);
		frame.setSize(500,400);
		frame.setBackground(Color.black);
		frame.setResizable(false);
	    
	    label=new JLabel();
	    label.setIcon(image1);
	    //label.setText("Hello");
	    label.setPreferredSize(new Dimension(200,200));
	    label.setBounds(270,85,200,200);
	    //panel.setPreferredSize(new Dimension(200,200));

	  
	    //panel.setBackground(Color.black);
	    
	    register=new JButton("Register");
	    register.setPreferredSize(new Dimension(100,40));
	    register.setBounds(85,220,85,30);
	    register.setBorder(null);
	    register.addActionListener(this);
	    register.setFocusable(false);
	    
	    login.setPreferredSize(new Dimension(100,40));
	    login.setBounds(175,220,70,30);
	    login.setBorder(null);
	    login.setFocusable(false);
		login.addActionListener(this);
		
		
		
		frame.getContentPane().setBackground(Color.black);
		frame.add(userlabel);
		frame.add(passlabel);
		frame.add(username);
		frame.add(pass);
	    panel.setBounds(250,80,200,200);
		panel.add(label);
		frame.add(label);
		frame.add(register);
		frame.add(login);
		frame.setVisible(true);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login)
		{
			String user=username.getText();
			char[] pa=pass.getPassword();
			String pas=new String(pa);
			//System.out.println(pas);
			try {
				Connection con=dbconnection.getConnection();
				String query="Select * from users where username=? and password=?;";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,user);
				pst.setString(2, pas);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					adminpage ob=new adminpage();
					frame.dispose();
				}
				else
				{
					System.out.println("Invalid password or username");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==register)
		{
			register ob=new register();
			//frame.dispose();
			
		}
		
	}
}
