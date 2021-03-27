package service.command;

import service.ConnectionManager;
import service.Requests;
import service.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Authorization implements Command {
    @Override
    public RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException, ServletException, IOException {

        if (type.equals("post")) {
            Requests r = new Requests(new ConnectionManager().getConnection());
            UserDto user = r.findUser(
                    request.getParameter("name"),
                    request.getParameter("pass")
            );
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return request.getRequestDispatcher("/user");
        } else if (type.equals("get")) {
           return request.getRequestDispatcher("page/log.jsp");
        }

        return null;
    }
}
