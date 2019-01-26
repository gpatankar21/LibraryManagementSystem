package User;



import Login1.MydbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/StudentLogin"})
public class StudentLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        PrintWriter pw=response.getWriter();
        String stuname=request.getParameter("stuname");
        String stupass=request.getParameter("stupass");
        
        pw.println("<html><head>+ \"<script>\\n\" +\n" +
"\"            history.forward();\\n\" +\n" +
"\"            </script>\" +\n" +
"        \n" +
"                    \"</head></html>");
        
      if(stuname.equals("Lib_myadmin")&& stupass.equals("libraryadmin@123"))
      {
          RequestDispatcher rd=request.getRequestDispatcher("BookList");  
        rd.forward(request, response); 
      }
        try
     {
     Connection con=MydbConnection.getDbConnection();
     PreparedStatement pst= con.prepareStatement("Select * from student where username=? and password=? ");
     pst.setString(1,stuname);
     pst.setString(2,stupass);
     ResultSet rs=pst.executeQuery();
     if(rs.isBeforeFirst())
     {
            HttpSession session=request.getSession();
            session.setAttribute("username",stuname);
            response.sendRedirect("WelcomeStudent.jsp");
     }
     else
     {
         response.sendRedirect("index.jsp");
     }
     }
     catch(Exception e)
     {
         System.out.println("Invalid userid or password");
     }
        }
    }

