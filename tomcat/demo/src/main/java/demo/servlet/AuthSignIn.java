package demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import demo.controller.AuthenticationController;
import demo.model.Prodotto;
import demo.model.UserAuth;
import demo.repositories.prodotto.ProdottoDAO;
import demo.repositories.user.UserDAO;
import demo.utils.DBUtil;
import jakarta.servlet.RequestDispatcher;
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
