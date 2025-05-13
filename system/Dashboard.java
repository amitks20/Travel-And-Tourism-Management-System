package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener  {
	
	JPanel p1,p2;
	JLabel lblheading,lbltext;
	JButton adddetails,updatedetails,viewdetails,deletedetails,checkpackage,bookpackage,viewpackage,checkhotels,bookhotels,bookedhotel,destinations,payments,notepad,calculator,about;
	
	String username;
	
	Dashboard(String username){
		
		this.username=username;
		
		setBounds(0,0,1600,1000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		//TOP PANEL
		 p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0,0,1600,65);
		add(p1);
		
		//HORIZONTAL PANEL
		 p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0,65,200,840);
		add(p2);
		
		//IMAGE LOGO
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel icon=new JLabel(i3);
		icon.setBounds(5, 0, 70, 70);
		p1.add(icon);
		
		//IMAGE
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5=i4.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel image=new JLabel(i6);
		image.setBounds(0, 0, 1600, 900);
		add(image);
		
		//TEXT
		lbltext=new JLabel("Travel And Tourism Management System");
		lbltext.setBounds(400, 60, 1000, 100);
		lbltext.setForeground(Color.RED);
		lbltext.setFont(new Font("Tahoma",Font.BOLD,40));
		image.add(lbltext);
		
		//DASHBOARD HEADING
		lblheading =new JLabel("Dashboard");
		lblheading.setBounds(90, 0, 200, 70);
		lblheading.setForeground(Color.WHITE);
		lblheading.setFont(new Font("Times New Roman",Font.BOLD,30));
		p1.add(lblheading);
		
		//ADD PERSOAL DETAILS
		adddetails=new JButton("Add  Details");
		adddetails.setForeground(Color.WHITE);
		adddetails.setBackground(new Color(0,0,102));
		adddetails.setFont(new Font("Tahoma",Font.PLAIN,16));
		adddetails.setBounds(0, 0, 200, 50);
		adddetails.setMargin(new Insets(0,0,0,80));//top,left,bottom,right
		adddetails.addActionListener(this);
		p2.add(adddetails);
		
		//UPDATE PERSONAL DETAILS
		updatedetails=new JButton("Update  Details");
		updatedetails.setForeground(Color.WHITE);
		updatedetails.setBackground(new Color(0,0,102));
		updatedetails.setFont(new Font("Tahoma",Font.PLAIN,16));
		updatedetails.setBounds(0, 50, 200, 50);
		updatedetails.setMargin(new Insets(0,0,0,60));//top,left,bottom,right
		updatedetails.addActionListener(this);
		p2.add(updatedetails);
		
		//VIEW PERSONAL DETAILS
		viewdetails=new JButton("View Details");
		viewdetails.setForeground(Color.WHITE);
		viewdetails.setBackground(new Color(0,0,102));
		viewdetails.setFont(new Font("Tahoma",Font.PLAIN,16));
		viewdetails.setBounds(0, 100, 200, 50);
		viewdetails.setMargin(new Insets(0,0,0,80));//top,left,bottom,right
		viewdetails.addActionListener(this);
		p2.add(viewdetails);
		
		//DELETE PERSONAL DETAILS
		deletedetails=new JButton("Delete Details");
		deletedetails.setForeground(Color.WHITE);
		deletedetails.setBackground(new Color(0,0,102));
		deletedetails.setFont(new Font("Tahoma",Font.PLAIN,16));
		deletedetails.setBounds(0, 150, 200, 50);
		deletedetails.setMargin(new Insets(0,0,0,65));//top,left,bottom,right
		deletedetails.addActionListener(this);
		p2.add(deletedetails);
		
		//CHECK PACKAGE
		checkpackage=new JButton("Check Package");
		checkpackage.setForeground(Color.WHITE);
		checkpackage.setBackground(new Color(0,0,102));
		checkpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		checkpackage.setBounds(0, 200, 200, 50);
		checkpackage.setMargin(new Insets(0,0,0,65));//top,left,bottom,right
		checkpackage.addActionListener(this);
		p2.add(checkpackage);
		
		//BOOK PACKAGE
        bookpackage=new JButton("Book Package");
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        bookpackage.setBounds(0, 250, 200, 50);
        bookpackage.setMargin(new Insets(0,0,0,70));//top,left,bottom,right
        bookpackage.addActionListener(this);
		p2.add(bookpackage);
		
		//VIEW PACKAGE
        viewpackage=new JButton("View Package");
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        viewpackage.setBounds(0, 300, 200, 50);
        viewpackage.setMargin(new Insets(0,0,0,70));//top,left,bottom,right
        viewpackage.addActionListener(this);
		p2.add(viewpackage);
        
		//VIEW HOTELS
        checkhotels=new JButton("Check Hotels");
        checkhotels.setForeground(Color.WHITE);
        checkhotels.setBackground(new Color(0,0,102));
        checkhotels.setFont(new Font("Tahoma",Font.PLAIN,16));
        checkhotels.setBounds(0, 350, 200, 50);
        checkhotels.setMargin(new Insets(0,0,0,80));//top,left,bottom,right
        checkhotels.addActionListener(this);
		p2.add(checkhotels);
		
		//BOOK HOTELS
        bookhotels=new JButton("Book Hotels");
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,16));
        bookhotels.setBounds(0, 400, 200, 50);
        bookhotels.setMargin(new Insets(0,0,0,80));//top,left,bottom,right
        bookhotels.addActionListener(this);
		p2.add(bookhotels);
        
        
		//BOOKED HOTELS
		bookedhotel=new JButton("Booked Hotels");
		bookedhotel.setForeground(Color.WHITE);
		bookedhotel.setBackground(new Color(0,0,102));
		bookedhotel.setFont(new Font("Tahoma",Font.PLAIN,16));
		bookedhotel.setBounds(0, 450, 200, 50);
		bookedhotel.setMargin(new Insets(0,0,0,60));//top,left,bottom,right
		bookedhotel.addActionListener(this);
		p2.add(bookedhotel);
		
        
		//DESTINATONS
        destinations=new JButton("Destinations");
        destinations.setForeground(Color.WHITE);
        destinations.setBackground(new Color(0,0,102));
        destinations.setFont(new Font("Tahoma",Font.PLAIN,16));
        destinations.setBounds(0, 500, 200, 50);
        destinations.setMargin(new Insets(0,0,0,70));//top,left,bottom,right
        destinations.addActionListener(this);
		p2.add(destinations);
        
		//CALCULATOR
        calculator=new JButton("Calculator");
        calculator.setForeground(Color.WHITE);
        calculator.setBackground(new Color(0,0,102));
        calculator.setFont(new Font("Tahoma",Font.PLAIN,16));
        calculator.setBounds(0, 550, 200, 50);
        calculator.setMargin(new Insets(0,0,0,90));//top,left,bottom,right
        calculator.addActionListener(this);
		p2.add(calculator);
        
		//PAYMENT METHODS
        payments=new JButton("Payments");
        payments.setForeground(Color.WHITE);
        payments.setBackground(new Color(0,0,102));
        payments.setFont(new Font("Tahoma",Font.PLAIN,16));
        payments.setBounds(0, 600, 200, 50);
        payments.setMargin(new Insets(0,0,0,90));//top,left,bottom,right
        payments.addActionListener(this);
		p2.add(payments);
        
		//NOTEPAD
        notepad=new JButton("Notepad");
        notepad.setForeground(Color.WHITE);
        notepad.setBackground(new Color(0,0,102));
        notepad.setFont(new Font("Tahoma",Font.PLAIN,16));
        notepad.setBounds(0, 650, 200, 50);
        notepad.setMargin(new Insets(0,0,0,100));//top,left,bottom,right
        notepad.addActionListener(this);
		p2.add(notepad);
        
		//ABOUT
        about=new JButton("About");
        about.setForeground(Color.WHITE);
        about.setBackground(new Color(0,0,102));
        about.setFont(new Font("Tahoma",Font.PLAIN,16));
        about.setBounds(0, 700, 200, 50);
        about.setMargin(new Insets(0,0,0,110));//top,left,bottom,right
        about.addActionListener(this);
		p2.add(about);
        
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
		
		if(ae.getSource()==adddetails) {
			new AddDetails(username);
		}else if(ae.getSource()==viewdetails) {
			new ViewDetails(username);
		}else if(ae.getSource()==updatedetails) {
			new UpdateDetails(username);
		}else if(ae.getSource()==checkpackage) {
			new CheckPackage(username);
		}else if(ae.getSource()==bookpackage) {
			new BookPackage(username);
		}else if(ae.getSource()==viewpackage) {
			new ViewPackage(username);
		}else if(ae.getSource()==checkhotels) {
			new CheckHotels(username);
		}else if(ae.getSource()==destinations) {
			new Destinations(username);		
		}else if(ae.getSource()==bookhotels) {
			new BookHotels(username);
		}
		
	}

	public static void main(String[] args) {
	
		new Dashboard("");
		

	}
	

}
