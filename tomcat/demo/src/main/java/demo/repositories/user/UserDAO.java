package demo.repositories.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import demo.model.UserAuth;
import demo.repositories.DAO;
import demo.utils.DBUtil;

public class UserDAO implements DAO<UserAuth> {
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet resultSet = null;
	
	@Override
	public int save(UserAuth e) throws java.sql.SQLIntegrityConstraintViolationException{
		try {
			connection = DBUtil.getConnection();
			String query = "INSERT INTO user (username, password) VALUES (?, ?)";
			
			pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
			encryptor.setPassword("pswsecurity");
			String encrypted= encryptor.encrypt(e.getPassword());
			
			pst.setString(1, e.getUsername());
			pst.setString(2, encrypted);
			
			pst.executeUpdate();			
			 try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                return generatedKeys.getInt("id");
		            }
		        }
			
		} catch(java.sql.SQLIntegrityConstraintViolationException duplicate) {
			throw new java.sql.SQLIntegrityConstraintViolationException();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(resultSet);
			DBUtil.close(pst);
		}
		return -1;
	}
	
	public UserAuth findByUsername(String username) {
		
		try {
			String query = "SELECT * FROM user where username = ?";
			connection = DBUtil.getConnection();
			pst = connection.prepareStatement(query);
			pst.setString(1, username);
			resultSet = pst.executeQuery();
			if(resultSet.next()) {
				return new UserAuth(resultSet);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(pst);
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public List<UserAuth> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAuth findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserAuth UserAuthentication(String username, String password) {
		try {
			connection = DBUtil.getConnection();
			String query = "SELECT * FROM user WHERE username = ? and password = ?";
			pst = connection.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				return new UserAuth(resultSet);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
			DBUtil.close(resultSet);
			DBUtil.close(pst);
		}
		
		return null;
	}

	@Override
	public int remove(int id) {
		return 0;
		
	}

	@Override
	public int update(UserAuth user) {
		return 0;
	}

}
