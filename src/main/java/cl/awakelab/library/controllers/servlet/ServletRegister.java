package cl.awakelab.library.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.awakelab.library.controllers.UserController;
import cl.awakelab.library.model.entity.User;

/**
 * Servlet implementation class ServletRegister
 */

@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("SERVELTREGISTER");
    // Crear una instancia del controlador
    UserController userController = new UserController();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(username);
    System.out.println(password);
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
    
    userController.register(newUser.getUsername(), newUser.getPassword());
    
    response.sendRedirect("index.jsp");
}
}
