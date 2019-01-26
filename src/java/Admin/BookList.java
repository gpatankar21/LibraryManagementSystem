package Admin;



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
import javax.ws.rs.core.Response;


@WebServlet(urlPatterns = {"/BookList"})
public class BookList extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session=request.getSession(false);
         
            if(session==null)
            {
               response.sendRedirect("index.jsp");
            }
   
        PrintWriter pw=response.getWriter();
     pw.print("<html>\n" +
"    <head>\n"
             + "<script>\n" +
"            history.forward();\n" +
"            </script>" +
"        <link href=\"style.css\" rel=\"stylesheet\">"
                    + "</head></html>");
     pw.println("<div class=\"container\">\n" +
"           <div class=\"header\"><center><font size=\"10\" color=\"silver\"><b><u>WELCOME ADMIN</u></b></font></center></div>\n");
     
             pw.println("<html><head><body><br>" +
"<div class='search'><form action=\"logout\" method=\"post\"><input type=\"submit\" value=\"Home\"/></form><br>"
                     + "<form action='searchBook' method='post'><input type='text'  name='search' placeholder='Search Book'><br><input type='submit' name='searchbtn' value='search'/></form>"
                     + "<br></div><div class='admin'><form action=\"AddBook.jsp\" method=\"post\"><form action='AddBook.jsp' method='post'>"
                     + "</h1><br><input type=submit name='addBook' value='+ Add New Book'></form><br><form action='IssuedBooks' method='get'>"
                     + "</h1><input type=submit name='' value='Check Books Issued'></form></div>"
                     + "</body></html>");
     try
     {
     response.setContentType("text/html");
     Connection con=MydbConnection.getDbConnection();
     PreparedStatement pst=con.prepareStatement("Select * from book_list order by book_id");
     ResultSet rs=pst.executeQuery();
     pw.println("<html><head><script>"
             + "function logout()\n" +
"        {\n" +
"            var res=window.confirm('Do you Want to delete this book?')\n" +
"            if(res)\n" +
"            {\n" +
"                window.alert('Book Deleted Successfully');\n" +
"                return true" +
"            }       \n" +
"            else \n" +
"            { return false"
              +
"        }}</script></head>"+
               "<body><center><br><br><table border=2 cellpadding='5'><tr><th>Book Id</th><th>Book Name</th><th>Book Author</th><th>Delete Book</th><th>Update Book</th></tr>");
     if(rs.isBeforeFirst())
     {
         while(rs.next())
         {
             int r=2;
         int bid=rs.getInt("book_id");
         String bname=rs.getString("book_name");
         String bauthor=rs.getString("book_author");
               pw.println("<tr><td>"+rs.getInt("book_id")+"</td><td>"+rs.getString("book_name")+"</td><td>"+rs.getString("book_author")+
                          "</td><td><form action='DelBook' method='post'><input type='hidden' value='"+bid+"' name='bid'/>"+
                          "<input onclick=\"return logout()\" type=\"submit\" value=\"X\" name='delete'>"+
                          "</td></form><td><form action='UpdateBook.jsp'><input type='hidden' value='"+bid+"' name='bid'/><input type='hidden' value='"+bname+"' name='bname'/>"+
                          "<input type='hidden' value='"+bauthor+"' name='bauthor'/><input type=submit name='update' value='U'</td></form>");            
         }
     pw.println("</center></table><center><br></center>"
             + "<br><br>"
             + "<div class=\"footer\">\n" +
"              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>\n" +
"               Designed By Gagan Patankar</center>\n" +
"           </div>"
             + "</body></html>");
     }
     con.close();
     }
     catch(Exception e)
     {
         pw.println("Cannot view books");
     }
    }

    
}


