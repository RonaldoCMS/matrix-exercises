package demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuth {
    private String username;
    private String password;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public UserAuth(ResultSet resultSet) throws SQLException {
		this.username = resultSet.getString("username");
		this.password = resultSet.getString("password");
	}

	
	@Override
	public String toString() {
		return "UserAuth [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
