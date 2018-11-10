<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Cars</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-panel w3-teal" style="margin-bottom: 0; margin-top: 0">
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">List of cars</h2>
</div>
    <div>
        <table class="w3-table-all w3-hoverable">
            <tr class="w3-gray">
                <td>ID</td>
                <td>Name</td>
                <td>User name(id)</td>
                <td>Actions</td>
            </tr>
            <c:forEach items="${cars}" var = "car">
                <tr>
                    <td>${car.getId()}</td>
                    <td>${car.getName()}</td>
                    <td>${car.getUser_name()}(${car.getUser_id()})</td>
                    <td>
                        <a href="EditCar?id=${car.getId()}">Edit</a>
                        <a href="DeleteCar?id=${car.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> <br/>
    <a class="w3-button w3-teal" href="/">Back to main </a>
</body>
</html>