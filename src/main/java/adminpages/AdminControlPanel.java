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
		
		
		// Ehdkä hieman paska toteutustapa mutta kun en muutakaan keksinyt
		// Eli val hakee Connectorista string-arvon
		String val = Connector.buttonAction;
		String event = null;
		String unparsedNum;
		int indexNum = -1;
		
		// Jos val ei ole null
		if (val != null) {
			// ensimmäiset 4 kirjainta tallennetaan event-stringiin
			event = val.substring(0,4);
			// neljännestä indeksistä eteenpäin olevat arvot eli numerot tallennetaan tähän
			unparsedNum = val.substring(4);
			// ja numerot parsetaan int muotoon
			indexNum = Integer.parseInt(unparsedNum);
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
				out.println("<tr>"
						+ "<td id=\"id" + i + "\">" + ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td id=\"sukunimi" + i + "\"><input type=\"text\" value=\"" 			+ ehdokas.get(1) + "\"></td>"
						+ "<td id=\"etunimi" + i + "\"><input type=\"text\" value=\"" 			+ ehdokas.get(2) + "\"></td>"
						+ "<td id=\"puolue" + i + "\"><input type=\"text\" value=\"" 			+ ehdokas.get(3) + "\"></td>"
						+ "<td id=\"kotipaikkakunta" + i + "\"><input type=\"text\" value=\"" 	+ ehdokas.get(4) + "\"></td>"
						+ "<td id=\"ika" + i + "\"><input type=\"text\" value=\"" 				+ ehdokas.get(5) + "\"></td>"
						+ "<td id=\"miksieduskuntaan" + i + "\"><input type=\"text\" value=\"" 	+ ehdokas.get(6) + "\"></td>"
						+ "<td id=\"mitaedistaa" + i + "\"><input type=\"text\" value=\"" 		+ ehdokas.get(7) + "\"></td>"
						+ "<td id=\"ammatti" + i + "\"><input type=\"text\" value=\"" 			+ ehdokas.get(8) + "\"></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btnP" + i + "\" + value=\"Apply\"></form></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btnC" + i + "\" + value=\"Discard\"></form></td>"
						+ "</tr>"
						);
			} 
			// Jos taas indexNum ei ole sama niin tulostellaan pelkät tiedot normaalisti
			else {
				out.println("<tr>"
						+ "<td id=\"id" + i + "\">" 				+ ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td id=\"sukunimi" + i + "\">" 			+ ehdokas.get(1) + "</td>"
						+ "<td id=\"etunimi" + i + "\">" 			+ ehdokas.get(2) + "</td>"
						+ "<td id=\"puolue" + i + "\">" 			+ ehdokas.get(3) + "</td>"
						+ "<td id=\"kotipaikkakunta" + i + "\">" 	+ ehdokas.get(4) + "</td>"
						+ "<td id=\"ika" + i + "\">" 				+ ehdokas.get(5) + "</td>"
						+ "<td id=\"miksieduskuntaan" + i + "\">" 	+ ehdokas.get(6) + "</td>"
						+ "<td id=\"mitaedistaa" + i + "\">" 		+ ehdokas.get(7) + "</td>"
						+ "<td id=\"ammatti" + i + "\">" 			+ ehdokas.get(8) + "</td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btnE" + i + "\" + value=\"Edit\"></form></td>"
						+ "<td><form action=\"/buttonAction\"><input type=\"submit\" name=\"btnD" + i + "\" + value=\"Delete\"></form></td>"
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
				+ "<td><button type\"button\" class=\"btnadd\">Add new candidate</button></td>"
				+ "</tr>");
		
		// Päättää html koodin
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		// Varmistetaan ettei arvot jää voimaan
		event = null;
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
