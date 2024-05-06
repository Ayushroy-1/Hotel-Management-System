package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfname,tfage,tfmodel,tfroom,tfcompany,tflocation,tfprice;
    JComboBox agecombo,availablecombo,gendercombo,typecombo;
AddDriver(){

getContentPane().setBackground(Color.WHITE);
setLayout(null);

JLabel heading = new JLabel("Add Drivers");
heading.setFont(new Font("Tahoma", Font.BOLD,17));
heading.setBounds(150,10,200,20);
add(heading);

JLabel lblroomno = new JLabel("Name");
lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
lblroomno.setBounds(60,70,120,30);
add(lblroomno);

 tfname = new JTextField();
 tfname.setBounds(200,70,150,30);
add(tfname);

JLabel lblage = new JLabel("Age");
lblage.setFont(new Font("Tahoma", Font.PLAIN,16));
lblage.setBounds(60,110,120,30);
add(lblage);

tfage = new JTextField();
tfage.setBounds(200,110,150,30);
add(tfage);

JLabel lblclean = new JLabel("Gender");
lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
lblclean.setBounds(60,150,120,30);
add(lblclean);

String cleanOptions[]={"Male","Female"};
 gendercombo = new JComboBox(cleanOptions);
 gendercombo.setBounds(200,150 ,150,30);
 gendercombo.setBackground(Color.WHITE);
add(gendercombo);

JLabel lblprice = new JLabel("Car Company");
lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
lblprice.setBounds(60,190,120,30);
add(lblprice);

 tfcompany = new JTextField();
 tfcompany.setBounds(200,190,150,30);
add(tfcompany);

JLabel lbltype = new JLabel("Car Model");
lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
lbltype.setBounds(60,230,120,30);
add(lbltype);

tfmodel = new JTextField();
tfmodel.setBounds(200,230,150,30);
add(tfmodel);



JLabel lblavailable = new JLabel("Available");
lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
lblavailable.setBounds(60,270,120,30);
add(lblavailable);


String driverOptions[]={"Available","Busy"};
 availablecombo = new JComboBox(driverOptions);
 availablecombo.setBounds(200,270,150,30);
 availablecombo.setBackground(Color.WHITE);
add(availablecombo);


JLabel lbllocation = new JLabel("Location");
lbllocation.setFont(new Font("Tahoma", Font.PLAIN,16));
lbllocation.setBounds(60,330,120,30);
add(lbllocation);

tflocation = new JTextField();
tflocation.setBounds(200,330,150,30);
add(tflocation);

 add = new JButton("Add Driver");
add.setForeground(Color.WHITE);
add.setBackground(Color.BLACK);
add.setBounds(60,370,130,30);
add.addActionListener(this);
add(add);


 cancel = new JButton("Cancel");
cancel.setForeground(Color.WHITE);
cancel.setBackground(Color.BLACK);
cancel.setBounds(220,370,130,30);
cancel.addActionListener(this);
add(cancel);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/eleven.jpg"));
Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(400,30,500,300);
add(image);


setBounds(300,200,980,470);
setVisible(true);

}
public  void actionPerformed(ActionEvent ae){

    if(ae.getSource() == add){

        String name= tfname.getText();
        Integer age =Integer.parseInt(tfage.getText());
        String gender = (String) gendercombo.getSelectedItem();
        String company = tfcompany.getText();
        String brand = tfmodel.getText();
        String available = (String) availablecombo.getSelectedItem();
        String location = tflocation.getText();

        try {
             Conn conn = new Conn();
             String str = "insert into driver(name, age, gender, company, brand, available, location) values(?,?,?,?,?,?,?)";
           // String str = "insert into driver values('','"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
            System.out.println(str);
            //PreparedStatement st = conn.prepareStatement(str);
            PreparedStatement pstmt = conn.c.prepareStatement(str);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, company);
            pstmt.setString(5, brand);
            pstmt.setString(6, available);
            pstmt.setString(7, location);

            pstmt.execute();
            //conn.s.executeUpdate(pstmt);
            JOptionPane.showMessageDialog(null,"New driver added successfully");
            setVisible(false);


            


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    else{
        setVisible(false);
    }



}

public static void main(String[] args) {
    new AddDriver();
}
}
