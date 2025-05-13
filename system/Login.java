package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JLabel lblusername,lblpassword,lbltrouble,image;
	JTextField tfusername,tfpassword;	
	JButton login,signup,forget;

	Login(String username){
		//frame
		setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        //entire panel.background color
        getContentPane().setBackground(Color.WHITE);
      		
        //Panel1 Left Side
        JPanel p1= new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0, 0, 400 , 400);
        p1.setLayout(null);
        add (p1);        
        
        //imageicon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image= new JLabel(i3);
        image.setBounds(100,70,200,200);//left,top,length,breadth
        p1.add(image);                  //to add the image above the panel not above the frame 
        
        //Panel2 Right Side 
        JPanel p2= new JPanel();
        p2.setLayout(null);
        p2.setBounds(450,30,450,300);
        add(p2);
        
        //Username Field
        lblusername= new JLabel ("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,20));
        p2.add(lblusername);
        
        //Username Box
         tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        //Password Field
         lblpassword= new JLabel ("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("Times New Roman",Font.BOLD,20));
        p2.add(lblpassword);
        
        //Password Box
         tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        //TROUBLE SIGNIN Field
         lbltrouble= new JLabel ("Trouble Signing In..");
        lbltrouble.setBounds(230, 250, 200, 25);
        lbltrouble.setFont(new Font("Times New Roman",Font.PLAIN,17));
        lbltrouble.setForeground(Color.RED);
        p2.add(lbltrouble);
                
        //LOGIN Button
         login=new JButton("LOGIN");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        //SIGNUP Button
         signup=new JButton("SIGNUP");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        //FORGET Button
         forget=new JButton("FORGET PASSWORD");
        forget.setBounds(60,250,150,30);
        forget.setBackground(Color.ORANGE);
        forget.setForeground(Color.WHITE);
        forget.setBorder(new LineBorder(Color.ORANGE));
        forget.addActionListener(this);
        p2.add(forget);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		//LOGIN
		if(ae.getSource()==login) {
			
			try {
				String username=tfusername.getText();
				String password=tfpassword.getText();

				String query="select * from account where username='"+username+"'AND password='"+password+"'";
				
				//CONNECTION 
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Loading(username);	
				}
				else {
					
					JOptionPane.showMessageDialog(null,"Incorrect Password or Username");
				}	
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		//SIGNUP
		else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup();	
		}
		
		//FORGET PASSWORD
		else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
	new Login ("");//anonymous object

	}
}
