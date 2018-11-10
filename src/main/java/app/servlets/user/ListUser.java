package app.servlets.user;

import app.dao.UserDAO;
import app.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = UserDAO.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("views/User/AllUsers.jsp").forward(request, response);
    }


}
