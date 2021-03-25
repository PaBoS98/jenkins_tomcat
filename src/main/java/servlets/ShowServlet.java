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
import java.util.List;

public class ShowServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Requests r = new Requests(ConnectionManager.getConnection());
        List<UserDto> users = r.showAllUser();

        req.setAttribute("users", users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("page/show.jsp");
        requestDispatcher.forward(req, resp);
    }
}
