package demo.servlet;

import java.io.IOException;

import demo.controller.AuthenticationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-out")
public class AuthSignOut extends HttpServlet{
	private static final long serialVersionUID = -2473811518440263415L;
	
	public void signOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	if(req.getSession().getAttribute("login") != null) {
    		req.getSession().removeAttribute("login");
    	}
    	resp.sendRedirect("");
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	signOut(req, resp);
    }

}