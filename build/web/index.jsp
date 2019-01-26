<%-- 
    Document   : index1
    Created on : 30 Jun, 2018, 1:27:14 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="style.css" rel="stylesheet">
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Management</title>
    </head>
    
    <body>
        
       <div class="container">
           <div class="header"><center><font size="10" color="silver"><b><u>LIBRARY MANAGEMENT SYSTEM</u></b></font></center></div>
           <div class="links">
               <center><font size="5" color="green"><a href="index.jsp"> Home &nbsp;&nbsp;&nbsp;</a><a href="AboutUs.jsp"> About us &nbsp;&nbsp;&nbsp;</a> <a href="SignUp.jsp">Sign Up &nbsp;&nbsp;&nbsp;</a><a href="Images.jsp"> Images</a></font></center>
           </div>
           <div class="image">
               <div class="circle1"></div>
               <div class="circle2"></div>
               <div class="circle3"></div>
               <div class="circle4"></div>
           </div>
           <div class="Studentlogin">
                  <center><font size="5" color="navy"><b><u>Login</u></b></font></center>                                     
            <form action= "StudentLogin" method="post">
                <br><br>
            <table border="2" cellspacing="5" cellpadding="5" bgcolor="lightblue">
                <tbody>
                    <tr>
                        <td><b>Username  </b><input type="text" name="stuname" placeholder="Enter Username"/></td>
                    </tr>
                    <tr>
                        <td><b>Password    </b><input type="password" name="stupass" placeholder="Enter Password"/></td>
                    </tr>            
                    <tr>
                        <td><input type="submit" value="Login" name="submit"/></td>
                    </tr>
                </tbody>
            </table>
        </form><br><br>
           </div>
           <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
           </div>
        
        
    </body>
</html>
