<%--
  Created by IntelliJ IDEA.
  User: Даниил Чернышев
  Date: 05.11.2018
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<div>
    <h2>Users</h2>
</div>
    <div>
        <table border="2">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
            </tr>
            <c:forEach items="${users}" var = "user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getAge()}</td>
                    <td>
                        <a href="EditUser?id=${user.getId()}">Edit</a>
                        <a href="DeleteUser?id=${user.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
           <%-- <%
                List<User> names = (List<User>) request.getAttribute("users");

                if (names != null && !names.isEmpty()) {
                    out.println("<ui>");
                    for (User s : names) {
                        out.println("<li>" + s.getId() + "</li>");
                    }
                    out.println("</ui>");
                } else out.println("<p>There are no users yet!</p>");
            %>--%>
        </table>
    </div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>