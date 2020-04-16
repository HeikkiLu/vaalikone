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
		String sukunimi;
		String etunimi;
		String puolue;
		String kotipaikkakunta;
		int ika;
		String miksi_eduskuntaan;
		String mita_asioita_haluat_edistaa;
		String ammatti;

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
			
			// Kutsutaan tietokannan päivitys saaduilla tiedoilla
			conn.UpdateTableData(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
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
			sukunimi = request.getParameter("addsukunimi");
			etunimi = request.getParameter("addetunimi");
			puolue = request.getParameter("addpuolue");
			kotipaikkakunta = request.getParameter("addkotipaikkakunta");
			// ik� hieman alempana try-catchiss�
			miksi_eduskuntaan = request.getParameter("addmiksieduskuntaan");
			mita_asioita_haluat_edistaa = request.getParameter("addmitaedistaa");
			ammatti = request.getParameter("addammatti");
			
			try {
				ika = Integer.parseInt(request.getParameter("addika"));
			} catch (Exception e) {
				ika = -1;
			}
			
			//Testausta varten ollut printti			
			//System.out.println(nextID + ", " + sukunimi + ", " + etunimi + ", " + ika);
			
			//kutsuu addtabledata metodia
			try {
				conn.AddTableData(nextID, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("virhe btnaction.java -> addtable osiossa");
			}
			
		}
		
		// Lähettää vaan takas AdminControlPanel servlettiin
		response.sendRedirect("/AdminControlPanel");
	}

}
