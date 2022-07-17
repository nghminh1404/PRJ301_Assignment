<%-- 
    Document   : EditAttendance
    Created on : Jul 17, 2022, 1:34:27 AM
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
        <form action="EditAttendance" method ="POST">
            <table class="sortable table" >
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Group</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Status</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${requestScope.attendances}" var="a">
                        <tr>
                            <td>${index}</td>
                            <input type="text" value="${index}" name="index" hidden/>
                            <td>${a.sessionID.groupID.groupname}</td>
                            <td><input type="hidden" name="sid${index}" value="${a.studentID.sid}"/>${a.studentID.sid}</td>
                            <td>${a.studentID.fullName}</td>
                            <td>${a.studentID.email}</td>
                            <td>
                                <input type="radio" <c:if test="${a.status eq true}">checked="checked"</c:if> name="status${index}" value="true"/> Present
                                <input type="radio" <c:if test="${a.status eq false}">checked="checked"</c:if> name="status${index}" value="false"/> Absent 
                            </td>
                            <td><input type="text" name="description${index}" value="${a.description}"></td>
                    <input type="text" value="${time}" name="recordtime${index}" hidden/>
                    </tr>
                    <c:set var="index" value="${index+1}"></c:set>
                </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
