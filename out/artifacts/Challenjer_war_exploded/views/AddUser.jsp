<%--
  Created by IntelliJ IDEA.
  User: Даниил Чернышев
  Date: 04.11.2018
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<div>
    <div>
        <h2>Add user</h2>
    </div>
    <div>
        <form method="post">
            <label>
                Name:
                <input type="text" name="name"/> <br />
            </label>
            <label>
                Age:
                <input type="text" name="age"/> <br />
            </label>
            <button type="submit">Add</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
