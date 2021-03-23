package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/s")
public class MyServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("HI");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        long id = request.getDateHeader("id");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("pass");


//        writer.println("HELLO! " + name);
//        writer.println("Your account");
//        writer.println("id " + id);
//        writer.println("name " + name);
//        writer.println("email " + email);
//        writer.println("password " + password);

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
