package repositories.prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Prodotto;
import utils.DBUtil;

public class ProdottoDAO implements IProdottoDAO {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	@Override
	public int remove(int id) {
		String query = "DELETE FROM prodotto WHERE id = ?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return -1;
	}

	@Override
	public int save(Prodotto prodotto) throws SQLIntegrityConstraintViolationException {
		String query = "INSERT INTO prodotto (nome, img, costo, sconto) VALUES (?,?,?,?)";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getImg());
			preparedStatement.setDouble(3, prodotto.getCosto());
			preparedStatement.setInt(4, prodotto.getSconto());
			preparedStatement.executeUpdate();			
			 try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
		         System.out.println("TRY");  
				 if (resultSet.next()) {
		                return resultSet.getInt(1);
		            }
		        }
		} catch(java.sql.SQLIntegrityConstraintViolationException duplicate) {
			throw new java.sql.SQLIntegrityConstraintViolationException();
		}  catch(SQLException e) {
			
		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return -1;
		
	}

	@Override
	public int update(Prodotto prodotto) {
		String query = "UPDATE prodotto SET nome = ?, img = ?, costo = ?, sconto = ? WHERE id = ? ";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getImg());
			preparedStatement.setObject(3, prodotto.getCosto());
			preparedStatement.setInt(4, prodotto.getSconto());
			preparedStatement.setInt(5, prodotto.getId());
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement.getUpdateCount());
			return preparedStatement.getUpdateCount();
			 

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return 0;
	}

	@Override
	public List<Prodotto> findAll() {
		String query = "SELECT * FROM prodotto";
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				prodotti.add(new Prodotto(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(statement);
			DBUtil.close(resultSet);
		}
		
		return prodotti;
	}

	@Override
	public Prodotto findById(int id) {
		String query = "SELECT * FROM prodotto where id = ?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return new Prodotto(resultSet);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(preparedStatement);
			DBUtil.close(resultSet);
		}
		return null;
	}

}
