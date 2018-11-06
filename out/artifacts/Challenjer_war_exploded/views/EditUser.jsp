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
        <form method="post">
            <input type="hidden" name="id" value="${user.getId()}">
            Name:<br>
            <input type="text" value="${user.getName()}" name="name" ><br>
            Age:<br>
            <input type="text" value="${user.getAge()}" name="age" ><br>
            <input type="submit" value="Edit">
        </form>
</div>
</body>
</html>
