package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDetails extends JFrame implements ActionListener{
			
		JLabel lbluser,lblshowuser,lblid,lblidno,lblname,lblshowname,lblgender,lblcountry,lbladdress,lblemail,lblphno,image;
		JTextField tfidno,tfcountry,tfaddress,tfemail,tfphno;
		JRadioButton jrbmale,jrbfemale;
		ButtonGroup gender;
		JComboBox comboid;
		JButton jbadd,jbback;
		
		String username;
		
	AddDetails(String username){
		
		this.username=username;

		setBounds(350,150,850,550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//USERNAME
		lbluser=new JLabel("Username");
		lbluser.setForeground(Color.GRAY);
		lbluser.setBounds(30,40,150,25);
		add(lbluser);
		
		//SHOW USERNAME
		lblshowuser=new JLabel("");
		lblshowuser.setForeground(Color.GRAY);
		lblshowuser.setBounds(180,40,150,25);
		add(lblshowuser);
		
		//ID
		lblid=new JLabel("ID");
		lblid.setForeground(Color.GRAY);
		lblid.setBounds(30,80,150,25);
		add(lblid);
		
		//DROWPDOWN WITH JCOMBOBOX
		comboid=new JComboBox(new String[] {"Aadhar Card","PAN Card","Passport","Ration Card","Voter ID Card","Driving Liscence","POI Card"});
		comboid.setBounds(180,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
				
		//ID NUMBER
		lblidno =new JLabel("Number");
		lblidno.setBounds(30, 120, 150, 25);
		lblidno.setForeground(Color.GRAY);
		add(lblidno);
		
		//TEXTFIELD IDNO.
		tfidno=new JTextField();
		tfidno.setBounds(180, 120, 150, 30);
		add(tfidno);
		
		//NAME
		lblname=new JLabel("Name");
		lblname.setForeground(Color.GRAY);
		lblname.setBounds(30,160,150,25);
		add(lblname);
		
		//SHOW USERNAME
		lblshowname=new JLabel("");
		lblshowname.setForeground(Color.GRAY);
		lblshowname.setBounds(180,160,150,25);
		add(lblshowname);
		
		//GENDER
		lblgender=new JLabel("Gender");
		lblgender.setForeground(Color.GRAY);
		lblgender.setBounds(30,200,150,25);
		add(lblgender);
		
		//RADIO BUTTON
		//Male
        jrbmale=new JRadioButton("Male");
        jrbmale.setBounds(180, 200, 60, 25);
        jrbmale.setBackground(Color.WHITE);
        add(jrbmale);
        //Female
        jrbfemale=new JRadioButton("Female");
        jrbfemale.setBounds(240, 200, 70, 25);
        jrbfemale.setBackground(Color.WHITE);
        add(jrbfemale);
        //ButtonGroup
        gender =new ButtonGroup();
        gender.add(jrbmale);
        gender.add(jrbfemale);
        
		//COUNTRY
        lblcountry =new JLabel("Country");
        lblcountry.setBounds(30, 240, 150, 25);
        lblcountry.setForeground(Color.GRAY);
		add(lblcountry);
		
		//TEXTFIELD COUNTRY
		tfcountry=new JTextField();
		tfcountry.setBounds(180, 240, 150, 30);
		add(tfcountry);
		
		//ADDRESS
        lbladdress =new JLabel("Address");
        lbladdress.setBounds(30, 280, 150, 25);
        lbladdress.setForeground(Color.GRAY);
		add(lbladdress);
		
		//TEXTFIELD ADDRESS
		tfaddress=new JTextField();
		tfaddress.setBounds(180, 280, 150, 30);
		add(tfaddress);
		
		//EMAIL
		lblemail =new JLabel("E-Mail");
		lblemail.setBounds(30, 320, 150, 25);
		lblemail.setForeground(Color.GRAY);
		add(lblemail);
		
		//TEXTFIELD EMAIL
		tfemail=new JTextField();
		tfemail.setBounds(180, 320, 150, 30);
		add(tfemail);
		
		//ADDRESS
        lblphno =new JLabel("Phone No.");
        lblphno.setBounds(30, 360, 150, 25);
        lblphno.setForeground(Color.GRAY);
		add(lblphno);
		
		//TEXTFIELD ADDRESS
		tfphno=new JTextField();
		tfphno.setBounds(180, 360, 150, 30);
		add(tfphno);
		
		//BUTTON ADD
		jbadd=new JButton("ADD");
		jbadd.setBounds(130, 420, 100, 25);
		jbadd.setForeground(Color.GREEN);
		jbadd.setBackground(Color.GRAY);
		jbadd.addActionListener(this);
		add(jbadd);
		
		//BUTTON BACK
		jbback=new JButton("BACK");
		jbback.setBounds(270, 420, 100, 25);
		jbback.setForeground(Color.RED);
		jbback.setBackground(Color.GRAY);
		jbback.addActionListener(this);
		add(jbback);
		
		//IMAGE RI8 SIDE
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2=i1.getImage().getScaledInstance(450, 700, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(400,20,350,550);
		add(image);
		
		try {
			
			Conn c=new Conn();
			ResultSet rs1=c.s.executeQuery("select * from account where username='"+username+"'");
			while(rs1.next()) {
				lblshowuser.setText(rs1.getString("username"));
				lblshowname.setText(rs1.getString("name"));
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
		
		if(ae.getSource() == jbadd) {
			
			String username=lblshowuser.getText();
			String id=(String)comboid.getSelectedItem();
			String number=tfidno.getText();
			String name=lblshowname.getText();
			String gender=null;
			
			if(jrbmale.isSelected()) {
				gender="Male";
			} else {
				gender="Female";
			}
			
			String country=tfcountry.getText();
			String address=tfaddress.getText();
			String phone=tfphno.getText();
			String email=tfemail.getText();
			
			try {
				
				Conn c=new Conn();
				
				String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Details Added Successfully!!");
				
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

              new AddDetails("");
	}

}
