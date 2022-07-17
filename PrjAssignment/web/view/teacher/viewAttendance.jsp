<%-- 
    Document   : takeatd
    Created on : Jun 20, 2022, 2:51:57 PM
    Author     : PC
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .sortable table
{
    text-align: center;
    border-width: 1px;
    border-style: solid;
    border-color: blue;
    padding: 2px;
    margin-left: 2px;
}
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Attendance Page</title>
    </head>
    <body>
        <table class="sortable table" >
            <thead>
                <tr>
                    <th>No</th>
                    <th>Group</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Comment</th>
                    <th>Taker</th>
                    <th>Record Time</th> 
                </tr>
            </thead>
            <tbody>
                <c:set var="index" value="${1}"></c:set>
                <c:forEach items="${requestScope.attendances}" var="a">
                    <tr>

                        <td>${index}</td>
                        <td>${a.sessionID.groupID.groupname}</td>
                        <td>${a.studentID.sid}</td>
                        <td>${a.studentID.fullName}</td>
                        <td>${a.studentID.email}</td>
                            <c:if test="${a.status eq true}">
                                <td style="color: green;">Present</td>
                            </c:if>
                            <c:if test="${a.status eq false}">
                                <td style="color: red;">Absent</td>
                            </c:if>
                        <td>${a.description}</td>
                        <td>${a.sessionID.instructor.id}</td>
                        <td>${a.sessionID.date} ${a.recordTime}</td>                       
                    </tr>
                    <c:set var="index" value="${index+1}"></c:set>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
