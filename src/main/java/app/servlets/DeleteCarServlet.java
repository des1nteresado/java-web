package app.servlets;

import app.dao.DataAccess;
import app.dao.DataAccessCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idTemp = request.getParameter("id");
        int id = Integer.parseInt(idTemp);
        DataAccessCar da = new DataAccessCar();
        da.delete(id);
        response.sendRedirect("/AllCars");
    }
}
