package servlets;

import service.dto.UserDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/s")
public class MyServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


//        response.setContentType("text/html");
//
//        String varTextA = "Hello World!";
//        request.setAttribute("textA", varTextA);
//        String varTextB = "From Servlet!!";
//        request.setAttribute("textB", varTextB);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
    }
}
