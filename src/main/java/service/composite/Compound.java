package service.composite;

import org.springframework.stereotype.Component;
import service.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Compound {
    private Map<String, Command> actionList;

    private void load() {
        actionList = new HashMap<>();
        actionList.put("reg", new Registration());
        actionList.put("log", new Authorization());
        actionList.put("admLog", new AdministrateAuthorization());
        actionList.put("del", new Delete());
        actionList.put("sort", new Sort());
        actionList.put("show", new Show());
    }

    public RequestDispatcher execute(String tag, HttpServletRequest request, HttpServletResponse response, String type) throws ServletException, SQLException, IOException {
        return actionList.get(tag).action(request, response, type);
    }
}
