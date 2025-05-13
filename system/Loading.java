package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Loading extends JFrame implements Runnable {
	
	Thread th;
	
	JLabel lbltext,lblloading,lblusername;
	JProgressBar bar;
	String username;
	
	Loading(String username){
		this.username=username;
		
		th=new Thread(this);
		
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //TRAVEL TOURISM APPLICATION
        lbltext=new JLabel("Travel and Tourism Application");
        lbltext.setBounds(80,20,600,40);
        lbltext.setForeground(Color.BLUE);
        lbltext.setFont(new Font("Times New Roman",Font.BOLD,35));
        add(lbltext);
        
        //LOADING
        lblloading=new JLabel("Loading,Please Wait!!");
        lblloading.setBounds(170,140,300,40);
        lblloading.setForeground(Color.RED);
        lblloading.setFont(new Font("Times New Roman",Font.BOLD,27));
        add(lblloading);
        
        //USERNAME
        lblusername=new JLabel("Welcome "+username);
        lblusername.setBounds(40,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,24));
        add(lblusername);
        
        //PROGRESS BAR
        bar=new JProgressBar();
        bar.setBounds(150,100,300,25);
        bar.setStringPainted(true);
        add(bar);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        
        th.start();
		setVisible(true);
	}
	

	public void run() {
		try {
			for(int i=0;i<=100;i++) {
				int max =bar.getMaximum();
				int value=bar.getValue();
				
				if(value<max) {
					bar.setValue(bar.getValue()+1);
				}
				else {
					setVisible(false);
					new Dashboard(username);
					//System.exit(0);
					
				}
				Thread.sleep(10);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		
			
		}
	}
	
	public static void main(String[] args) {
          new Loading("");

	}

}
