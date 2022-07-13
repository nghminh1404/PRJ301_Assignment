<%-- 
    Document   : testDate
    Created on : Jul 11, 2022, 11:35:25 AM
    Author     : PC
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
        <table>
            <tr>
                <td>Id</td>
            </tr>
            <c:forEach items= "${requestScope.calendar}" var="s"> 
                <tr>
                    <td>${s.date}</td>
                </tr>
            </c:forEach>    
        </table>
    </body>
</html>
