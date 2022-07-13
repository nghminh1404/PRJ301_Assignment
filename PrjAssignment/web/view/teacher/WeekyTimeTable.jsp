<%-- 
    Document   : wekkTimeTable
    Created on : Jun 29, 2022, 12:17:26 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
           <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/pagger.js" type="text/javascript"></script>
        <link href="../css/pagger.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="top_pagger" class="pagger"></div>
        <table>
            <tr>
                <td>Id</td>
            </tr>
            <c:forEach items= "${requestScope.calendar}" var="d"> 
                <tr>
                    <td>${d.date}</td>
                </tr>
            </c:forEach>    
        </table>
        <div id="bot_pagger" class="pagger"></div>
        <script>
            pagger_render("top_pagger",${requestScope.pageindex},${requestScope.totalpage},2);
            pagger_render("bot_pagger",${requestScope.pageindex},${requestScope.totalpage},2);
        </script>
    </body>
</html>
