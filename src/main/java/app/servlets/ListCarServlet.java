package app.servlets;

import app.dao.DataAccess;
import app.dao.DataAccessCar;
import app.entities.Car;
import app.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Car> cars = DataAccessCar.getAll();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("views/AllCars.jsp").forward(request, response);
    }


}
