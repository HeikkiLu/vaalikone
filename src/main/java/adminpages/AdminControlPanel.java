package adminpages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.Ehdokkaat;
import persist.Vastaukset;

/**
 * Servlet implementation class AdminControlPanel
 */
@WebServlet("/AdminControlPanel")
public class AdminControlPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControlPanel() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connector conn = new Connector();
		List ehdokkaat = conn.GetTableData();
		PrintWriter out = response.getWriter();
		
		// Ehkä hieman paska toteutustapa mutta kun en muutakaan keksinyt
		// Eli action hakee Connectorista string-arvon
		String action = Connector.buttonAction;
		int indexNum = -1;
		
		if (action != null) {
			try {
				// Painetun napin arvo jaetaan kahteen osaan ja jälkimmäinen muutetaan int muotoon
				String[] list = action.split(" ");
				indexNum = Integer.parseInt(list[1]);
			} catch (Exception e) {
				indexNum = -1;
			}
		}
		
		// Luo taulukon rakenteen
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		// Head
		out.println("<head>");
			out.println("<title>Admin Control Panel</title>");
			// CSS
			out.println("<style>");
			
				out.println(".btnedit {");
				out.println("background-color: #a5d179;");
				out.println("}");
				
				out.println(".btndelete {");
				out.println("background-color: #e6bcbc;");
				out.println("}");
				
				out.println("th { text-align: left}´; }");
				
			out.println("</style>");
		out.println("</head>");
		// Body
		out.println("<body>");
			out.println("<center>");
				out.println("<table border='1' cellpadding='3' cellspacing='0'>");
					out.println("</tr>");
						out.println("<th>ID</th>");
						out.println("<th>Sukunimi</th>");
						out.println("<th>Etunimi</th>");
						out.println("<th>Puolue</th>");
						out.println("<th>Kotipaikkakunta</th>");
						out.println("<th>Ikä</th>");
						out.println("<th>Miksi eduskuntaan</th>");
						out.println("<th>Mitä edistät</th>");
						out.println("<th>Ammatti</th>");
					out.println("</tr>");

		
		// Ehdokkaiden tiedot
		for (int i = 0; i < ehdokkaat.size(); i++) {
			
			// Joka loopilla haetaan yksittäinen sisennetty ArrayList ehdokkaat-listasta joka sisältää ehdokkaan tiedot
			ArrayList ehdokas = (ArrayList) ehdokkaat.get(i);
			
			// Jos indexNum on sama kuin for-loopin int i niin tulostellaan muokattava rivi
			if (indexNum == i) {
				
				// Tätä voi yrittää käyttää tietokantaa muokatessa
				Connector.idNum = Integer.parseInt((String) ehdokas.get(0));

				out.println("<tr>"
						+ "<td>" + ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"sukunimi\">" 		+ ehdokas.get(1) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"etunimi\">" 		+ ehdokas.get(2) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"puolue\">" 			+ ehdokas.get(3) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"kotipaikkakunta\">" + ehdokas.get(4) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"ika\">" 			+ ehdokas.get(5) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"30\" name=\"miksieduskuntaan\">" + ehdokas.get(6) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"30\" name=\"mitaedistaa\">" 	+ ehdokas.get(7) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"20\" name=\"ammatti\">" 		+ ehdokas.get(8) + "</textarea></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btn\" value=\"Yes " + i + "\"></form></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btn\" value=\"No " + i + "\"></form></td>"
						+ "</tr>"
						);
			} 
			// Jos taas indexNum ei ole sama niin tulostellaan pelkät tiedot normaalisti
			else {
				out.println("<tr>"
						+ "<td>" + ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td>" + ehdokas.get(1) + "</td>"
						+ "<td>" + ehdokas.get(2) + "</td>"
						+ "<td>" + ehdokas.get(3) + "</td>"
						+ "<td>" + ehdokas.get(4) + "</td>"
						+ "<td>" + ehdokas.get(5) + "</td>"
						+ "<td>" + ehdokas.get(6) + "</td>"
						+ "<td>" + ehdokas.get(7) + "</td>"
						+ "<td>" + ehdokas.get(8) + "</td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btn\" value=\"Edit " + i + "\"></form></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btn\" value=\"Delete " + i + "\"></form></td>"
						+ "</tr>"
						);
			}
		}
		
		// Ehdokkaan lisäys alimpana
		out.println("<tr class=\"add\">"
				+ "<td><input type\"text\" name=\"id\" placeholder=\"id\"></td>"
				+ "<td><input type\"text\" name=\"sukunimi\" placeholder=\"sukunimi\"></td>"
				+ "<td><input type\"text\" name=\"etunimi\" placeholder=\"etunimi\"></td>"
				+ "<td><input type\"text\" name=\"puolue\" placeholder=\"puolue\"></td>"
				+ "<td><input type\"text\" name=\"kotipaikkakunta\" placeholder=\"kotipaikkakunta\"></td>"
				+ "<td><input type\"text\" name=\"ika\" placeholder=\"ikä\"></td>"
				+ "<td><input type\"text\" name=\"miksieduskuntaan\" placeholder=\"miksi eduskuntaan\"></td>"
				+ "<td><input type\"text\" name=\"mitaedistaa\" placeholder=\"mitä edistää\"></td>"
				+ "<td><input type\"text\" name=\"ammatti\" placeholder=\"ammatti\"></td>"
				+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btn\" value=\"Submit new candidate\"></td>"
				+ "</tr>");
		
		// Päättää html koodin
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		// Varmistetaan ettei arvot jää voimaan
		//Connector.event = null;
		Connector.buttonAction = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
