package service.command;

import service.ConnectionManager;
import service.Requests;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Delete implements Command {
    @Override
    public RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException {

        if (request.getParameter("id") != null) {
            Requests r = new Requests(ConnectionManager.getConnection());
            r.deleteUser(Integer.parseInt(request.getParameter("id")));
            return request.getRequestDispatcher("adm?action=show");
        }

        return null;
    }
}
