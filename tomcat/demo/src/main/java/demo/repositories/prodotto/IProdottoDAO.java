package demo.repositories.prodotto;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import demo.model.Prodotto;
import demo.repositories.DAO;

public interface IProdottoDAO extends DAO<Prodotto> {
	
	@Override
	List<Prodotto> findAll();
	
	@Override
	Prodotto findById(int id);
	
	@Override
	int remove(int id);
	
	@Override
	int save(Prodotto e)  throws SQLIntegrityConstraintViolationException;
	
	@Override
	int update(Prodotto prodotto);
	
}
