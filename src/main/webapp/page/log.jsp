<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>Log In</h1>
        <%
            String name = (String) request.getAttribute("name");
            String email = (String) request.getAttribute("email");
            String password = (String) request.getAttribute("password");

            out.println("<p>" + name + "</p>");
            out.println("<p>" + email + "</p>");
            out.println("<p>" + password + "</p>");
        %>
    </body>
</html>