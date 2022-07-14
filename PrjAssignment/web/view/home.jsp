<%-- 
    Document   : home
    Created on : Jul 13, 2022, 2:18:48 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
        <div class="Order">
            <div class="Order-title">
                <h3 style="color: #56baed;">Reports</h3>
            </div>
            <div class="Order-list"> 
                <li>${sessionScope.account.insid}</li>
                    <a href="timetable?name=${sessionScope.account.username}">Weekly timetable</a><br>
                    <c:if test="${sessionScope.account.isAdmin eq false}">
                        <a href="attendanceview?sid=${sessionScope.account.username}">Attendance report</a>
                    </c:if>
                    <c:if test="${sessionScope.account.isAdmin eq true}">
                        <a href="sessiontoday?instructorid=${sessionScope.account.username}">Take Attendance</a><br>                        
                    </c:if>
                    
            </div>                
        </div>
    
    </body>
</html>
