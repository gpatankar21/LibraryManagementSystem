package User;



import Login1.MydbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/StuIssueRequest"})
public class StuIssueRequest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        java.sql.Date d1=new java.sql.Date(new java.util.Date().getTime());
        java.sql.Date d2=new java.sql.Date(new java.util.Date().getTime());
        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE,14);
         d2.setTime(d1.getTime() + 1 * 336 * 60 * 60 * 1000);
        PrintWriter pw=response.getWriter();
        int book_id=Integer.parseInt(request.getParameter("bid"));
        String username=request.getParameter("uname");
        String bname=request.getParameter("bname");
            try
     
            {
               
                Connection con=MydbConnection.getDbConnection();
                PreparedStatement pst=con.prepareStatement("insert into book_issue values(?,?,?,?,?)");
                pst.setString(1,username);
                pst.setInt(2,book_id);
                pst.setString(3,bname);
                pst.setDate(4,d1);
                pst.setDate(5,d2);
                int count=pst.executeUpdate();
                if(count>=0)
                {
                    pw.println("<html><head><script>window.alert('Book Issued Successfully');window.location='WelcomeStudent.jsp'</script></head></form></html>");
                    
                }


                } 
                catch (SQLException ex) 
                {      
                     
                    pw.println("<html><head><script>window.alert('Book already issued. Please try for some other book'); window.location='WelcomeStudent.jsp';</script></head></html>");
                      
                }
        
        
            }

    

}
