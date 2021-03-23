<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrate</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-teal">

    		<div class="w3-container w3-orange">
      			<h2>Administrate</h2>
    		</div>
        	<%
                for(int i = 0; i < 10; i++){
                    out.println("<p>" + "Hello : " + i + "</p>");
                }
            %>
    </body>
</html>