<%-- 
    Document   : list
    Created on : Jun 21, 2022, 1:57:16 AM
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
            <table action ="list">
                <tr>
                    <td>Id</td>
                    <td>Member code</td>
                    <td>First name</td>
                    <td>Middle name</td>
                    <td>Last name</td>
                    <td>Status</td>
                    <td>Description</td>
                </tr>
                <c:forEach items= "${requestScope.student}" var="s"> 
                    <tr>
                        <td>${s.sid}</td>
                        <td>${s.memberCode}</td>
                        <td>${s.firstName}</td>
                        <td>${s.middleName}</td>
                        <td>${s.lastName}</td>
                        <td><input type="radio" checked="checked" name="status" value="present"/>Present
                        <input type="radio" name="status" value="Absent"/>Absent</td>
                        <td><input type="text" name="description"/></td>
                    </tr>
                </c:forEach>    
            </table>
            <br>
            <input type = "submit" value="Save" />
    </body>
</html>
