package adminpages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		if (conn == null || conn.isClosed()) {
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

	public String DeleteTableData(int id) throws SQLException {
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
	
	public List GetTableData() {
		
		try {
			connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM ehdokkaat";
		List ehdokkaat = new ArrayList();

		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {

				// Luodaan uusi ArrayList johon tallennetaan tiedot
				List<String> ehdokas = new ArrayList();
				
				// Lisätään kolumnin mukaan tiedot ehdokas-ArrayListiin
				ehdokas.add(result.getString(1)); // ID
				ehdokas.add(result.getString(2)); // Sukunimi
				ehdokas.add(result.getString(3)); // Etunimi
				ehdokas.add(result.getString(4)); // Puolue
				ehdokas.add(result.getString(5)); // Kotipaikkakunta
				ehdokas.add(result.getString(6)); // Ikä
				ehdokas.add(result.getString(7)); // Miksi eduskuntaan
				ehdokas.add(result.getString(8)); // Mitä haluat edistää
				ehdokas.add(result.getString(9)); // Ammatti
				
				// Lisätään juuri luotu ehdokas-ArrayList ehdokkaat ArrayListiin
				ehdokkaat.add(ehdokas);
			}
			
			// Palautetaan ArrayList joka sisältää kaikkien ehdokkaiden tiedot omissa ArrayListeissä
			return ehdokkaat;

		} catch (Exception e) {
			ehdokkaat.add("Fucked");
			return ehdokkaat;
		}

	}

}
