package hellomysql.repositories;

import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public interface DAO<E> {
    public int save(E e) throws MySQLIntegrityConstraintViolationException;
    public List<E> findAll();
    public E findById(int id);
    public void delete(int id);
    public void update(E e);
}
