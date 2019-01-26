package Admin;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Login1.MydbConnection;
import java.sql.ResultSet;
/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/AddBook"})
public class AddBook extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
     PrintWriter pw=response.getWriter();
     
     int book_id;
     String book_name;
     String book_author;
     
     book_id=0;
     book_name=request.getParameter("bname");
     book_author=request.getParameter("bauthor");
    try
     {
     Connection con=MydbConnection.getDbConnection();
     
      PreparedStatement ps=con.prepareStatement("select max(book_id) from book_list");
     ResultSet rs=ps.executeQuery();
     if(rs.next())
     {
         book_id=rs.getInt(1);
         book_id+=1;
     }
     PreparedStatement pst=con.prepareStatement("insert into book_list values(?,?,?)");
     pst.setInt(1,book_id);
     pst.setString(2, book_name);
     pst.setString(3,book_author);
     int count=pst.executeUpdate();
     if(count>0)
     {
         pw.println("<html><head><script>window.alert('Book Added Successfully');window.location='AddBook.jsp';</script></head></html>");
     }
     
     
     }
     catch(Exception e)
     {
        System.out.println("Can not create book");
     }
 }
}