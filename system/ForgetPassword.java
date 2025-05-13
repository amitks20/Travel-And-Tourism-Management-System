package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class ForgetPassword extends JFrame implements ActionListener {
	
	JLabel lblusername,lblname,lblsecurity,lblanswer,lblpassword;
	JTextField tfusername,tfname,tfsecurity,tfanswer,tfpassword;
	JButton search,retrive,back;

	
    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        // Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
    	//USERNAME
	    lblusername=new JLabel("Username");
		lblusername.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblusername.setBounds(30, 10, 125, 25);
		p1.add(lblusername);//to add above panel
		
		tfusername=new JTextField();
		tfusername.setBounds(170,10,200,25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
  
		//NAME
	    lblname=new JLabel("Name");
	    lblname.setFont(new Font("Times New Roman",Font.BOLD,15));
	    lblname.setBounds(30, 90, 125, 25);
		p1.add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(170,90,200,25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		//SERUCRITY QUESTION
	    lblsecurity=new JLabel("Security Question");
		lblsecurity.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblsecurity.setBounds(30, 130, 120, 25);
		p1.add(lblsecurity);
				
		tfsecurity=new JTextField();
		tfsecurity.setBounds(170,130,200,25);
		tfsecurity.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfsecurity);
		
		//SERUCRITY ANSWER
		lblanswer=new JLabel("Security Answer");
		lblanswer.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblanswer.setBounds(30, 170, 120, 25);
		p1.add(lblanswer);
				
		tfanswer=new JTextField();
		tfanswer.setBounds(170,170,200,25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		//NAME
		lblpassword=new JLabel("Password");
		lblpassword.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblpassword.setBounds(30, 210, 125, 25);
		p1.add(lblpassword);
		
		tfpassword=new JTextField();
		tfpassword.setBounds(170,210,200,25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		 
		//SEARCH BUTTON
		search =new JButton("Search");
		search.setBackground(Color.GRAY);
		search.setForeground(Color.YELLOW);
		search.setBounds(210,50,100,25);
		search.addActionListener(this);
		p1.add(search);
		
		//RETRIVE BUTTON
		retrive =new JButton("Retrive");
		retrive.setBackground(Color.GRAY);
		retrive.setForeground(Color.GREEN);
		retrive.setBounds(380,170,100,25);
		retrive.addActionListener(this);
		p1.add(retrive);
		
		
		//BACK BUTTON
		back =new JButton("Back");
		back.setBackground(Color.GRAY);
		back.setForeground(Color.BLUE);
		back.setBounds(200,250,100,25);
		back.addActionListener(this);
		p1.add(back);
		
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

		
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	
    	//SEARCH BUTTON
    	if(ae.getSource()==search) {
    		
			
			String query="select * from account where username='"+tfusername.getText()+"'";
    		
    		try {

    			Conn c=new Conn();
    			
    			ResultSet rs=c.s.executeQuery(query);
    			
    			while(rs.next()) {
    				tfname.setText(rs.getString("name"));
    				tfsecurity.setText(rs.getString("security"));
    			}
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}
    	
    	//RETRIEVE BUTTON
    	else if(ae.getSource()==retrive) {
    		//"'"++"'"
    		String query="select * from account where answer='"+tfanswer.getText()+"'AND USERNAME='"+tfusername.getText()+"'";
    		
    		try {

    			Conn c=new Conn();
    			
    			ResultSet rs=c.s.executeQuery(query);
    			
    			while(rs.next()) {
    				tfpassword.setText(rs.getString("password"));
    			}
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}
    	
    	//BACK BUTTON
    	else {
    		setVisible(false);
    		new Login("");
    	}
    	
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
