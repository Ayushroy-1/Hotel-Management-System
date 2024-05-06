package hotel.managment.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class EmployeeInfo extends JFrame implements ActionListener{

  JTable table; 
  JButton back;
    
EmployeeInfo(){

getContentPane().setBackground(Color.WHITE);
setLayout(null);


JLabel l0 = new JLabel("S.No.");
l0.setBounds(0 ,10,100,20);
add(l0);
JLabel l1 = new JLabel("Name");
l1.setBounds(130,10,100,20);
add(l1);
JLabel l2 = new JLabel("Age");
l2.setBounds(250,10,100,20);
add(l2);
JLabel l3 = new JLabel("Gender");
l3.setBounds(360,10,100,20);
add(l3);
JLabel l4 = new JLabel("Job");
l4.setBounds(500,10,100,20);
add(l4);
JLabel l5 = new JLabel("Salary");
l5.setBounds(610,10,100,20);
add(l5);

JLabel l6 = new JLabel("Phone");
l6.setBounds(720,10,100,20);
add(l6);

JLabel l7 = new JLabel("Email");
l7.setBounds(830,10,100,20);
add(l7);

JLabel l8 = new JLabel("Aadhar");
l8.setBounds(900,10,100,20);
add(l8);

table = new JTable();
table.setBounds(0,40,1000,400);
add(table);


try {
    Conn c = new Conn();
    ResultSet rs  = c.s.executeQuery("select * from employee");
    table.setModel(DbUtils.resultSetToTableModel(rs));



} catch (Exception e) {
    e.printStackTrace();
}

back = new JButton("Back");
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
back.setBounds(420,500,120,30);
add(back);




setBounds(300,200,1000,600);
setVisible(true);
}

public void actionPerformed(ActionEvent ae){
 
    setVisible(false);
    new Reception();
}

public static void main(String[] args) {
    new EmployeeInfo();
}
}

