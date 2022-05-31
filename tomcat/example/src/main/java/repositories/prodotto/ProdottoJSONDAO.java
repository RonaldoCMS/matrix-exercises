package repositories.prodotto;


import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Prodotto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProdottoJSONDAO {
	
	private IProdottoDAO dao;
	private ObjectMapper mapper;

	public ProdottoJSONDAO() {
		dao = new ProdottoDAO();
		mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	}
	public void findAll(HttpServletResponse resp) throws IOException {
		List<Prodotto> persone = dao.findAll();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persone);
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().append(json).flush();
	} //OK
	
	public void findById(int id, HttpServletResponse resp) throws IOException {
		Prodotto prodotto = dao.findById(id);
		if (prodotto != null) {
			String json = mapper.writeValueAsString(prodotto);
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().append(json).flush();
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			getMessage(resp, "prodotto not found");
		}
	} //OK
	
	public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Prodotto prodotto = mapper.readValue(req.getReader(), Prodotto.class);
			System.out.println(prodotto.toString());
			List<String> errors = saveError(prodotto);
			System.out.println(errors.isEmpty());
			if (!errors.isEmpty()) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				resp.getWriter().append("{\"errors\":[" + String.join(",", errors) + "]}").flush();

			} else {
				int id = dao.save(prodotto);
				System.out.println("ID" + id);
				prodotto.setId(id);
				String json = mapper.writeValueAsString(prodotto);
				resp.setStatus(HttpServletResponse.SC_CREATED);
				resp.setHeader("location", req.getRequestURL() + "/" + prodotto.getId());
				resp.getWriter().append(json).flush();
			}
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			getMessage(resp, "integrity constraint violation");
		}
		catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			getMessage(resp, e.getMessage());
		}
	} //OK
	
	public void remove(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (req.getPathInfo() != null && req.getPathInfo().split("/").length > 1) {
				int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
				if(dao.remove(id) == 1) {
					resp.setStatus(HttpServletResponse.SC_OK);
					getMessage(resp, null);
				} else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
					getMessage(resp, "prodotto not found");
				} 
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws StreamReadException, DatabindException, IOException {
		if (req.getPathInfo() != null && req.getPathInfo().split("/").length > 1) {
			Prodotto newProdotto = mapper.readValue(req.getReader(), Prodotto.class);
			int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
			Prodotto oldProdotto = dao.findById(id);
			if(oldProdotto != null) {
				if(!updateError(newProdotto)) {
					oldProdotto.changeValues(newProdotto);
					int status = dao.update(oldProdotto);
					resp.setStatus(HttpServletResponse.SC_OK);
					getMessage(resp, status);
				} else {
					resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					getMessage(resp, "nothing parameter insert");
				}
				
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				getMessage(resp, "id not found");
			}
			
		} else {
			getMessage(resp, "id not insert");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	} //OK
	
	private boolean updateError(Prodotto prodotto) {
		if (prodotto.getNome() == null && prodotto.getImg() == null && prodotto.getCosto() == null && prodotto.getSconto() <= 0) {
			return true;
		}
		return false;
	}
	
	
	
	private List<String> saveError(Prodotto prodotto) {
		List<String> errors = new ArrayList<String>();
		if (prodotto.getNome() == null || prodotto.getNome().isBlank()) {
			errors.add(preparedError("nome", "il campo nome è vuoto"));
		}
		if (prodotto.getImg() == null || prodotto.getImg().isBlank()) {
			errors.add(preparedError("img", "Il campo img è vuoto"));
		}
		if (prodotto.getCosto() == null) {
			errors.add(preparedError("costo", "Il campo costo è vuoto"));
		}

		return errors;
	}
	
	private String preparedError(String field, String message) {
		return "{\"field\":\""+field+"\",\"message\":\""+message+"\"}";
	}
	
	private void getMessage(HttpServletResponse resp, Object message) throws IOException {
		resp.getWriter().append("{\"error\":\""+ message +"\"}").flush();
	}
	
	
}
