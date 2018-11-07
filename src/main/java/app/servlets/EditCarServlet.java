package app.servlets;

import app.dao.DataAccess;
import app.dao.DataAccessCar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("car", DataAccessCar.getCarById(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/EditCar.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        DataAccessCar da = new DataAccessCar();
        da.edit(id, name, user_id);
        resp.sendRedirect("/AllCars");
    }

}
