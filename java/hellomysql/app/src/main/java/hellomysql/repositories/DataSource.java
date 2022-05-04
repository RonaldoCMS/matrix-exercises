package hellomysql.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String psw = "password";
    private static final String db = "matrixjv";
    private static final String completeUrl = "jdbc:mysql://localhost:3306/matrixjv?characterEncoding=utf8";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(completeUrl, user, psw);
    }

}

