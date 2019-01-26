<%-- 
    Document   : DelBook
    Created on : 22 Jun, 2018, 8:10:43 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Book</title>
    </head>
    <body>
        
        <form action="DelBook">
        <table border="2" cellspacing="5" cellpadding="25" align="center">
        <caption><h1>Delete Book</h1></caption>        
        <tbody>
                    <tr bgcolor="yellow">
                        <font size='5'>
                        <td><font size='5'>Enter Book Id:
                            <hr><input type="text" name="bid"/>
                            <input size=30 type="submit" value="submit" name="submit"/>
                        </td>    
                            </tr>
                </tbody>
        </table> 
        </form>       
    </body>
    
</html>
