<%-- 
    Document   : Welcome
    Created on : 21 Jun, 2018, 11:00:39 AM
    Author     : GAGAN
--%>

<%@page import="javax.jms.Session"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Login1.MydbConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="style.css" rel="stylesheet">
        <script> 
           </script>
    </head>
    <body>
     
              
        <% HttpSession hs=request.getSession(false);
            
            if(hs==null)
        {
            response.sendRedirect("index.jsp");
}%>
    <div class="container"> 
        <div class="header"><center><font size="10" color="silver"><b><u>Welcome ${username}</u></b></font></center></div>
        
        <br><br>
        
        
        <div class='search'><form action="logout" method="post"><input type="submit"  value="Home">
                    </form><br>
<form action='searchBook' method='post'><input type="hidden" value="${username}" name="uid"/><input type='text'  name='search' placeholder='Search Book'><br><input type='submit' name='searchbtn' value='search'></form></div>
        <center>
        <div class="welcomestudent">
        <form action="StudentBookList" method="post">
            
                <h1><u>Issue Book</u></h1><br>
                <input type="hidden" value="${username}" name="uid"/>
                <input type="submit" value="Click Here to view the book List" name="submit"/>
            
                <br><br><br>
        </form>
        <form action="ViewIssued" method="post">        
                <h1><u>Return Book</u></h1><br>
                <input type="hidden" value="${username}" name="uid"/>
                <input type="submit" value="View Issued Books" name="submit"/>
               
        </form>
             <br><br>
        
        <form action="ChangePassword.jsp" method="post">        
                <h1><u>Change Password</u></h1><br>
                <input type="hidden" value="${username}" name="uid"/>
                <input type="submit" value="Change Password" name="submit"/>
               
        </form>               
     </div>
 </center>
                <br><br><br><br>
        <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
    </div>