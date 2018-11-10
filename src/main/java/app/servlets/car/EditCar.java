package app.servlets.car;

import app.dao.CarDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("car", CarDAO.getCarById(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/Car/EditCar.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        CarDAO da = new CarDAO();
        da.editCar(id, name, user_id);
        resp.sendRedirect("/AllCars");
    }

}
