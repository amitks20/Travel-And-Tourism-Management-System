package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
	
	String username;
	
	JLabel lblheading,lblusername,lblshowuser,lblpackage,lbltpersons,lblid,lblshowid,lblnumber,lblshownumber,lblphno,lblshowphno,lbltprice,lblshowtprice;
	JTextField tfusername,tfid,tfnumber,tfphno,tfpersons,tfprice;
	Choice chpackage;
	JButton jbprice,jbbook,jbback;
	
	BookPackage(String username){
		this.username=username;
		
		setBounds(350,200,900,550);
		getContentPane().setBackground(new Color(215,215,215));
		setLayout(null);
		
		//heading
		lblheading =new JLabel("Book Package");
		lblheading.setBounds(300, 0, 300, 30);
		lblheading.setForeground(Color.DARK_GRAY);
		lblheading.setFont(new Font("Tahoma",Font.BOLD,30));
		add(lblheading);
		
		//username
		lblusername=new JLabel("Username");
		lblusername.setBounds(30,50,150,25);
		add(lblusername);
		
		lblshowuser=new JLabel("");
		lblshowuser.setBounds(180,50,150,25);
		add(lblshowuser);
		
		
		//package selection
		lblpackage=new JLabel("Select Package");
		lblpackage.setBounds(30, 100, 150, 25);
		add(lblpackage);
		
		chpackage=new Choice();
		chpackage.add("Gold Package");
		chpackage.add("Silver Package");
		chpackage.add("Bronze Package");
		chpackage.setBounds(180, 100, 150, 25);
		chpackage.setBackground(Color.WHITE);
		add(chpackage);
		
		//total persons
		lbltpersons=new JLabel("Total Persons");
		lbltpersons.setBounds(30, 150, 150, 25);
		add(lbltpersons);
		
		tfpersons=new JTextField();
		tfpersons.setBounds(180, 150, 150, 25);
		tfpersons.setBorder(null);
		add(tfpersons);
		
		//id
		lblid=new JLabel("ID");
		lblid.setBounds(30, 200, 150, 25);
		add(lblid);
		
		lblshowid=new JLabel("");
		lblshowid.setBounds(180, 200, 150, 25);
		add(lblshowid);
		
		//id number
		lblnumber=new JLabel("Number");
		lblnumber.setBounds(30, 250, 150, 25);
		add(lblnumber);
		
		lblshownumber=new JLabel("");
		lblshownumber.setBounds(180, 250, 150, 25);
		add(lblshownumber);
		
		// phone no
		lblphno=new JLabel("Phone No");
		lblphno.setBounds(30, 300, 150, 25);
		add(lblphno);
		
		lblshowphno=new JLabel("");
		lblshowphno.setBounds(180, 300, 150, 25);
		add(lblshowphno);
		
		//total price
		lbltprice=new JLabel("Total Price");
		lbltprice.setBounds(30, 350, 150, 25);
		add(lbltprice);
		
		lblshowtprice=new JLabel("");
		lblshowtprice.setBounds(180, 350, 150, 25);
		add(lblshowtprice);
		
		//check price
		jbprice=new JButton("Check Price");
		jbprice.setBounds(80, 400, 150, 30);
		jbprice.setBackground(Color.DARK_GRAY);
		jbprice.setForeground(Color.ORANGE);
		jbprice.setFont(new Font("Tahoma",Font.BOLD,14));
		jbprice.addActionListener(this);
		add(jbprice);
		
		//book price
		jbbook=new JButton("Book Package");
		jbbook.setBounds(300, 400, 150, 30);
		jbbook.setBackground(Color.DARK_GRAY);
		jbbook.setForeground(Color.GREEN);
		jbbook.setFont(new Font("Tahoma",Font.BOLD,14));
		jbbook.addActionListener(this);
		add(jbbook);
		
		//back price
		jbback=new JButton("Back");
		jbback.setBounds(180, 460, 150, 30);
		jbback.setBackground(Color.DARK_GRAY);
		jbback.setForeground(Color.RED);
		jbback.setFont(new Font("Tahoma",Font.BOLD,14));
		jbback.addActionListener(this);
		add(jbback);
		
		//CLOSES THE EXECUTION
	    addWindowListener(new WindowAdapter() {
	    	@Override
             public void windowClosing(WindowEvent e) {
	               System.exit(0);
	            }
	        });

		//imageicon
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
	    Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel icon =new JLabel(i3);
	    icon.setBounds(480, 50, 380, 350);
	    add(icon);
	    
	    try {
	    	Conn c=new Conn();
	    	String query="select * from customer where username='"+username+"'";
	    	ResultSet rs=c.s.executeQuery(query);
	    	while(rs.next()) {
	    		lblshowuser.setText(rs.getString("username"));
	    		lblshowid.setText(rs.getString("id"));
	    		lblshownumber.setText(rs.getString("number"));
	    		lblshowphno.setText(rs.getString("phone"));
	    	}
	    
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==jbprice) {
			String pack=chpackage.getSelectedItem();
			int cost=0;
			if(pack.equals("Gold Package")) {
				cost+=15000;	
			}else if(pack.equals("Silver Package")) {
				cost+=10000;	
			}else {
				cost+=7000;
			}
			
			int persons=Integer.parseInt(tfpersons.getText());
			cost*=persons;
			lblshowtprice.setText("Rs "+cost+"/-");
			
		}else if(ae.getSource()==jbbook) {
			try {
				Conn c=new Conn();
				c.s.executeUpdate("insert into bookpackage values('"+lblshowuser.getText()+"','"+chpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+lblshowid.getText()+"','"+lblshownumber.getText()+"','"+lblshowphno.getText()+"','"+lblshowtprice.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				
				setVisible(false);
				
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}else {
			setVisible(false);
			new Dashboard(username);
			
		}
	}

	public static void main(String[] args) {
		new BookPackage("");
		
	}

}
