package servlet;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.kerberos.EncryptionKey;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import controller.AuthenticationController;
import model.Prodotto;
import model.UserAuth;
import repositories.prodotto.ProdottoDAO;
import repositories.user.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sign-up")
public class AuthSignUp extends HttpServlet {
	private static final long serialVersionUID = -6032312325721795555L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String psw = req.getParameter("password");
		String pswConfirm = req.getParameter("confirm-password");

		if(username.isBlank() || psw.isBlank() || pswConfirm.isBlank()) {
			resp.sendRedirect("register.jsp?error=0");
			return;
		}		
		
		if(psw.equalsIgnoreCase(pswConfirm)) {
			Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");//. represents single character  
			Matcher matcher = pattern.matcher(psw);  
			boolean passwordOk = matcher.matches(); 

			if(passwordOk) {
				UserAuth user = new UserAuth(username, psw);
				try {
					new UserDAO().save(user);
					AuthenticationController.authUser(req, resp);
				} catch (SQLIntegrityConstraintViolationException e) {
					resp.sendRedirect("register.jsp?error=3");
				}
			} else {
				resp.sendRedirect("register.jsp?error=2");
				return;
			}
			System.out.println(passwordOk);
		} else {
			resp.sendRedirect("register.jsp?error=1");
		}
		System.out.println(username);
	}
	
}
