package app.servlets.user;

import app.dao.UserDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", UserDAO.getUserById(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/User/EditUser.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        UserDAO da = new UserDAO();
        da.editUser(id, name, age);
        resp.sendRedirect("/AllUsers");
    }

}
