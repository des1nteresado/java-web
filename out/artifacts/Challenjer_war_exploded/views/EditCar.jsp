<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Car</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div>
<div class="w3-panel w3-teal" style="margin-bottom: 0; margin-top: 0">
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">Edit car</h2>
</div>
<div class="w3-panel w3-gray" style="margin-top: 0;">
        <form method="post" class="w3-container">
        <input type="hidden" name="id" value="${car.getId()}">
            <label>Name</label>
            <input type="text" class="w3-input" value="${car.getName()}" name="name" />
            <lable>Age</lable>
            <input type="text" class="w3-input" value="${car.getUser_id()}" name="age" /> <br />
            <div style="display: flex; justify-content: space-between; width: 100%;">
            <input type="submit" class="w3-button w3-teal" value="Edit">
            <a class="w3-button w3-teal" href="/">Back to main </a>
            </div>
        </form>
</div>
</div>
</body>
</html>