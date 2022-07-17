<%-- 
    Document   : confirmPage
    Created on : Jul 17, 2022, 12:30:41 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
        <script>
            var count = 3;
            function redirect()
            {
                count--;
                document.getElementById('timer').innerHTML = count;
                if (count <= 0)
                    window.location.href = 'sessiontoday';
            }
            setInterval(redirect, 1000);
        </script>
    </head>
    <body>
        <h1>${requestScope.action} Attendance Successfully!</h1>
        <b>Redirect to home page after <span id="timer">3</span> seconds</b>
    </body>
</html>
