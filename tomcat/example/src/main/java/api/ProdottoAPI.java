package api;

import java.io.IOException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import repositories.prodotto.ProdottoJSONDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/prodotto/*")
public class ProdottoAPI extends HttpServlet {
	private static final long serialVersionUID = -6173141552243899328L;
	private static final String APPLICATION_JSON = "application/json";
	private ProdottoJSONDAO dao;
	
	public ProdottoAPI() {
		dao = new ProdottoJSONDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("pswsecurity");
		String decrypted = encryptor.decrypt("Cm5vkDoN4XsvCgZ/lexPh43Uj1Uyh9MGdPt/u+gaqqgoq8IeW/AzvhdCMWJtLCHx");
		
		System.out.println(decrypted);

		resp.setContentType(APPLICATION_JSON);
		try {
			if (req.getPathInfo() == null || "/".equals(req.getPathInfo())) {
				dao.findAll(resp);
			} else if (req.getPathInfo().split("/").length > 1) {
				int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
				dao.findById(id, resp);
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(APPLICATION_JSON);
		dao.save(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(APPLICATION_JSON);
		dao.remove(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType(APPLICATION_JSON);
		dao.update(req, resp);
	}
}
