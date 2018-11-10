package app.servlets.car;

import app.dao.CarDAO;
import app.entities.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/Car/AddCar.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        Car car = new Car(0,name, user_id);
        CarDAO da = new CarDAO();
        da.addNewCar(car);
        resp.sendRedirect("/AllCars");
    }
}
