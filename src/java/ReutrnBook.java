

import Login1.MydbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/ReutrnBook"})
public class ReutrnBook extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw=response.getWriter();
        
        int bid=Integer.parseInt(request.getParameter("bid"));
        
                    try
  {
  Connection con=MydbConnection.getDbConnection();
  PreparedStatement pst=con.prepareStatement("delete from book_issue where book_id = ?");
  pst.setInt(1,bid);
  int count=pst.executeUpdate();
  if(count>0)
  {
      pw.println("");
      
      response.sendRedirect("WelcomeStudent.jsp");
  }
  }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    }

    
