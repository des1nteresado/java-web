<%@ page import="app.entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="app.dao.DataAccess" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.sql.*" %>
<%@ page import="app.db.DBUtils" %><%--
  Created by IntelliJ IDEA.
  User: Даниил Чернышев
  Date: 05.11.2018
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>Имя</td>
                <td>Возраст</td>
            </tr>
            <c:forEach items="${users}" var = "user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getAge()}</td>
                    <td>
                        <a href="EditUser?id=${p.id}">Edit</a>
                        <a href="DeleteUser?id=${p.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

        <%--<%

            String url = "jdbc:mysql://localhost:3306/userdb"+
                    "?verifyServerCertificate=false"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "&amp"+
                    "&serverTimezone=UTC";
            try {
                Connection connection = DriverManager.getConnection(url,"root","123123qQ");
            } catch (SQLException err)
            {
                System.out.println("error");
            }

            List<User> ls = new LinkedList<User>();

            try {
                ResultSet rs = DBUtils.getPreparedStatement("select * from users").executeQuery();
                while(rs.next())
                {
                    User c = new User(rs.getInt(1), rs.getString(2), rs.getInt(3));
                    ls.add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out.println("<ui>");
            for(User us : ls)
            {
                    out.println("<li>" + us.toString() + "</li>");
            }
            out.println("</ui>");
        %>--%>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>