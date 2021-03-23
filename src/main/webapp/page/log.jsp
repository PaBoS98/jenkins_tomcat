<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>Log In</h1>
        <%
            String name = request.getAttribute("name");
            String email = request.getAttribute("email");
            String password = request.getAttribute("password");

            out.println("<p>" + name + "</p>");
            out.println("<p>" + email + "</p>");
            out.println("<p>" + password + "</p>");
        %>
    </body>
</html>