<%-- 
    Document   : AddBook
    Created on : 22 Jun, 2018, 7:18:06 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
        <link href="style.css" rel="stylesheet">
    </head>
    
    <body>
         <div class="container"> 
        <div class="header"><center><font size="10" color="silver"><b><u>Add Book</u></b></font></center></div>
        <div class='search'>
            <form action="BookList" method="post"><input type="submit" name="back" value="back"/></form>
        </div>
        <form action="AddBook">
        <center>
         <br><br>   
        <table border="2" cellspacing="5" cellpadding="15">
            
            <br> 
                <tbody>
                    
                    <tr bgcolor="yellow">
                        <td><b><font size='5'>Enter Book Name:</b><hr><input type="text" name="bname"/></td>
                    </tr>
                    <tr bgcolor="yellow">
                        <td><b><font size='5'>Enter Author Name:</b><hr><input type="text" name="bauthor"/></td>
                    </tr>
                    <tr bgcolor="yellow">
                        <td><input size=5 type="submit" value="submit" name="submit"/></td>
                    </tr>    
                </tbody> 
            </table>
           </center> 
            </form>
        <br><br><br><br><br><br><br><br><br><br>
        <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
        </div>
    </body>
</html>
