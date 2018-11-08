package app.servlets.user;

import app.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idTemp = request.getParameter("id");
        int id = Integer.parseInt(idTemp);
        UserDAO da = new UserDAO();
        if(da.delete(id))
        {
            response.sendRedirect("/AllUsers");
            System.out.println("ok");
        }
        else
            response.sendError(523, "You can not delete this user!");
        /*else
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/AllUsers.jsp");
            requestDispatcher.forward(request, response);
        }*/
    }

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", id);
    }*/
}
