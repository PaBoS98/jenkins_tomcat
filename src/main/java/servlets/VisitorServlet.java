package servlets;

import lombok.SneakyThrows;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.composite.Compound;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisitorServlet extends HttpServlet {

    private String action;
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("context/ApplicationContext.xml");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        action = request.getParameter("action");
        context.getBean(Compound.class).execute(action, request, response, "post").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        action = request.getParameter("action");
        context.getBean(Compound.class).execute(action, request, response, "get").forward(request, response);
    }
}
