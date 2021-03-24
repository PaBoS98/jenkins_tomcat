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

            <p>${active}</p>

    		<c:if test="${i == 1}" >
                1
    		</c:if>

    		<c:if test="${i == 0}" >
                0
            </c:if>

            <c:choose>
                <c:when test="${i == 1}">
                   Переменная alter 1
                </c:when>
                <c:when test="${i == 0}">
                    Переменная alter 0
                </c:when>
                <c:otherwise>
                    Не выбрано ни одно условие.
                </c:otherwise>
            </c:choose>
    </body>
</html>