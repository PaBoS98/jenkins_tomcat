<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Administrate</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-teal">

    		<div class="w3-container w3-orange">
      			<h2>Administrate</h2>
    		</div>
    		<%boolean active=request.getSession().getAttribute("active"); %>
        	<c:choose>
                <c:when active=true>
                    I see!  You  have a name.. well.. Hello
                </c:when>
                <c:otherwise>
                    I see!  You don't have a name.. well.. Hello no name
                </c:otherwise>
            </c:choose>

    </body>
</html>