<%@ page import="service.dto.UserDto" %>
<%@ page import="java.util.List" %>

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
        <button style="border:8px solid white"
                class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green"
                onclick="location.href='/aji/adm?action=sort'">Sort
        </button>
        <button style="border:8px solid white"
                class="w3-xlarge w3-white w3-round-large w3-hover-shadow w3-hover-border-green"
                onclick="location.href='/aji/adm?action=show'">Show all users
        </button>
    </div>
</div>

<table class="w3-table-all w3-hoverable w3-card-4">
    <tr class="w3-red">
        <th class="w3-center ">ID</th>
        <th class="w3-center">Name</th>
        <th class="w3-center">Email</th>
        <th class="w3-center">Password</th>
        <th class="w3-center"></th>
    </tr>

    <%
        List<UserDto> userList = (List<UserDto>) request.getAttribute("listUser");
        for (UserDto u : userList) {
    %>
    <tr>
        <td style="padding-top: 25px" class="w3-center w3-text-black"><%= u.getId()%>
        </td>
        <td style="padding-top: 25px" class="w3-center w3-text-black"><%= u.getName()%>
        </td>
        <td style="padding-top: 25px" class="w3-center w3-text-black"><%= u.getEmail()%>
        </td>
        <td style="padding-top: 25px" class="w3-center w3-text-black"><%= u.getPassword()%>
        </td>
        <td class="w3-center w3-text-black w3-hover-red">
            <form method="post" action="adm?action=del">
                <button class="w3-button w3-large w3-circle w3-red w3-card-4">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                         class="bi bi-person-x-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6.146-2.854a.5.5 0 0 1 .708 0L14 6.293l1.146-1.147a.5.5 0 0 1 .708.708L14.707 7l1.147 1.146a.5.5 0 0 1-.708.708L14 7.707l-1.146 1.147a.5.5 0 0 1-.708-.708L13.293 7l-1.147-1.146a.5.5 0 0 1 0-.708z"/>
                    </svg>
                </button>
                <input type="hidden" name="id" value="<%= u.getId()%>"/>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<footer style="width:100%; padding: 10px;">
    <button style="border:8px solid white" class="w3-jumbo w3-red w3-round-large w3-hover-shadow w3-hover-border-green"
            onclick="location.href='/aji'">Back to menu
    </button>
</footer>
</body>
</html>