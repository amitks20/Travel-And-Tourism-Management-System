package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{
	
	String username;
	
	JLabel lblheading,lblusername,lblshowuser,lblpackage,lblshowpackage,lblpersons,lblshowpersons,lblid,lblshowid,lblidno,lblshowidno,lblphno,lblshowphno,lbltprice,lblshowtprice,image1;
	JButton jbback;
		
	ViewPackage(String username){
		this.username=username;
		
		setBounds(350,150,850,500);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
            //heading
		    lblheading=new JLabel("View Package");
		    lblheading.setBounds(150, 0, 200, 30);
		    lblheading.setForeground(Color.BLACK);
            lblheading.setFont(new Font("Tahoma",Font.BOLD,25));
            add(lblheading);
		    
			//USERNAME
			lblusername=new JLabel("Username");
			lblusername.setBounds(40, 60, 300, 25);
			lblusername.setForeground(Color.BLACK);
			add(lblusername);
			
			lblshowuser=new JLabel("");
			lblshowuser.setBounds(240, 60, 300, 25);
			lblshowuser.setForeground(Color.BLACK);
			add(lblshowuser);

			//Package
			lblpackage=new JLabel("Package");
			lblpackage.setBounds(40, 100, 300, 25);
			lblpackage.setForeground(Color.BLACK);
			add(lblpackage);
			
			lblshowpackage=new JLabel("");
			lblshowpackage.setBounds(240, 100, 300, 25);
			lblshowpackage.setForeground(Color.BLACK);
			add(lblshowpackage);
			

			//Total Persons
			lblpersons=new JLabel("Total Persons");
			lblpersons.setBounds(40, 150, 300, 25);
			lblpersons.setForeground(Color.BLACK);
			add(lblpersons);
			
			lblshowpersons=new JLabel("");
			lblshowpersons.setBounds(240, 150, 300, 25);
			lblshowpersons.setForeground(Color.BLACK);
			add(lblshowpersons);
			
			//ID
			lblid=new JLabel("ID");
			lblid.setBounds(40, 200, 300, 25);
			lblid.setForeground(Color.BLACK);
			add(lblid);
			
			lblshowid=new JLabel("");
			lblshowid.setBounds(240, 200, 300, 25);
			lblshowid.setForeground(Color.BLACK);
			add(lblshowid);
			
			//ID
			lblidno=new JLabel("ID Number");
			lblidno.setBounds(40, 250, 300, 25);
			lblidno.setForeground(Color.BLACK);
			add(lblidno);
			
			lblshowidno=new JLabel("");
			lblshowidno.setBounds(240, 250, 300, 25);
			lblshowidno.setForeground(Color.BLACK);
			add(lblshowidno);
			
			//Phone No
			lblphno=new JLabel("Phone No.");
			lblphno.setBounds(40,300, 300, 25);
			lblphno.setForeground(Color.BLACK);
			add(lblphno);
			
			lblshowphno=new JLabel("");
			lblshowphno.setBounds(240,300, 300, 25);
			lblshowphno.setForeground(Color.BLACK);
			add(lblshowphno);
			
			//Total Price
			lbltprice=new JLabel("Total Price");
			lbltprice.setBounds(40,350, 300, 25);
			lbltprice.setForeground(Color.BLACK);
			add(lbltprice);
			
			lblshowtprice=new JLabel("");
			lblshowtprice.setBounds(240, 350, 300, 25);
			lblshowtprice.setForeground(Color.BLACK);
			add(lblshowtprice);
			
		    //BACK BUTTON
		    jbback=new JButton("BACK");
		    jbback.setBounds(120, 420, 150, 30);
		    jbback.setBackground(Color.GRAY);
		    jbback.setForeground(Color.RED);
		    jbback.addActionListener(this);
		    add(jbback);
		    
		    //IMAGE
		    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		    Image i2= i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);	
		    ImageIcon i3=new ImageIcon(i2);
		    image1=new JLabel(i3);
			image1.setBounds(300, 50, 600, 415);
		    add(image1);
		    
		    try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery("select * from bookpackage where username='"+username+"'");
				
				if(rs.next()) {
					lblshowuser.setText(rs.getString("username"));
					lblshowpackage.setText(rs.getString("package"));
					lblshowid.setText(rs.getString("id"));
					lblshowidno.setText(rs.getString("number"));
					lblshowpersons.setText(rs.getString("persons"));
					lblshowphno.setText(rs.getString("phone"));
					lblshowtprice.setText(rs.getString("price"));
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
    		new Dashboard(username);
    	}
    	
    }
	public static void main(String[] args) {
		
		new ViewPackage("");
	}

}
