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
		
<<<<<<< HEAD
		Connector action = new Connector();
=======
		Connector conn = new Connector();
		
		// Ehdokkaan tiedot päivitykseen tai lisäykseen
		String sukunimi;
		String etunimi;
		String puolue;
		String kotipaikkakunta;
		int ika;
		String miksi_eduskuntaan;
		String mita_asioita_haluat_edistaa;
		String ammatti;
>>>>>>> 66de33483215807662db5a3e3efb1960b4784c8c
		
		// Tämä määrittää minkä rivin edit-nappulaa painettiin
		conn.buttonAction = request.getParameter("btn");
		conn.event = request.getParameter("btn").charAt(0);
		
		if (conn.event == 'E') {
			// Editointi ikkunat aukeavat
		}
		
<<<<<<< HEAD
		if (event == 'D') {
			try {
				action.DeleteTableData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
=======
		if (conn.event == 'D') {
			// lisää tähän kutsu deleteTable-metodiin
>>>>>>> 66de33483215807662db5a3e3efb1960b4784c8c
		}
		
		if (conn.event == 'Y') {
			
			// Ehdokkaan tietojen päivittäminen
			sukunimi = request.getParameter("editsukunimi");
			etunimi = request.getParameter("editetunimi");
			puolue = request.getParameter("editpuolue");
			kotipaikkakunta = request.getParameter("editkotipaikkakunta");
			miksi_eduskuntaan = request.getParameter("editmiksieduskuntaan");
			mita_asioita_haluat_edistaa = request.getParameter("editmitaedistaa");
			ammatti = request.getParameter("editammatti");
			
			try {
				ika = Integer.parseInt(request.getParameter("editika"));
			} catch (Exception e) {
				ika = -1;
			}
			
			
			// Toivottavasti ilmoittaa onnistuiko vai ei
			conn.whatHappened = conn.UpdateTableData(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
		}
		
		if (conn.event == 'N') {
			// resetoi arvot että editointi perutaan
		}
		
		if (conn.event == 'S') {
			// Ville lisää tähän kutsu addCandidate-metodiin ja hae tiedot form kentistä käyttämällä request.getParameter
			// kenttien nimet on nyt "addsukunimi" "addetunimi" jne.
		}
		
		// Lähettää vaan takas AdminControlPanel servlettiin
		response.sendRedirect("/AdminControlPanel");
	}

}
