package User;



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


@WebServlet(urlPatterns = {"/ViewIssued"})
public class ViewIssued extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        PrintWriter pw=response.getWriter();
        
        
     pw.print("<html>\n" +
"    <head>\n" +
"        <link href=\"style.css\" rel=\"stylesheet\">"
                    + "</head></html>");
     pw.println("<div class=\"container\">\n" +
"           <div class=\"header\"><center><font size=\"10\" color=\"silver\"><b><u>Issued Books</u></b></font></center></div>\n");
        
        
        String username=request.getParameter("uid");
        
        int book_id;
        try
     {
         Connection con=MydbConnection.getDbConnection();
         PreparedStatement pst1=con.prepareStatement("select book_id,book_name,book_issuedate,book_returndate from book_issue where username=? order by book_issuedate");
         pst1.setString(1,username);
         ResultSet rs1=pst1.executeQuery();
        
         pw.println("<html><head><script>"
             + "function logout()\n" +
"        {\n" +
"            var res=window.confirm('Do you Want to return this book?')\n" +
"            if(res)\n" +
"            {\n" +
"                window.alert('Book Returned Successfully');\n" +
"                return true" +
"            }       \n" +
"            else \n" +
"            { return false"
              +
"        }}</script></head>"+
"<body><br><br><center><table border='2' cellspacing='2' cellpadding='2'><tr><th>Book Id</th><th>Book Name</th><th>Book Issue Date</th><th>Book Return Date</th><th>Return Book</th></tr>"); 
         
         if(rs1.isBeforeFirst())
         {
             while(rs1.next())
             {
                 int bid=rs1.getInt("book_id");
                 pw.println("<tr><td>"+rs1.getInt("book_id")+"</td>"+"<td>"+rs1.getString("book_name")+"</td>"+"<td>"+rs1.getDate("book_issuedate")+"</td>"+"<td>"+rs1.getDate("book_returndate")+"</td><td><form action='BookReturn' method='post'><input type='hidden' value='"+bid+"' name='bid'><input onclick=\"return logout()\" type=\"submit\" name='book_issue' value='Return'></td></form></td></tr>");
             }
         }
         pw.println("</center></table></body></html>");
     }
     catch(Exception e)
     {
         pw.println("Cant Show Issued Books");
     }
    pw.println("<br><br>"
                 + "<div class=\"footer\">\n" +
"              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>\n" +
"               Designed By Gagan Patankar</center>\n" +
"           </div>");
        }
    }



