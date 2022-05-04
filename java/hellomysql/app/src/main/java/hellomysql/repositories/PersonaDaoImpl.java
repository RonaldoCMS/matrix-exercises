package hellomysql.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import hellomysql.model.Persona;

public class PersonaDaoImpl implements PersonaDAO {
 
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @Override
    public int save(Persona persona) throws MySQLIntegrityConstraintViolationException  {
        String sql = "INSERT persona (cdf, nome, cognome) VALUES (?,?,?)";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, persona.getCdf());
            statement.setString(2, persona.getNome());
            statement.setString(3, persona.getCognome());
            return statement.executeUpdate();   
              
        } catch(SQLException e) {
            System.out.println("\n---Errore.\n");
        }
        finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
            DBUtil.close(resultSet);
        }
        return 0;
    }

    @Override
    public List<Persona> findAll() {
        String sql = "SELECT * FROM persona";
        List<Persona> persone = new ArrayList<Persona>();
        try {
            connection = DataSource.getConnection();
            Statement statement =  connection.createStatement();
            resultSet = statement.executeQuery(sql);
      
            while (resultSet.next()) {
              int id = resultSet.getInt("id");
              String nome = resultSet.getString("nome");
              String cognome = resultSet.getString("cognome");
              String cdf = resultSet.getString("cdf");
              Persona persona = new Persona(id, cdf, nome, cognome);
              persone.add(persona);
            }     
        } catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
            DBUtil.close(resultSet);
            
        }
        return persone;
    }

    @Override
    public Persona findById(int id) {
        String sql = "SELECT * FROM persona WHERE id = ?";
        Persona persona = null;
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                persona = new Persona(resultSet);
            } 
        } catch(SQLException e) {
           e.printStackTrace();
        }
        finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
            DBUtil.close(resultSet);
        }
        return persona;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Persona WHERE id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();        
        } catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
            DBUtil.close(resultSet);
        }
    }

    @Override
    public void update(Persona persona) {
       String sql = "UPDATE persona SET cdf = ?, nome = ?, cognome = ? WHERE id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, persona.getCdf());
            statement.setString(2, persona.getNome());
            statement.setString(3, persona.getCognome());
            statement.setInt(4, persona.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
        }
    }

    private List<Persona> findByColPersona(String query, String value) {
        List<Persona> persona = new LinkedList<Persona>();
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, value);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                persona.add(new Persona(resultSet));
            } 
        } catch(SQLException e) {
           e.printStackTrace();
        }
        finally {
            DBUtil.close(connection);
            DBUtil.close(statement);
            DBUtil.close(resultSet);
        }
        return persona;
    }

    @Override
    public List<Persona> findByName(String name) {
        String sql = "SELECT * FROM persona WHERE nome = ?";
        return findByColPersona(sql, name);
    }

    @Override
    public List<Persona> findByCognome(String cognome) {
        String sql = "SELECT * FROM persona WHERE cognome = ?";
        return findByColPersona(sql, cognome);
    }

    @Override
    public Persona findByCdf(String cdf) {
        String sql = "SELECT * FROM persona WHERE cdf = ?";
        return findByColPersona(sql, cdf).get(0);
    }


}
