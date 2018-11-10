package app.servlets.car;

import app.dao.CarDAO;
import app.entities.Car;
import app.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Car> cars = CarDAO.getAllCars();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("views/Car/AllCars.jsp").forward(request, response);
    }


}
