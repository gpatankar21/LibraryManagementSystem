<%-- 
    Document   : SignUp
    Created on : 3 Jul, 2018, 1:38:57 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #main{
                margin-top:50px;
                height:auto;
                width:100%;
                text-align:center;  
            }
            </style>
        <link href="style.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
           <div class="header"><center><font size="10" color="silver"><b><u>LIBRARY MANAGEMENT SYSTEM</u></b></font></center></div>
           <div class="links">
               <center><font size="5" color="green"><a href="index.jsp"> Home &nbsp;&nbsp;&nbsp;</a><a href="AboutUs.jsp"> About us &nbsp;&nbsp;&nbsp;</a> <a href="SignUp.jsp">Sign Up &nbsp;&nbsp;&nbsp;</a><a href="Images.jsp"> Images</a></font></center>
           </div>
           <br>
           <div class="main"><center>
                   <h1><u>ENTER YOUR DETAILS</u></h1><br><br>
              <form action="SignUp" method="post">    
               <table border="2px" cellspacing="" cellpadding="5px" bgcolor="yellow">
                   <tbody>
                       <tr>
                        <td>Enter your Full Name:</td>
                        <td><input type="text" name="name" placeholder="Name"/></td>
                       </tr>
                       <tr>
                        <td>Enter username:</td>
                        <td><input type="text" name="username" placeholder="Username"/></td>
                       </tr>
                       <tr>
                        <td>Set Password:</td>
                        <td><input type="password" name="password" placeholder="password"/></td>
                       </tr>                                            
                   </tbody>
                </table>
                  <br><br>
                  <center>
                  <input type="submit" name="submit" value="SUBMIT"/></center>
               </form>    
           </center></div><br><br>  
           <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
        </div>
    </body>
</html>
