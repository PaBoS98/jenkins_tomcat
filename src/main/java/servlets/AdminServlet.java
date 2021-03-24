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
import java.io.PrintWriter;

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

        PrintWriter p = response.getWriter();

        if (request.getParameter("op").equals("sort")) p.print("sort");
        if (request.getParameter("op").equals("show")) p.print("show");
        if (request.getParameter("op").equals("del")) p.print("del");
        if (request.getParameter("op").equals("log")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/admLog.jsp");
            requestDispatcher.forward(request, response);
        }


    }
}
