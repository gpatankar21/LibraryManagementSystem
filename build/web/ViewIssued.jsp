<%-- 
    Document   : ViewIssued
    Created on : 22 Jun, 2018, 11:01:08 PM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Issued Books</title>
    </head>
    <body>
        <h1>To View Issued Books</h1>
        <form action="ViewIssued">
        <table>
                <tbody>
                    <tr>
                        <td>Enter Username:<hr><input type="text" name="uid"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="submit" name="submit"/></td>
                    </tr>
                </tbody>
        </table> 
        </form>
    </body>
</html>
