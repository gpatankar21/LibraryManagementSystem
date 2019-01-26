package User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Login1.MydbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/StudentBookList"})
public class StudentBookList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String uname=request.getParameter("uid");
            PrintWriter pw=response.getWriter();
            pw.println("<html>\n" +
"    <head>\n" +
"        <link href=\"style.css\" rel=\"stylesheet\">"
                    + "</head></html>");
            pw.println("<div class=\"container\">\n" +
"           <div class=\"header\"><center><font size=\"10\" color=\"silver\"><b><u>BOOK LIST"+"</u></b></font></center></div>\n");           
        
          
            
            try
     {
     response.setContentType("text/html");
     Connection con=MydbConnection.getDbConnection();
     PreparedStatement pst=con.prepareStatement("Select * from book_list order by book_id");
     ResultSet rs=pst.executeQuery();
    
     pw.println("<html><body><br>"
     
             + "<br><br><br><center><table border=2 cellpadding='5'><tr><th>Book Id</th><th>Book Name</th><th>Book Author</th><th>Issue Book</th></tr>");
            if(rs.isBeforeFirst())
     {
         while(rs.next())
         {
         int bid=rs.getInt("book_id");
         String bname=rs.getString("book_name");
               pw.println("<tr><td>"+rs.getInt("book_id")+"</td><td>"+rs.getString("book_name")+"</td><td>"+rs.getString("book_author")+"</td><td><form action='StuIssueRequest' method='post'><input type='hidden' value='"+bid+"' name='bid'><input type='hidden' value='"+uname+"' name='uname'><input type='hidden' value='"+bname+"' name='bname'><input type=submit name='book_issue' value='Issue book'></td></tr></form>");
        }
          pw.println("</center></table></body></html>");
     }
     con.close();
     }
     catch(Exception e)
     {
         response.sendRedirect("index.jsp");
     }
            
         pw.println("<br><br>"
                 + "<div class=\"footer\">\n" +
"              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>\n" +
"               Designed By Gagan Patankar</center>\n" +
"           </div>");   
    }
}

    

