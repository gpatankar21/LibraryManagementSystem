/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Login1.MydbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAGAN
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        PrintWriter pw=response.getWriter();
        
        String pass=request.getParameter("pass");
        String rpass=request.getParameter("rpass");
        String uid=request.getParameter("uid");
        
          try
     {
         Connection con=MydbConnection.getDbConnection();
         PreparedStatement pst=con.prepareStatement("update student set password=?"+"where username=?");
         pst.setString(1,rpass);
         pst.setString(2,uid);
         
               
         int count=pst.executeUpdate();
         
         if(count>0)
         {
            response.sendRedirect("WelcomeStudent.jsp");
         }
         
         con.close();
     }
     catch(Exception e)
     {
         pw.println("Can not be updated");
     }
        
}
}
        

   