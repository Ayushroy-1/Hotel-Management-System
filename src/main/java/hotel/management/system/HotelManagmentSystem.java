package hotel.managment.system;



import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class HotelManagmentSystem extends JFrame implements ActionListener{

    HotelManagmentSystem(){

        //setSize(1366,565);
       
       // setLocation(100,30);
        setBounds(100, 100,1366, 565);
        setLayout(null);
       
       // ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("img/eight.jpg"));
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("img/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);

            JLabel text= new JLabel("HOTEL MANAGMENT SYSTEM");
            text.setBounds(20,430,1000,90);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Serif",Font.PLAIN,50));
            image.add(text);


            JButton next = new JButton("Next");
            next.setBounds(1150,450,150,50);
            next.setForeground(Color.MAGENTA);
            next.addActionListener(this);
            next.setFont(new Font("Serif",Font.PLAIN,24));
            image.add(next);

            setVisible(true);

            while(true) {
            
               text.setVisible(false);
                try {
                    Thread.sleep(500);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                text.setVisible(true);
                try {
                    
                    Thread.sleep(500);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            
    }

    public void actionPerformed(ActionEvent ae){

                setVisible(false);
                new Login();
                
            }

    public static void main(String[] args) {
        
        HotelManagmentSystem c1 = new HotelManagmentSystem();

    }
}