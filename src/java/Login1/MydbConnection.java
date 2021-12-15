package Login1;




import java.sql.*;

public class MydbConnection {
    static Connection con;
 public static Connection getDbConnection()
 {
     //Changes for Develop Branch
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_System","root","");
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
     return con;
 }
}
