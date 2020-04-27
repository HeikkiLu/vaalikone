package adminpages;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class buttonAction
 */
@WebServlet("/buttonAction")
public class buttonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connector conn = new Connector();
		
		// Ehdokkaan tiedot päivitykseen tai lisäykseen
		String sukunimi = request.getParameter("sukunimi");
		String etunimi = request.getParameter("etunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		String miksi_eduskuntaan = request.getParameter("miksieduskuntaan");
		String mita_asioita_haluat_edistaa = request.getParameter("mitaedistaa");
		String ammatti = request.getParameter("ammatti");
		int ika;
		int ehdokasnumero;
		
		try {
			ehdokasnumero = Integer.parseInt(request.getParameter("ehdokasnumero"));
		} catch (Exception e) {
			ehdokasnumero = -1;
		}
		
		try {
			ika = Integer.parseInt(request.getParameter("ika"));
		} catch (Exception e) {
			ika = -1;
		}
		
		int nextID;
		
		// Tämä määrittää mitä nappulaa painettiin
		conn.event = request.getParameter("btn").charAt(0);
		
		try {
			conn.currentID = Integer.parseInt(request.getParameter("currentID"));
		} catch (Exception e) {
			conn.currentID = -1;
		}
		
		if (conn.event == 'E') {
			// Editointi ikkunat aukeavat
		}

		if (conn.event == 'C') {
			try {
				System.out.println(conn.DeleteTableData());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn.event == 'Y') {
			// Kutsutaan tietokannan päivitys saaduilla tiedoilla
			conn.UpdateTableData(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti, ehdokasnumero);
		}
		
		if (conn.event == 'N') {
			// resetoi arvot että editointi perutaan
		}
		
		if (conn.event == 'U') {
			// resetoi arvot että deletointi perutaan
		}
		
		if (conn.event == 'S') {
			
			//testi gettabledatan kanssa, successful t�m�n avulla saa id:n oikean arvon
			conn.GetTableData();
			
			nextID = conn.getLastID() +1;
			
			//kutsuu addtabledata metodia
			try {
				conn.AddTableData(nextID, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti, ehdokasnumero);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("virhe btnaction.java -> addtable osiossa");
			}
			
		}
		
		// Lähettää vaan takas AdminControlPanel servlettiin
		response.sendRedirect("/AdminControlPanel");
	}

}
