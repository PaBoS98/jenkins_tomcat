package service.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@FunctionalInterface
public interface Command {
    RequestDispatcher action(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException, ServletException, IOException;
}
