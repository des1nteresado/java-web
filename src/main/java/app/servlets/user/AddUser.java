package app.servlets.user;

import app.dao.UserDAO;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/User/AddUser.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(0,name, age);
        UserDAO da = new UserDAO();
        da.addNewUser(user);
        resp.sendRedirect("/AllUsers");
    }
}
