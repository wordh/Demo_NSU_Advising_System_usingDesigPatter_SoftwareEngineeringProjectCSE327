package registrationui;
import java.sql.*;

public class DBManager {
    Connection con=null;
    public Connection connectDB(){
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse327","root","");
        }catch(Exception e){ 
            System.out.println(e);
        }  
        return con;
    }
}
