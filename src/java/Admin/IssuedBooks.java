package Admin;

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

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/IssuedBooks"})
public class IssuedBooks extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    PrintWriter pw=response.getWriter();
       pw.print("<html>\n" +
"    <head>\n" +
"        <link href=\"style.css\" rel=\"stylesheet\">"
                    + "</head></html>");
     pw.println("<div class=\"container\">\n" +
"           <div class=\"header\"><center><font size=\"10\" color=\"silver\"><b><u>Books Issued</u></b></font></center></div><br><br>\n");
        pw.println("<body>"
                + "<div class='search'><form action=\"BookList\" method=\"post\"><input type=\"submit\"  value=\"Back\"></div>"
                + "<br><br><center><table border='2' cellspacing='3' cellpadding='3'><th>Book Id:</th><th>Book Issued to:</th><th>Book Name:</th>");
       try
       {    
           Connection con=MydbConnection.getDbConnection();
           PreparedStatement pst=con.prepareStatement("Select book_id,username,book_name from book_issue order by book_id");
           
           ResultSet rs=pst.executeQuery();
           if(rs.isBeforeFirst())
           {
               while(rs.next())
               {
                   int bid=rs.getByte("book_id");
                   String uname=rs.getString("username");
                   String bname=rs.getString("book_name");
                   pw.println("<tr><td>"+bid+"</td><td>"+uname+"</td><td>"+bname+"</td></tr>");
               }
           }
          pw.println("</table></center>"
                  + "<br><br>"
                  + "<div class=\"footer\">\n" +
"              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>\n" +
"               Designed By Gagan Patankar</center>\n" +
"           </div>"
                  + "</div></body></html>"); 
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
}
    


