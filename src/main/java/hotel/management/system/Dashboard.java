package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard(){
// bounds
    
   setBounds(0,0,1550,1000);
   setLayout(null);
   
    //image

   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/third.jpg"));
   Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   image.setBounds(0,0,1550,1000);
   add(image);

   // Text

   JLabel text = new JLabel("WELCOME TO ROYAL EMPIRE");
   text.setBounds(400,80,1000,50);
   text.setFont(new Font("Tahoma",Font.PLAIN,46));
   text.setForeground(Color.WHITE);
   image.add(text);

//menu bar

JMenuBar menubar = new JMenuBar();
menubar.setBounds(0,0,1550,30);
image.add(menubar);

JMenu hotel = new JMenu("HOTEL MANAGMENT");
hotel.setForeground(Color.RED);
menubar.add(hotel);

JMenuItem reception = new JMenuItem("RECEPTION");
reception.addActionListener(this);
hotel.add(reception);


JMenu admin = new JMenu("ADMIN");
admin.setForeground(Color.BLUE);
menubar.add(admin);

JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
addemployee.addActionListener(this);
admin.add(addemployee);

JMenuItem addrooms = new JMenuItem("ADD ROOMS");
addrooms.addActionListener(this);
admin.add(addrooms);

JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
adddrivers.addActionListener(this);
admin.add(adddrivers);


setVisible(true);
}

public  void actionPerformed(ActionEvent ae){

if(ae.getActionCommand().equals("ADD EMPLOYEE")){
   new AddEmployee();
}
else if(ae.getActionCommand().equals("ADD ROOMS")){
   new AddRooms();
}
else if(ae.getActionCommand().equals("RECEPTION")){
   new Reception();
}
else if(ae.getActionCommand().equals("ADD DRIVERS")){
   new AddDriver();
}

}

   public static void main(String[]args){

    new Dashboard();
   }
}


    

