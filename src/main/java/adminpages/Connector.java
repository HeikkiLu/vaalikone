package adminpages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.Ehdokkaat;

public class Connector {

	private String dbURL;
	private String username;
	private String password;
	private Connection conn;
	private int lastID;
	public static char event;
	public static int ehdokas = 2;
	public static int currentID = -1;
	public static boolean confirmAdd = false;
	public static boolean confirmEdit = false;
	
	public Connector() {
		this.dbURL = "jdbc:mysql://localhost:3306/vaalikone";
		this.username = "tommi";
		this.password = "kukkuu";
	}
	
	public int getLastID() {
		return lastID;
	}

	public void setLastID(int lastID) {
		this.lastID = lastID;
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

	public String DeleteTableData() throws SQLException {

		String sql = "DELETE FROM ehdokkaat WHERE EHDOKAS_ID = ?";
		String returnStatement = null;

		connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, currentID);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				returnStatement = "Candidate was removed.";
			}
		} catch (Exception e) {
			returnStatement = "Error in the process. Candidate not removed.\n" + e;
		}

		disconnect();
		return returnStatement;
	}
	
	public String UpdateTableData(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksi_eduskuntaan, String mita_asioita_haluat_edistaa, String ammatti, int ehdokasnumero) {
		
		String sql = "UPDATE ehdokkaat SET SUKUNIMI=?, ETUNIMI=?, PUOLUE=?, KOTIPAIKKAKUNTA=?, IKA=?, MIKSI_EDUSKUNTAAN=?, MITA_ASIOITA_HALUAT_EDISTAA=?, AMMATTI=?, EHDOKASNUMERO=? WHERE EHDOKAS_ID=?";
		String returnStatement = null;
		
		// Yhteys tietokantaan
		try {
			connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sukunimi);
			statement.setString(2, etunimi);
			statement.setString(3, puolue);
			statement.setString(4, kotipaikkakunta);
			statement.setInt(5, ika);
			statement.setString(6, miksi_eduskuntaan);
			statement.setString(7, mita_asioita_haluat_edistaa);
			statement.setString(8, ammatti);
			statement.setInt(9, ehdokasnumero);
			statement.setInt(10, currentID);

			int rowsUpdated = statement.executeUpdate();
			
			if (rowsUpdated > 0) {
				returnStatement = "An existing user was updated successfully!";
			}

		} catch (Exception e) {
			returnStatement = "Error in the process. Candidate not updated.";
		}
		
		// Katkaistaan yhteys tietokantaan
		try {
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnStatement;
	}
	
	public List GetTableData() {
		
		// Yhteys tietokantaan
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
				ehdokas.add(result.getString(10)); // Ehdokasnumero
				
				// Lisätään juuri luotu ehdokas-ArrayList ehdokkaat ArrayListiin
				ehdokkaat.add(ehdokas);
				
				lastID = result.getInt(1);
			}

		} catch (Exception e) {
			ehdokkaat.add("Fucked");
		}
		
		// Katkaistaan yhteys tietokantaan
		try {
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Palautetaan ArrayList joka sisältää kaikkien ehdokkaiden tiedot omissa ArrayListeissä
		return ehdokkaat;
	}
	
	/*
	 * buttonAction l�hett�� parametrit, t�m� sy�tt�� niiden avulla uuden ehdokkaan
	 */
	public String AddTableData(int nextID, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksieduskuntaan, String mitaedistaa, String ammatti, int ehdokasnumero) throws SQLException {
		
		String sql = "INSERT INTO ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI, EHDOKASNUMERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String returnStatement = null;		
		connect();		
		
		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, nextID);
			statement.setString(2, sukunimi);
			statement.setString(3, etunimi);
			statement.setString(4, puolue);
			statement.setString(5, kotipaikkakunta);
			statement.setInt(6, ika);
			statement.setString(7, miksieduskuntaan);
			statement.setString(8, mitaedistaa);
			statement.setString(9, ammatti);	
			statement.setInt(10, ehdokasnumero);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				returnStatement = "Uuden ehdokkaan lis�ys onnistui.";
				System.out.println(returnStatement);
			}

		} catch (Exception e) {
			returnStatement = "ehdokkaan lis��misess� ongelma.";
			System.out.println(returnStatement);
		}
		
		disconnect();
		return returnStatement;

	}
	
	/**
	 * Tällä haetaan yhden tietyn ehdokkaan tiedot antamalla sille ehdokasnumero.
	 * Loopissa lapautetaan halutun ehdokkaan tiedot JOS ehdokasnumero löytyy listasta
	 * currentID asetetaan tämän ehdokkaan ID:n mukaan jotta ehdokkaan tietoja voidaan päivittää tai poistaa
	 */
	public List haeEhdokkaanTiedot(int ehdokasNumero) {
		
		if (ehdokasNumero < 0) {
			return null;
		}
		
		List ehdokkaat = GetTableData();
		List ehdokas = null;
		
		for (int i = 0; i < ehdokkaat.size(); i++) {
			ehdokas = (List) ehdokkaat.get(i);
			if (Integer.parseInt((String) ehdokas.get(9)) == ehdokasNumero) {
				currentID = Integer.parseInt((String) ehdokas.get(0));
				return ehdokas;
			}
		}
		return ehdokas;
	}
	
	/*
	 * JPA tapa hakea tiedot ja palauttaa olio
	 */
	public Ehdokkaat findEhdokas(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("vaalikones");
		} catch (Exception e) {}
		
		try {
			em = emf.createEntityManager();
		} catch (Exception e) {}
		
		Ehdokkaat ehdokas = em.find(Ehdokkaat.class, id);
		return ehdokas;
	}
}
