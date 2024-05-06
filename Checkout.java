package hotel.managment.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {
    
    
    Choice roomno;
    JLabel lblroomnumber,lblCheckintime,lblcheckouttime;
    JButton checkout , back;
    Checkout(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setBackground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblid = new JLabel("Room number");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        roomno = new Choice();
        roomno.setBounds(150,80,150,25);
        add(roomno);

        try {
            Conn c =  new Conn();
            ResultSet rs = c.s.executeQuery("Select *from room where availability='Not Available'");
            
            while(rs.next()){
                roomno.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(300,80,20,20);
        add(tick);

       // JLabel lblroom = new JLabel("Room Number");
        //lblroom.setBounds(30,130,100,30);
        //add(lblroom);

        // lblroomnumber = new JLabel("Room Number");
        //lblroomnumber.setBounds(150,130,100,30);
        //add(lblroomnumber);

        
       // JLabel lblcheckin = new JLabel("Checkin Time");
        //lblcheckin.setBounds(30,180,100,30);
        //add(lblcheckin);

        //lblCheckintime = new JLabel();
        //lblCheckintime.setBounds(150,180,100,30);
        //add(lblCheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        Date date = new Date();

        lblcheckouttime = new JLabel(""+ date);
        lblcheckouttime.setBounds(150,230,160,30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("img/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);









setBounds(300,200,800,400);
setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== checkout){

            try{

            Conn c = new Conn();
           // String query = "update room set availability = Available where roomnumber ="+roomnumber;
           String query = "update room set availability = 'Available' where roomnumber ="+roomno.getSelectedItem();
           c.s.executeUpdate(query);

           

           JOptionPane.showMessageDialog(null,"Customer Checkout successful");
            setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }
    else{

        setVisible(false);
        new Reception();
    }
}

    public static void main(String[] args) {
        new Checkout();
    }
}
