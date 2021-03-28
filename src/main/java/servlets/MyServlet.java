package servlets;

import service.dto.UserDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute("user");

        PrintWriter writer = response.getWriter();

        writer.println("HELLO! " + user.getName());
        writer.println("Your account");
        writer.println("id " + user.getId());
        writer.println("name " + user.getName());
        writer.println("email " + user.getEmail());
        writer.println("password " + user.getPassword());
    }
}
