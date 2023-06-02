package cl.awakelab.library.controllers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.awakelab.library.controllers.UserController;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    UserController user = new UserController();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String result = user.login(username, password);
		
		if(!result.equals("false")) {
		  guardarCredenciales(username, password, response);
		  HttpSession session = request.getSession(); // cada vez que inicia session esto se crea de manera automatica
		  session.setAttribute("usuario", username);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	

	private void guardarCredenciales(String username, String password, HttpServletResponse response) {
	 
	  Cookie ck = new Cookie("credenciales", username);
	  ck.setMaxAge(10000);
	  response.addCookie(ck);
	}

}
