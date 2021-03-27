package service.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AdministrateAuthorization implements Command {
    @Override
    public RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException {

        if (type.equals("post")) {
            if (request.getParameter("pass") != null && request.getParameter("pass").equals("1")){
                return request.getRequestDispatcher("page/adm.jsp");
            }
        } else if (type.equals("get")) {
            return request.getRequestDispatcher("page/admLog.jsp");
        }
        return null;
    }
}
