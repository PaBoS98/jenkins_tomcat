package service.command;

import service.ConnectionManager;
import service.Entity.User;
import service.Requests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Registration implements Command {

    @Override
    public RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException, ServletException, IOException {
        if (type.equals("post")) {
            Requests r = new Requests(ConnectionManager.getConnection());

            User user = new User.Builder()
                    .setName(request.getParameter("name"))
                    .setEmail(request.getParameter("email"))
                    .setPassword(request.getParameter("pass")).build();
            r.createUser(user);
            return request.getRequestDispatcher("/");
        } else if (type.equals("get")) {
            return request.getRequestDispatcher("page/reg.jsp");
        }
        return null;
    }
}
