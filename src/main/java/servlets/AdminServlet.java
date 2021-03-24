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

        String op = "";

        if (request.getParameter("op").equals("sort")) {
            op = "sort";
        }
        if (request.getParameter("op").equals("show")) {
            op = "show";
        }
        if (request.getParameter("op").equals("del")) {
            op = "del";
        }
        if (request.getParameter("op").equals("log")) {
            op = "log";
        }

        request.setAttribute("op", op);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/adm.jsp?op="+op);
        requestDispatcher.forward(request, response);


    }
}
