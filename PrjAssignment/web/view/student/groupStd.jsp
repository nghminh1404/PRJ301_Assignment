<%-- 
    Document   : groupStd
    Created on : Jun 21, 2022, 4:51:19 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function removeEmp(sid)
            {
                var result = confirm('are you sure?');
                if(result)
                {
                    window.location.href = 'delete?id='+sid;
                }
            }
        </script>
    </head>
    <body>
        <form id="frmSearch" action="group" method="POST">
            Group: <select name="gid" 
                                onchange="document.getElementById('frmSearch').submit();">
                <c:forEach items="${requestScope.grs}" var="g">
                    <option 
                        <c:if test="${param.gid eq g.gid}">
                            selected="selected"
                        </c:if>
                        value="${g.gid}">${g.groupname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Take attendance"/>
        </form>
        <c:if test="${requestScope.stds ne null}">
            <table>
                <tr>
                    <td>Id</td>
                    <td>member code</td>
                    <td>Full name</td>
                    <td>Group</td>
                    <td>Status</td>
                    <td>Description</td>
                </tr>
                <c:forEach items= "${requestScope.stds}" var="e"> 
                    <tr>
                        <td>${e.sid}</td>
                        <td>${e.memberCode}</td>
                        <td>${e.fullName}</td>
                        <td>${e.group.groupname}</td>
                        <td><input type="radio" name="status" value="present"/>Present
                            <input type="radio" name="status" checked="checked" value="absent"/>Absent</td>
                        <td><input type="text" name="description"/></td>
                        <td><input type="hidden" a href="update?id=${e.sid}"></a></td>
                        <td><input type="button" hidden value="Delete" onclick="removeEmp(${e.sid})"></td>
                    </tr>
                </c:forEach>    
            </table>
        </c:if>
        <input type="submit" value="save"/>
    </body>
</html>

