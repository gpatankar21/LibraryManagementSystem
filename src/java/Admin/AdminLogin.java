package Admin;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String uname=request.getParameter("uname");
        String pass=request.getParameter("pass");
        
        if(uname.equals("Admin") && pass.equals("123"))
        {
            HttpSession session=request.getSession();
            session.setAttribute("username",uname);
            response.sendRedirect("BookList");
        }
        else
        {
            response.sendRedirect("index.jsp");
        }
       
        
    }

    

}
