package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {

    Thread thread;

    static String username;
    
    Splash(String username) {
         
    	this.username=username;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(1200, 600);
        setLocationRelativeTo(null); 
        setVisible(true);
        
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
             new Login(username); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Splash frame = new Splash(username);
        
        int x = 1;
        
        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i) / 2, 400 - (i / 2)); 
            frame.setSize(x + i, i);
            
            try {
                Thread.sleep(10); // ms
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
