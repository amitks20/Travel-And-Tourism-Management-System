package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CheckHotels extends JFrame implements Runnable {
	
	Thread th;
	String username;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JLabel[] label =new JLabel[] {l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};	 
	
	JLabel caption;
	
	CheckHotels(String username){
		
		this.username=username;
		
		setBounds(450,130,800,600);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		//caption
		caption=new JLabel();
		caption.setBounds(70, 500, 500, 70);
		caption.setForeground(Color.WHITE);
		caption.setFont(new Font("Tahoma",Font.BOLD,40));
		add(caption);
				
		//for i1,i2,i3 in normal imageicon here i1,ji,k1
		ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
		ImageIcon[] image= new ImageIcon[] {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
		
		Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
		Image[] jimage= new Image[] {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
		
		ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
		ImageIcon[] kimage= new ImageIcon[] {k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};
		
		//images
		for(int i=0;i<=9;i++) {
		image[i]=new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpg"));
	    jimage[i] =image[i].getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
	    kimage[i]=new ImageIcon(jimage[i]);
		label[i]=new JLabel(kimage[i]);
		label[i].setBounds(0,0,800,600);
		add(label[i]);	
		}
		

		//CLOSES THE EXECUTION
	    addWindowListener(new WindowAdapter() {
	    	@Override
             public void windowClosing(WindowEvent e) {
	               System.exit(0);
	            }
	        });

	    //thread
	    th=new Thread(this);
	    th.start();
	    
	    
		setVisible(true);		    	
	}

	public void run() {
	
	String[] hoteltext=new String[] {"River View","East Side","Casterly Rock","Urban Den","Modern Hut","Skyline Hotel", "Paradise Resort", "Ocean Pearl", "Majestic Stay", "Sunrise Inn"};
	
	try {
		
		for(int i=0;i<=9;i++) {
			caption.setText(hoteltext[i]);
			label[i].setVisible(true);

			th.sleep(500);
			if (i != 9) { 
				label[i].setVisible(false);
				}
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
	public static void main(String[] args) {
		
	  new CheckHotels("");

	}

}
