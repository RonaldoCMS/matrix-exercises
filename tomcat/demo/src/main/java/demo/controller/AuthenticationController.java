package demo.controller;

import java.io.IOException;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import demo.model.Prodotto;
import demo.model.UserAuth;
import demo.repositories.prodotto.ProdottoDAO;
import demo.repositories.user.UserDAO;
import demo.utils.MyConstants;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationController {
	public static void authUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserAuth userAuth = new UserDAO().findByUsername(username);
        
		if(userAuth != null) {
			// StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
			// encryptor.setPassword(MyConstants.keySecurity);
			// String decrypted = encryptor.decrypt(userAuth.getPassword());
			// System.out.println("DECRYPT:"+ decrypted);
			if(userAuth.getPassword().equalsIgnoreCase(password)) {
				req.setAttribute("user", userAuth);
				List<Prodotto> prodotti = new ProdottoDAO().findAll();
				req.getSession().setAttribute("prodotti", prodotti);
			    resp.sendRedirect("home.jsp");
			} else {
			    resp.sendRedirect("index.jsp?error=2");
			}
		} else {
		    resp.sendRedirect("index.jsp?error=2");
		}
	}
}
