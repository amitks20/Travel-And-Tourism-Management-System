package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class ViewDetails extends JFrame implements ActionListener{
	
	JLabel lblusername,lblshowuser,lblname,lblshowname,lblid,lblshowid,lblidno,lblshowidno,lblgender,lblshowgender,lblcountry,lblshowcountry,lbladdress,lblshowaddress,lblphno,lblshowphno,lblemail,lblshowemail,image1,image2;
	JButton jbback;
	
	
    String username;
	
	ViewDetails(String username){
		this.username=username;
		
		setBounds(350,150,850,650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//USERNAME
		lblusername=new JLabel("Username");
		lblusername.setBounds(40, 50, 300, 25);
		lblusername.setForeground(Color.BLACK);
		add(lblusername);
		
		lblshowuser=new JLabel("");
		lblshowuser.setBounds(240, 50, 300, 25);
		lblshowuser.setForeground(Color.BLACK);
		add(lblshowuser);
		
		//NAME
		lblname=new JLabel("Name");
		lblname.setBounds(40, 100, 300, 25);
		lblname.setForeground(Color.BLACK);
		add(lblname);
		
		lblshowname=new JLabel("");
		lblshowname.setBounds(240, 100, 300, 25);
		lblshowname.setForeground(Color.BLACK);
		add(lblshowname);

		//ID
		lblid=new JLabel("ID ");
		lblid.setBounds(40, 150, 300, 25);
		lblid.setForeground(Color.BLACK);
		add(lblid);
		
		lblshowid=new JLabel("");
		lblshowid.setBounds(240, 150, 300, 25);
		lblshowid.setForeground(Color.BLACK);
		add(lblshowid);
		

		//ID NUMBER
		lblidno=new JLabel("ID No.");
		lblidno.setBounds(40, 200, 300, 25);
		lblidno.setForeground(Color.BLACK);
		add(lblidno);
		
		lblshowidno=new JLabel("");
		lblshowidno.setBounds(240, 200, 300, 25);
		lblshowidno.setForeground(Color.BLACK);
		add(lblshowidno);
		
		//GENDER
		lblgender=new JLabel("Gender");
		lblgender.setBounds(40, 250, 300, 25);
		lblgender.setForeground(Color.BLACK);
		add(lblgender);
		
		lblshowgender=new JLabel("");
		lblshowgender.setBounds(240, 250, 300, 25);
		lblshowgender.setForeground(Color.BLACK);
		add(lblshowgender);
		
		//COUNTRY
		lblcountry=new JLabel("Country");
		lblcountry.setBounds(500,50, 300, 25);
		lblcountry.setForeground(Color.BLACK);
		add(lblcountry);
		
		lblshowcountry=new JLabel("");
		lblshowcountry.setBounds(660, 50, 300, 25);
		lblshowcountry.setForeground(Color.BLACK);
		add(lblshowcountry);
		
		//ADDRESS
		lbladdress=new JLabel("Address");
		lbladdress.setBounds(500,100, 300, 25);
		lbladdress.setForeground(Color.BLACK);
		add(lbladdress);
		
		lblshowaddress=new JLabel("");
		lblshowaddress.setBounds(660, 100, 300, 25);
		lblshowaddress.setForeground(Color.BLACK);
		add(lblshowaddress);
		
		//PHONE
		lblphno=new JLabel("Phone No.");
		lblphno.setBounds(500, 150, 300, 25);
		lblphno.setForeground(Color.BLACK);
		add(lblphno);
		
		lblshowphno=new JLabel("");
		lblshowphno.setBounds(660, 150, 300, 25);
		lblshowphno.setForeground(Color.BLACK);
		add(lblshowphno);
		
		//EMAIL
		lblemail=new JLabel("E-Mail");
		lblemail.setBounds(500, 200, 300, 25);
		lblemail.setForeground(Color.BLACK);
	    add(lblemail);
		
		lblshowemail=new JLabel("");
		lblshowemail.setBounds(660, 200, 300, 25);
		lblshowemail.setForeground(Color.BLACK);
	    add(lblshowemail);
		
	    //BACK BUTTON
	    jbback=new JButton("BACK");
	    jbback.setBounds(320, 350, 150, 30);
	    jbback.setBackground(Color.GRAY);
	    jbback.setForeground(Color.RED);
	    jbback.addActionListener(this);
	    add(jbback);
	    
	    //IMAGE
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
	    Image i2= i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);	
	    ImageIcon i3=new ImageIcon(i2);
	    image1=new JLabel(i3);
		image1.setBounds(0, 400, 600, 200);
		add(image1);
		//IMAGE DUPICATE
	    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
	    Image i5= i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);	
	    ImageIcon i6=new ImageIcon(i2);
	    image2=new JLabel(i3);
		image2.setBounds(580, 400, 600, 200);
		add(image2);
	    
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
			
			if(rs.next()) {
				lblshowuser.setText(rs.getString("username"));
				lblshowname.setText(rs.getString("name"));
				lblshowid.setText(rs.getString("id"));
				lblshowidno.setText(rs.getString("number"));
				lblshowgender.setText(rs.getString("gender"));
				lblshowcountry.setText(rs.getString("country"));
				lblshowaddress.setText(rs.getString("address"));
				lblshowphno.setText(rs.getString("phone"));
				lblshowemail.setText(rs.getString("email"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
		//CLOSES THE EXECUTION
	    addWindowListener(new WindowAdapter() {
	    	@Override
             public void windowClosing(WindowEvent e) {
	               System.exit(0);
	            }
	        });

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==jbback) {
			 
			setVisible(false);
		}
		
		
	}
	
	public static void main(String[] args) {
		new ViewDetails("");

	}

}
