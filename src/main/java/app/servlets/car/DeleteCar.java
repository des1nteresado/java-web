package app.servlets.car;

import app.dao.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idTemp = request.getParameter("id");
        int id = Integer.parseInt(idTemp);
        CarDAO da = new CarDAO();
        da.delete(id);
        response.sendRedirect("/AllCars");
    }
}
