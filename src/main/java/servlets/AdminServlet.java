package servlets;

import service.ConnectionManager;
import service.Requests;
import service.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("pass").equals("123456789")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/adm.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/admLog.jsp");
        requestDispatcher.forward(request, response);
    }
}
