<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h3>Spring Rest Demo</h3>
        <hr>
        <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
        <br><br>
        <a href="${pageContext.request.contextPath}/api/students">All Student List</a>
    </body>
</html>