<%-- 
    Document   : login
    Created on : May 27, 2022, 3:27:05 PM
    Author     : Ngo Tung Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username:<input type="text" name="user"/> <br/>
            Password: <input type="password" name ="pass" /> <br/>
            <input type="submit" value="Login"/>
        </form>
        <c:if test="${resquestScope.status eq false}">
   <c:out value="Wrong password or username"/>
</c:if>
    </body>
</html>
