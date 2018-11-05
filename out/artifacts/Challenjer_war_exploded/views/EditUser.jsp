<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<div>
    <c:forEach items="${getUserById}" var="p">
        <form method="post">
            <input type="hidden" name="id" value="${p.id}">
            Name:<br>
            <input type="text" value="${p.name}" name="name" ><br>
            Age:<br>
            <input type="text" value="${p.age}" name="age" ><br>
            <input type="submit" value="Edit">
        </form>
    </c:forEach>
</div>
</body>
</html>
