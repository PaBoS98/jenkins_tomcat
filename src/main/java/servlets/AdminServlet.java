package servlets;

import lombok.SneakyThrows;
import service.Requests;
import service.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminServlet extends HttpServlet {
    static Map<String, Command> actions = new HashMap<>();
    static {

        actions.put("del", new Delete());
        actions.put("sort", new Sort());
        actions.put("show", new Show());
        actions.put("admLog", new AdministrateAuthorization());
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        actions.get(request.getParameter("action")).action(request, response, "post").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

//        VisitorServlet.actions.get(action).action(request, response, "get").forward(request, response);
        actions.get(action).action(request, response, "get").forward(request, response);
    }
}
