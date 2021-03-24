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

    		<div class="w3-center w3-teal">
                <div class="w3-bar w3-padding-large w3-padding-64">
                    <button style="border:8px solid white" class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green" onclick="location.href='/aji/adm?op=del'">Delete</button>
                    <button style="border:8px solid white" class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green" onclick="location.href='/aji/adm?op=sort'">Sort</button>
                    <button style="border:8px solid white" class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green" onclick="location.href='/aji/adm?op=show'">Show all users</button>
                </div>
            </div>

            <%
                String a = request.getParameter("op");
            %>

            <%= a %>

            <c:choose>
                <c:when test="${a == sort}">
                   sort
                </c:when>
                <c:when test="${a == del}">
                    del
                </c:when>
                <c:when test="${a == show}">
                    show
                </c:when>
                <c:otherwise>
                    Не выбрано ни одно условие.
                </c:otherwise>
            </c:choose>


            <% if (a.equals("sort)") { %>
                 <div>sort</div>

               <% } else { %>
               <div>textbox value..</div>
                <% } %>

    </body>
</html>