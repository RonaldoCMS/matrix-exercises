package servlet;

import java.io.IOException;

import controller.AuthenticationController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-in")
public class AuthSignIn extends HttpServlet{
	private static final long serialVersionUID = -2473811518440263415L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	AuthenticationController.authUser(req, resp);
    }

}
