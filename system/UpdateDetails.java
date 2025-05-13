package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateDetails extends JFrame implements ActionListener{
			
		JLabel heading,lbluser,lblshowuser,lblid,lblidno,lblname,lblshowname,lblgender,lblcountry,lbladdress,lblemail,lblphno,image;
		JTextField tfid,tfidno,tfgender,tfcountry,tfaddress,tfemail,tfphno;
		JButton jbupdate,jbback;
		
		String username;
		
	UpdateDetails(String username){
		
		this.username=username;

		setBounds(350,200,850,550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//HEADING
		heading =new JLabel("Update Details");
		heading.setBounds(300, 10, 200, 30);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		
		//USERNAME
		lbluser=new JLabel("Username");
		lbluser.setForeground(Color.GRAY);
		lbluser.setBounds(30,40,200,25);
		add(lbluser);
		
		//SHOW USERNAME
		lblshowuser=new JLabel("");
		lblshowuser.setForeground(Color.GRAY);
		lblshowuser.setBounds(180,40,200,25);
		add(lblshowuser);
				
		//NAME
		lblname=new JLabel("Name");
		lblname.setForeground(Color.GRAY);
		lblname.setBounds(30,80,200,25);
		add(lblname);
		
		//SHOW USERNAME
		lblshowname=new JLabel("");
		lblshowname.setForeground(Color.GRAY);
		lblshowname.setBounds(180,80,200,25);
		add(lblshowname);
		
		//ID
		lblid=new JLabel("ID");
		lblid.setForeground(Color.GRAY);
		lblid.setBounds(30,120,200,25);
		add(lblid);
		
		//TEXT FIELD ID
		tfid=new JTextField();
		tfid.setBounds(180, 120, 200, 25);
		add(tfid);
				
		//ID NUMBER
		lblidno =new JLabel("Number");
		lblidno.setBounds(30, 160, 200, 25);
		lblidno.setForeground(Color.GRAY);
		add(lblidno);
		
		//TEXTFIELD IDNO.
		tfidno=new JTextField();
		tfidno.setBounds(180, 160, 200, 30);
		add(tfidno);

		//GENDER
		lblgender=new JLabel("Gender");
		lblgender.setForeground(Color.GRAY);
		lblgender.setBounds(30,200,200,25);
		add(lblgender);
		
        //TEXT FIELD GENDER
		tfgender=new JTextField();
		tfgender.setBounds(180, 200, 200, 25);
		add(tfgender);
        
		//COUNTRY
        lblcountry =new JLabel("Country");
        lblcountry.setBounds(30, 240, 200, 25);
        lblcountry.setForeground(Color.GRAY);
		add(lblcountry);
		
		//TEXTFIELD COUNTRY
		tfcountry=new JTextField();
		tfcountry.setBounds(180, 240, 200, 30);
		add(tfcountry);
		
		//ADDRESS
        lbladdress =new JLabel("Address");
        lbladdress.setBounds(30, 280, 200, 25);
        lbladdress.setForeground(Color.GRAY);
		add(lbladdress);
		
		//TEXTFIELD ADDRESS
		tfaddress=new JTextField();
		tfaddress.setBounds(180, 280, 200, 30);
		add(tfaddress);
		
		//EMAIL
		lblemail =new JLabel("E-Mail");
		lblemail.setBounds(30, 320, 200, 25);
		lblemail.setForeground(Color.GRAY);
		add(lblemail);
		
		//TEXTFIELD EMAIL
		tfemail=new JTextField();
		tfemail.setBounds(180, 320, 200, 30);
		add(tfemail);
		
		//ADDRESS
        lblphno =new JLabel("Phone No.");
        lblphno.setBounds(30, 360, 200, 25);
        lblphno.setForeground(Color.GRAY);
		add(lblphno);
		
		//TEXTFIELD ADDRESS
		tfphno=new JTextField();
		tfphno.setBounds(180, 360, 200, 30);
		add(tfphno);
		
		//BUTTON UPDATE
		jbupdate=new JButton("UPDATE");
		jbupdate.setBounds(40, 420, 150, 25);
		jbupdate.setForeground(Color.ORANGE);
		jbupdate.setBackground(Color.GRAY);
		jbupdate.addActionListener(this);
		add(jbupdate);
        
		//BUTTON BACK
		jbback=new JButton("BACK");
		jbback.setBounds(230, 420, 150, 25);
		jbback.setForeground(Color.RED);
		jbback.setBackground(Color.GRAY);
		jbback.addActionListener(this);
		add(jbback);

		//IMAGE RI8 SIDE
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2=i1.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(450,-10,350,550);
		add(image);
		
		try {
			
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
			while(rs.next()) {
				lblshowuser.setText(rs.getString("username"));
				lblshowname.setText(rs.getString("name"));
				tfid.setText(rs.getString("id"));
				tfidno.setText(rs.getString("number"));
				tfgender.setText(rs.getString("gender"));
				tfcountry.setText(rs.getString("country"));
				tfaddress.setText(rs.getString("address"));
				tfphno.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));	
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			setVisible(true);
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
		
		if(ae.getSource() == jbupdate) {
			
			String username=lblshowuser.getText();
			String id=tfid.getText();
			String number=tfidno.getText();
			String name=lblshowname.getText();
			String gender=tfgender.getText();
			String country=tfcountry.getText();
			String address=tfaddress.getText();
			String phone=tfphno.getText();
			String email=tfemail.getText();
			
			try {
				
				Conn c=new Conn();
				
				String query="update customer set id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"' where username='"+username+"'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Details Updated Successfully!!");
				
				setVisible(false);
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
		
	}

	public static void main(String[] args) {

              new UpdateDetails("Debi89");
	}

}
