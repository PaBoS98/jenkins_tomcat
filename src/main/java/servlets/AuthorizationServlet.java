package servlets;

import lombok.SneakyThrows;
import service.ConnectionManager;
import service.Entity.User;
import service.Requests;
import service.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Requests r = new Requests(new ConnectionManager().getConnection());

        UserDto user = r.findUser(
                request.getParameter("name"),
                request.getParameter("pass")
                );

//        request.setAttribute("id", user.getId());
//        request.setAttribute("name", user.getName());
//        request.setAttribute("email", user.getEmail());
//        request.setAttribute("pass", user.getPassword());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/log.jsp");
        requestDispatcher.forward(request, response);
    }
}
