package app.servlets;

import app.dao.DataAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        {
            String idTemp = request.getParameter("id");
            int id = Integer.parseInt(idTemp);
            request.setAttribute("getUserById", DataAccess.getUserById(id));
            RequestDispatcher rd = request.getRequestDispatcher("views/EditUser.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

}
