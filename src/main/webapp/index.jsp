<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shop</title>
    </head>
    <body>
        <h1>Log In</h1>
        <p><%= AuthorizationServlet.request.getParameter("name") %></p>
    </body>
</html>