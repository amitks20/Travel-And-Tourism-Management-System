package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CheckPackage extends JFrame implements ActionListener{
	
	String username;
	
	JLabel lblghead,lblgday,lblgairport,lblgtour,lblgbuffet,lblgdrinks,lblgislands,lblgguide,lblgoffer,lblgprice;
	JPanel p1,p2,p3;
	JButton jbgbook;
	
	CheckPackage(String username){
		
		setBounds(350,200,850,550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		String [] package1= {"Welcome to Gold Package","6 Days & 7 Nights","Airport Assitance","City Tour","Multi-Meal Buffet","Free Drinks","3 Islands Tour","English Guide","Summer Special","Rs 15,000/-","package1.jpg"};
		String [] package2= {"Welcome to Silver Package","5 Days & 6 Nights","Airport Assistance","City Tour","Dual-Meal Buffet","Free Soft Drinks","2 - Islands Tour","English Guide","Summer Special","Rs 10,000/-","package2.jpg"};
		String [] package3= {"Welcome to Bronze Package","4 Days & 5 Nights","Luggage Assitance","Tolls & Entries Free","Free Mineral Water","Single-Meal Buffet","1 Islands Tour","Local Guide","Summer Special","Rs 7,000/-","package3.jpg"};
		
		JTabbedPane jbtab=new JTabbedPane();
		//PANEL P1
		JPanel p1=createPackage(package1);
		jbtab.addTab("Package 1",null,p1);
		
		//PANEL P2
		JPanel p2=createPackage(package2);
		jbtab.addTab("Package 2",null,p2);
		
		//PANEL P3
		JPanel p3=createPackage(package3);
		jbtab.addTab("Package 3",null,p3);
		
		jbtab.setPreferredSize(new Dimension(850, 500));
   	    add(jbtab);
		
		//CLOSES THE EXECUTION
	    addWindowListener(new WindowAdapter() {
	    	@Override
             public void windowClosing(WindowEvent e) {
	               System.exit(0);
	            }
	        });

		setVisible(true);
		
		
	}
	public JPanel createPackage(String [] pack) {
		
		JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setBackground(new Color(205,174,93));
		
				lblghead=new JLabel (pack[0]);
				lblghead.setBounds(30, 10, 400, 30);
				lblghead.setFont(new Font("Tahoma",Font.BOLD,25));
				lblghead.setForeground(Color.DARK_GRAY);
				p.add(lblghead);
				
				lblgday=new JLabel ("->"+pack[1]);
				lblgday.setBounds(50, 50, 350, 30);
				lblgday.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgday.setForeground(Color.DARK_GRAY);
				p.add(lblgday);
				
				lblgairport=new JLabel ("->"+pack[2]);
				lblgairport.setBounds(50, 100, 350, 30);
				lblgairport.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgairport.setForeground(Color.DARK_GRAY);
				p.add(lblgairport);
				
				lblgtour=new JLabel ("->"+pack[3]);
				lblgtour.setBounds(50, 150, 350, 30);
				lblgtour.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgtour.setForeground(Color.DARK_GRAY);
				p.add(lblgtour);
				
				lblgbuffet=new JLabel ("->"+pack[4]);
				lblgbuffet.setBounds(50, 200, 350, 30);
				lblgbuffet.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgbuffet.setForeground(Color.DARK_GRAY);
				p.add(lblgbuffet);
				
				lblgdrinks=new JLabel ("->"+pack[5]);
				lblgdrinks.setBounds(50, 250, 350, 30);
				lblgdrinks.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgdrinks.setForeground(Color.DARK_GRAY);
				p.add(lblgdrinks);
				
				lblgislands=new JLabel ("->"+pack[6]);
				lblgislands.setBounds(50, 300, 350, 30);
				lblgislands.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgislands.setForeground(Color.DARK_GRAY);
				p.add(lblgislands);
				
				lblgguide=new JLabel ("->"+pack[7]);
				lblgguide.setBounds(50, 350, 350, 30);
				lblgguide.setFont(new Font("Tahoma",Font.BOLD,20));
				lblgguide.setForeground(Color.DARK_GRAY);
				p.add(lblgguide);
				
				lblgoffer=new JLabel ("->"+pack[8]);
				lblgoffer.setBounds(320, 400, 350, 30);
				lblgoffer.setFont(new Font("Tahoma",Font.BOLD,25));
				lblgoffer.setForeground(Color.BLUE);
				p.add(lblgoffer);
				
				jbgbook=new JButton ("Book Package");
				jbgbook.setBounds(380, 450, 350, 30);
				jbgbook.setFont(new Font("Tahoma",Font.BOLD,20));
				jbgbook.setForeground(Color.RED);
				p.add(jbgbook);
				
				lblgprice=new JLabel ("->"+pack[9]);
				lblgprice.setBounds(600, 400, 350, 30);
				lblgprice.setFont(new Font("Tahoma",Font.BOLD,25));
				lblgprice.setForeground(Color.BLUE);
				p.add(lblgprice);
				
		        //IMAGE ICON
				ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
				Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
				ImageIcon i3=new ImageIcon(i2);
				JLabel icon1=new JLabel(i3);
				icon1.setBounds(350, 70, 450, 300);
				p.add(icon1);
				
				return p;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbgbook) {
			new BookPackage(username);
		}
	}

	public static void main(String[] args) {
             new CheckPackage("");


	}

}
