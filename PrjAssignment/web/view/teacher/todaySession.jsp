<%-- 
    Document   : todaySession
    Created on : Jul 15, 2022, 1:11:28 AM
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
        <nav>
            <input type="checkbox" id="show-menu" role="button">
            <label for="show-menu" class="open"><span class="fa fa-bars"></span></label>
            <label for="show-menu" class="close"><span class="fa fa-times"></label>
            <ul id="menu">
                <li><a class="active" href="home">Home</a></li>
                <li><a href="#">${sessionScope.account.displayname}</a></li>
                <li><a href="login">Sign out</a></li>
            </ul>
        </nav>
        <!-- // -->
        <!-- Banner -->
        <div id="banner">
            <div id="header">
                <h1>FPT University Academic Portal</h1>
            </div>
        </div>
        <table>
    <thead>
        <tr class="bg-light-gray">
            <th class="text-uppercase">Time</th>
            <th class="text-uppercase">Room</th>
            <th class="text-uppercase">Group</th>
            <th class="text-uppercase">Course</th>
        </tr>
    </thead>
    <tbody>
   
    <c:forEach items="${requestScope.sessions}" var="se" varStatus="loop">
        <tr>
            <td>
                ${se.timeslot.startTime} - ${se.timeslot.endTime} ${se.date}
            </td>
            <td>
                ${se.room.room}
            </td>
            <td>
                ${se.groupID.groupname}
            </td>
            <td>
                ${se.groupID.course.name} (${se.groupID.course.id})
            </td>
            <c:if test="${not requestScope.check[loop.index]}">
                <td>
                    <a href="TakeAttendance?group=${se.groupID.gid}&session=${se.sessionID}"> Take </a>
                </td>
            </c:if>
            <c:if test="${requestScope.check[loop.index]}">
                <td>
                    <a href="ViewAttendance?session=${se.sessionID}"> View </a>
                </td>
                <td>
                    <a href="EditAttendance?session=${se.sessionID}"> Edit </a>
                </td>
            </c:if>
        </tr>


    </c:forEach>
</tbody>
</table>
</body>
</html>
