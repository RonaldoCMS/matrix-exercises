package demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String psw = "password";
    private static final String db = "servlet";
    private static final String completeUrl = "jdbc:mysql://localhost:3306/servlet";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(completeUrl, user, psw);
    }
    
    public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
