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
@WebServlet(urlPatterns = {"/UpdateBook"})
public class UpdateBook extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        PrintWriter pw=response.getWriter();
        int bid=Integer.parseInt(request.getParameter("bid"));
        String bname=request.getParameter("bname_new");
        String bauthor=request.getParameter("bauthor");
        try
     {
         Connection con=MydbConnection.getDbConnection();
         PreparedStatement pst=con.prepareStatement("update book_list set book_name=?,book_author=?"+"where book_id=?");
         pst.setString(1,bname);
         pst.setString(2,bauthor);
         pst.setInt(3,bid);
        
        
         int count=pst.executeUpdate();
         
         if(count>0)
         {
            RequestDispatcher rd=request.getRequestDispatcher("BookList");  
        rd.forward(request, response);  
         }
         
         con.close();
     }
     catch(Exception e)
     {
         pw.println("Can not be updated");
     }
        
}
}



