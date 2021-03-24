<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Administrate</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-teal">

    		<div class="w3-container w3-orange">
      			<h2>Administrate</h2>
    		</div>

            <%request.getSession().getAttribute("active")%>

            <c:set var="user" scope="session" value="test"  />
            <c:out value="${user}" />

            <c:if test="${user} == test">
                <c:out value="14214124" />
            </c:if>

            <c:out value="52145212" />
    </body>
</html>