package adminpages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	private String dbURL;
	private String username;
	private String password;
	private Connection conn;

	public Connector() {
		this.dbURL = "jdbc:mysql://localhost:3306/vaalikone";
		this.username = "tommi";
		this.password = "kukkuu";
	}

	protected void connect() throws SQLException {
		if(conn == null || conn.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			conn = DriverManager.getConnection(dbURL, username, password);
		}
	}

	 protected void disconnect() throws SQLException {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    }

	String DeleteTableData(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM users WHERE user_id = ?";
		String returnStatement = null;

		connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				returnStatement = "Candidate was removed.";
			}
		} catch (Exception e) {
			returnStatement = "Error in the process. Candidate not removed.";
		}

		disconnect();
		return returnStatement;
	}

}
