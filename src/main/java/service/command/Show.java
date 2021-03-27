package service.command;

import service.ConnectionManager;
import service.Requests;
import service.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Show implements Command {
    @Override
    public RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException, ServletException, IOException {
        Requests r = new Requests(ConnectionManager.getConnection());
        List<UserDto> users = r.showAllUser();
        request.setAttribute("listUser", users);
        return request.getRequestDispatcher("page/show.jsp");

    }
}
