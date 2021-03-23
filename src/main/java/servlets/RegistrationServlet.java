package servlets;

import lombok.SneakyThrows;
import service.ConnectionManager;
import service.Entity.User;
import service.ReadFromProperties;
import service.Requests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Requests r = new Requests(new ConnectionManager().getConnection(
                ReadFromProperties.getURL(),
                ReadFromProperties.getUserName(),
                ReadFromProperties.getPASSWORD()
        ));

        User user = new User.Builder()
                .setName(request.getParameter("name"))
                .setEmail(request.getParameter("email"))
                .setPassword(request.getParameter("pass")).build();
        r.createUser(user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Registration");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("page/reg.jsp");
        requestDispatcher.forward(request, response);
    }
}
