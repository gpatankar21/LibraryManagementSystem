<%-- 
    Document   : Logout
    Created on : 25 Jul, 2018, 10:15:54 AM
    Author     : GAGAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%  
                response.setHeader("Pragma","no-cache");
                response.setHeader("Cache-Control","no-store");
                response.setHeader("Expires","0");
                response.setDateHeader("Expires",-1);
                session.invalidate();
                               
            %>
            <a href="index.jsp">Logout</a>
        </h1>
    </body>
</html>
