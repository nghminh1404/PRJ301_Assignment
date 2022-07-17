<%-- 
    Document   : takeAttendance
    Created on : Jul 17, 2022, 2:17:25 AM
    Author     : PC
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="now" class="java.util.Date" />
        <fmt:formatDate var="time" type = "both" 
                        value = "${now}" pattern="HH:mm:ss" /> 
        <c:set var="index" value="${1}"></c:set>
            <form method="POST" action="TakeAttendance">
                <table class="sortable table" >
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Group</th>
                            <th>Code</th>
                            <th>Full name</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.students}" var="s">
                        <tr>
                            <td>${index}</td>
                    <input type="text" value="${index}" name="index" hidden/>
                    <td>${s.group.groupname}</td>
                    <td>${s.sid}</td>
                    <input type="text" value="${s.sid}" name="sid${index}" hidden/>
                    <td>${s.fullName}</td>
                    <td>${s.email}</td>
                    <td>
                        <input type="radio" value="true" name="status${index}"/>Present
                        <input type="radio" value="false" checked name="status${index}"/>Absent
                    </td>
                    <td>
                        <input type="text" name="description${index}"/>
                    </td>
                    <input type="text" value="${time}" name="recordtime${index}" hidden/>
                    </tr>
                    <c:set var="index" value="${index+1}"></c:set>
                </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
