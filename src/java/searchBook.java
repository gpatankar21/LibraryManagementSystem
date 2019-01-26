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


@WebServlet(urlPatterns = {"/searchBook"})
public class searchBook extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String unm=request.getParameter("uid");
        
            PrintWriter pw=response.getWriter();
     pw.print("<html>\n" +
"    <head>\n" +
"        <link href=\"style.css\" rel=\"stylesheet\">"
                    + "</head></html>");
     pw.println("<div class=\"container\">\n" +
"           <div class=\"header\"><center><font size=\"10\" color=\"silver\"><b><u>SEARCH RESULT</u></b></font></center></div>\n");
       
     pw.println("<body><br>"
             + "<div class='search'>");
             if(unm==null)
             {
             pw.println("<form action=\"BookList\" method=\"post\"><input type=\"submit\"  value=\"Back\"></div>");
             }
             else
             {
             pw.println("<form action=\"WelcomeStudent.jsp\" method=\"get\"><input type=\"submit\"  value=\"Back\"></div>");
             }
         
             pw.println("<center>"
             + "<br><br><table border=2 cellpadding='5'><tr><th>Book Id</th><th>Book Name</th><th>Book Author</th>");
     
             
     String bname=request.getParameter("search");
     
     try
     {
     Connection con=MydbConnection.getDbConnection();
     PreparedStatement pst= con.prepareStatement("Select * from book_list where book_name=? ");
     pst.setString(1,bname);
     ResultSet rs=pst.executeQuery();
     
     if(rs.isBeforeFirst())
     {
         while(rs.next())
         {
       
            pw.println("<h1>Book Found</h1><br><tr><td>"+rs.getInt("book_id")+"</td><td>"+rs.getString("book_name")+"</td><td>"+rs.getString("book_author")
                     + "</div></tr>");
         }
     }
     else
     {
         pw.println("<h1>Book Not Found</h1><br>"
                 + "<tr><td><center>X</center>"+"</td><td><center>X</center>"+"</td><td><center>X</center>"
                     + "</div></tr>");
     }
     pw.println("</table></body></html>");
     }
     
     catch(Exception e)
     {
         pw.println("Book Not Found");
     }
     
     pw.println("<br><br>"
             + "<div class=\"footer\">\n" +
"              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>\n" +
"               Designed By Gagan Patankar</center>\n" +
"           </div>"
             + "</div>");
        }
    }

