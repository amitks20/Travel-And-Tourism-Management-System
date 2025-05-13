package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class BookHotels extends JFrame implements ActionListener {

	String username;
	
	JLabel lblheading,lblusername,lblshowusername,lblhotel,lbltpersons,lbldays,lblac,lblfood,lblid,lblshowid,lblidno,lblshowidno,lblphno,lblshowphno,lbltprice,lblshowtprice;
	JTextField tftpersons,tfdays;
	JComboBox jcbhotel,jcbac,jcbfood;
	JButton jbprice,jbbook,jbback;
	JRadioButton rbac,rbfood;
	
	
	BookHotels(String username){
		
		this.username=username;
		
		setBounds(330,150,900,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//heading
		lblheading=new JLabel("BOOK HOTEL");
		lblheading.setBounds(330,10,400,40);
		lblheading.setFont(new Font("Tahoma",Font.BOLD,25));
		add(lblheading);
		
		//username
		lblusername=new JLabel("Username");
		lblusername.setBounds(30,80,130,25);
		lblusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblusername);
		
		//show username
		lblshowusername=new JLabel("Username");
		lblshowusername.setBounds(240,80,130,25);
		lblshowusername.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblshowusername);
		
		//hotels
		lblhotel=new JLabel("Hotels");
		lblhotel.setBounds(30,120,130,25);
		lblhotel.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblhotel);
		
        //combobox hotels
		jcbhotel = new JComboBox(new String[] {"River View", "East Side", "Casterly Rock", "Urban Den", "Modern Hut", "Skyline Hotel", "Paradise Resort", "Ocean Pearl", "Majestic Stay", "Sunrise Inn"});
        jcbhotel.setBackground(Color.LIGHT_GRAY);
        jcbhotel.setBounds(240, 120, 200, 25);
        jcbhotel.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(jcbhotel);
		
		//totalpersons
		lbltpersons=new JLabel("Total Persons");
		lbltpersons.setBounds(30,160,130,25);
		lbltpersons.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lbltpersons);
		
		//textfiled totalpersons
		tftpersons=new JTextField();
		tftpersons.setBounds(240,160,200,25);
		tftpersons.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(tftpersons);
		
		//no. of days
		lbldays=new JLabel("No. of Days");
		lbldays.setBounds(30,200,130,25);
		lbldays.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lbldays);
		
		//textfiled totalpersons
		tfdays=new JTextField();
		tfdays.setBounds(240,200,200,25);
		tfdays.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(tfdays);
		
		//ac
		lblac=new JLabel("AC/Non-AC");
		lblac.setBounds(30,240,130,25);
		lblac.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblac);
		
		//combobox ac
		jcbac = new JComboBox(new String[] {"Yes","No"});
		jcbac.setBackground(Color.LIGHT_GRAY);
		jcbac.setBounds(240, 240, 200, 25);
		jcbac.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(jcbac);
		
		//food
		lblfood=new JLabel("Food Included");
		lblfood.setBounds(30,280,130,25);
		lblfood.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblfood);
		
		//combobox food
		jcbfood = new JComboBox(new String[] {"Yes","No"});
		jcbfood.setBackground(Color.LIGHT_GRAY);
		jcbfood.setBounds(240,280,200,25);
		jcbfood.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(jcbfood);
		
		//id
		lblid=new JLabel("ID");
		lblid.setBounds(30,320,130,25);
		lblid.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblid);
		
		//show id
		lblshowid=new JLabel("ID");
		lblshowid.setBounds(240,320,130,25);
		lblshowid.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblshowid);
		
		//id number
		lblidno=new JLabel("ID Number");
		lblidno.setBounds(30,360,130,25);
		lblidno.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblidno);
		
		//show id number
		lblidno=new JLabel("ID Number");
		lblidno.setBounds(240,360,130,25);
		lblidno.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblidno);
		
		//phone no
		lblphno=new JLabel("Phone No.");
		lblphno.setBounds(30,400,130,25);
		lblphno.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblphno);
		
		//show phone no
		lblphno=new JLabel("Phone No.");
		lblphno.setBounds(240,400,130,25);
		lblphno.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblphno);
		
		//total price 
		lbltprice=new JLabel("Total Price");
		lbltprice.setBounds(30,440,130,25);
		lbltprice.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lbltprice);
		
		//show total price 
		lblshowtprice=new JLabel("Total Price");
		lblshowtprice.setBounds(240,440,130,25);
		lblshowtprice.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(lblshowtprice);
		
		//check price
		jbprice=new JButton("Check Price");
		jbprice.setBounds(80, 480, 150, 30);
		jbprice.setBackground(Color.DARK_GRAY);
		jbprice.setForeground(Color.ORANGE);
		jbprice.setFont(new Font("Tahoma",Font.BOLD,14));
		jbprice.addActionListener(this);
		add(jbprice);
		
		//book price
		jbbook=new JButton("Book Hotel");
		jbbook.setBounds(300, 480, 150, 30);
		jbbook.setBackground(Color.DARK_GRAY);
		jbbook.setForeground(Color.GREEN);
		jbbook.setFont(new Font("Tahoma",Font.BOLD,14));
		jbbook.addActionListener(this);
		add(jbbook);
		
		//back price
		jbback=new JButton("Back");
		jbback.setBounds(180, 520, 150, 30);
		jbback.setBackground(Color.DARK_GRAY);
		jbback.setForeground(Color.RED);
		jbback.setFont(new Font("Tahoma",Font.BOLD,14));
		jbback.addActionListener(this);
		add(jbback);
		
		//imageicon
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2=i1.getImage().getScaledInstance(430, 650, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 80, 520, 400);
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
		
	}
	
	public static void main(String[] args) {
                     
		 new BookHotels("");

	}

}
