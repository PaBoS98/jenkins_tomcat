package servlets;

import lombok.SneakyThrows;
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

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("pass").equals("123456789")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/adm.jsp");
            requestDispatcher.forward(request, response);
        }

        if (request.getParameter("op").equals("del")) {
//            Requests r = new Requests(ConnectionManager.getConnection());
//            r.deleteUser(5);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/d");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String op = "";

        if (request.getParameter("op").equals("sort")) {
//            op = "sort";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/sort.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("op").equals("show")) {
//            op = "show";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/show.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("op").equals("del")) {
//            op = "del";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/delete.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("op").equals("log")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/admLog.jsp");
            requestDispatcher.forward(request, response);
        }

//        request.setAttribute("op", op);

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/adm.jsp?op="+op);
//        requestDispatcher.forward(request, response);


    }
}
