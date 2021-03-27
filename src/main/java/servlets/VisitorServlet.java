package servlets;

import lombok.SneakyThrows;
import service.command.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class VisitorServlet extends HttpServlet {

    private String action;
    public static Map<String, Command> actions = new HashMap<>();

//    @Override
//    public void init() throws ServletException {
//        actions.put("reg", new Registration());
//        actions.put("log", new Authorization());
//        actions.put("admLog", new AdministrateAuthorization());
//        actions.put("del", new Delete());
//        super.init();
//    }
    static {
        actions.put("reg", new Registration());
        actions.put("log", new Authorization());
        actions.put("admLog", new AdministrateAuthorization());
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        action = request.getParameter("action");
        actions.get(action).action(request, response, "post").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        action = request.getParameter("action");
        actions.get(action).action(request, response, "get").forward(request, response);
    }
}
