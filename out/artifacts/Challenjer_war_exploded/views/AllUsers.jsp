<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-panel w3-teal" style="margin-bottom: 0; margin-top: 0">
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">List Users</h2>
</div>
    <div>
        <table class="w3-table-all w3-hoverable">
            <tr class="w3-gray">
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
                <td>Actions</td>
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
        </table>
    </div> <br/>
    <a class="w3-button w3-teal" href="/">Back to main </a>
</body>
</html>