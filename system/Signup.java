package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
         
	JButton create,back;
	JTextField tfusername,tfname,tfpassword,tfanswer;
	Choice security;
	
	Signup(){
		setBounds(350,200,900,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		  
		JPanel p1= new JPanel();
		p1.setBackground(new Color(133,193,233));
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);
		
		//USERNAME
		JLabel lblusername=new JLabel("Username");
		lblusername.setFont(new Font("Times New Roman",Font.BOLD,17));
		lblusername.setBounds(30, 20, 125, 25);
		p1.add(lblusername);
		
		 tfusername=new JTextField();
		tfusername.setBounds(170,20,200,25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
		
		//NAME
		JLabel lblname=new JLabel("Name");
		lblname.setFont(new Font("Times New Roman",Font.BOLD,17));
		lblname.setBounds(30, 70, 125, 25);
		p1.add(lblname);
		
		 tfname=new JTextField();
		tfname.setBounds(170,70,200,25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		//PASSWORD
		JLabel lblpassword=new JLabel("Password");
		lblpassword.setFont(new Font("Times New Roman",Font.BOLD,17));
		lblpassword.setBounds(30, 120, 125, 25);
		p1.add(lblpassword);
				
		 tfpassword=new JTextField();
		tfpassword.setBounds(170,120,200,25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		//SERUCRITY QUESTION--(DROPDOWN)
		JLabel lblsecurity=new JLabel("Security Question");
		lblsecurity.setFont(new Font("Times New Roman",Font.BOLD,17));
		lblsecurity.setBounds(30, 170, 140, 25);
		p1.add(lblsecurity);
				
		 security =new Choice();
		security.add("Nick Name");
		security.add("Favorite Teacher");
		security.add("Pet Name");
		security.add("Favorite Bike Name");
		security.add("Your Horoscope Symbol");
		security.setBounds(170,170,200,25);
		p1.add(security);
		
		//SECURITY ANSWER
		JLabel lblanswer=new JLabel("Answer");
		lblanswer.setFont(new Font("Times New Roman",Font.BOLD,17));
		lblanswer.setBounds(30, 220, 125, 25);
		p1.add(lblanswer);
				
		tfanswer=new JTextField();
		tfanswer.setBounds(170,220,200,25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		//CREATE BUTTON
         create =new JButton("CREATE");
        create.setForeground(Color.GREEN);
        create.setBackground(Color.GRAY);
        create.setFont(new Font("Times New Roman",Font.BOLD,15));
        create.setBounds(80,270,100,30);
        create.addActionListener(this);
        p1.add(create);
        
    	//BACK BUTTON
        back =new JButton("BACK");
        back.setForeground(Color.BLUE);
        back.setBackground(Color.GRAY);
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setBounds(240,270,100,30);
        back.addActionListener(this);
        p1.add(back);
		
        //imageicon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(580,50,250,250);//left,top,
        add(image);   
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		//CREATE BUTTON
		if(ae.getSource()==create) {
			
			String username=tfusername.getText();
			String name=tfname.getText();
			String password=tfpassword.getText();
			String question=security.getSelectedItem();
			String answer =tfanswer.getText();
			
			String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
			try {
				Conn c =new Conn(); 
			   c.s.executeUpdate(query);	//close it (optional)
			   
			   JOptionPane.showMessageDialog(null,"Account Created Successfully");
			   
			   setVisible(false);
			   
			   new Login("");
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			
		}
		
		//BACK BUTTON    if (ae.getSource()==back)
		else {
			
			setVisible(false);
			new Login("");
		}
	}
	
	public static void main(String[] args) {
		
		new Signup();
	}

}
