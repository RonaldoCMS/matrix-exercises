package repositories;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface DAO<E> {
	
	public int save(E e) throws SQLIntegrityConstraintViolationException;
	public List<E> findAll();
	public E findById(int id);
	public int remove(int id);
	public int update(E e);
}
