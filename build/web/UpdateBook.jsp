<%-- 
    Document   : UpdateBook
    Created on : 28 Jun, 2018, 8:05:55 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book</title>
     <link href="style.css" rel="stylesheet">
    </head>
    <body>
        <%
            int bid=Integer.parseInt(request.getParameter("bid"));
            String bauthor=request.getParameter("bauthor");
            String bname=request.getParameter("bname");
        %>
        <div class="container"> 
        <div class="header"><center><font size="10" color="silver"><b><u>Update Book</u></b></font></center></div>
        <div class='search'>
            <form action="BookList" method="post"><input type="submit" name="back" value="back"/></form>
        </div><br><br>
        <form action="UpdateBook" method="post">
            <br><br>
        <center>
            <table align="center" border="2" cellspacing="5" cellpadding="15">
            
                <tbody>
                    <tr bgcolor="yellow">
                        <td><b><font size='5'>Book Id</b></td>
                        <td><font size="5"><b><%=bid%></b></font></td>
                        
                    </tr>    
                    <tr bgcolor="yellow">
                        <td><b><font size='5'>Update Book Name:</b></td>
                        <td><input type="text" name="bname_new" value="<%=bname%>"/></td>
                    </tr>
                    <tr bgcolor="yellow">
                        <td><b><font size='5'>Author Name:</b></td>
                        <td><b><font size="5"><%=bauthor%></b></font></td>
                    </tr>
                    </tbody>
                    </table>
                    
                    <br> <br>
                        <input type="hidden" name="bid" value="<%=bid%>"><input type="hidden" name="bauthor" value="<%=bauthor%>"><center><input size=5 type="submit" onclick="window.alert('Book Updated Successfully')" value="submit" name="submit"/></center>
                   
                </center>
            </form><br><br><br><br><br><br><br><br>
        <div class="footer">
              <center> <h4>Untitled. All rights reserved.&copy;form 2018-2030</h4>
               Designed By Gagan Patankar</center>
           </div>
        </div>      
    </body>
</html>
