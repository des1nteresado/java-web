<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div>
    <div class="w3-panel w3-teal" style="margin-bottom: 0; margin-top: 0">
        <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">Add new user's car</h2>
    </div>
    <div class="w3-panel w3-gray" style="margin-top: 0;">
        <form method="post" class="w3-container">
            <label> Name </label>
            <input type="text" class="w3-input" name="name"/>
            <label> User ID </label>
            <input type="text" class="w3-input" name="user_id"/> <br />
            <div style="display: flex; justify-content: space-between; width: 100%;">
                <button type="submit" class="w3-button w3-teal">Add</button>
                 <a class="w3-button w3-teal" href="/">Back to main </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
