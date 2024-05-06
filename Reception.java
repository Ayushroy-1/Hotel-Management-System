package hotel.managment.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {
    
    JButton rooms,newCustomer,allEmployee,customers,checkout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

         newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);

         rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

         allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,110,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee);

         customers = new JButton("Customer Info");
        customers.setBounds(10,150,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);


         checkout = new JButton("Checkout");
        checkout.setBounds(10,190,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
    
        setBounds(350,200,800,570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()== newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()== allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource()== customers){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()== checkout){
            setVisible(false);
            new Checkout();
        }
    }
    public static void main(String[] args) {
        
    
        new Reception();
    }









}