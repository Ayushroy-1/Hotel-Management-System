package hotel.managment.system;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              c=DriverManager.getConnection("jdbc:mysql:///hotelmanagmentsystem","root","Lamulamba@1");
              s=c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
      

    }
    public void executeUpdate(String query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }
}
