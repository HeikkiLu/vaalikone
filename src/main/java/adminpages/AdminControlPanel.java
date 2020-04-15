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
import javax.servlet.http.HttpSession;

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
		
		HttpSession session=request.getSession(false);
		
		  if(session!=null){
		         
			  response.getWriter().print("Tervetuloa!"); 
		
		  }  
		  else {
			  response.getWriter().print("Kirjaudu ensin sis��n!"); 
			  response.getWriter().close();
		  }

	
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
				
				out.println("td {");
				out.println("background-color: #f5f5f5;");
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
			
			// Tätä voi yrittää käyttää tietokantaa muokatessa
			if (indexNum == i) {
				Connector.idNum = Integer.parseInt((String) ehdokas.get(0));
			}
			
			// Jos indexNum on sama kuin for-loopin int i niin tulostellaan muokattava rivi
			if (indexNum == i && Connector.event == 'E') {
				out.println("<tr>"
						+ "<form action=\"/buttonAction\" method=\"GET\">"
						+ "<td>" + ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editsukunimi\">" 		+ ehdokas.get(1) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editetunimi\">" 		+ ehdokas.get(2) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editpuolue\">" 			+ ehdokas.get(3) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editkotipaikkakunta\">" + ehdokas.get(4) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editika\">" 			+ ehdokas.get(5) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editmiksieduskuntaan\">" + ehdokas.get(6) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"24\" name=\"editmitaedistaa\">" 	+ ehdokas.get(7) + "</textarea></td>"
						+ "<td><textarea rows=\"10\" cols=\"21\" name=\"editammatti\">" 		+ ehdokas.get(8) + "</textarea></td>"
						+ "<td><input type=\"submit\" name=\"btn\" value=\"Yes " + i + "\"></td>"
						+ "<td><input type=\"submit\" name=\"btn\" value=\"No " + i + "\"></td>"
						+ "</form>"
						+ "</tr>"
						);
			}
			// Jos taas indexNum ei ole sama niin tulostellaan pelkät tiedot normaalisti
			else {
				out.println("<tr>"
						+ "<form action=\"/buttonAction\">"
						+ "<td>" + ehdokas.get(0) + "</td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td>" + ehdokas.get(1) + "</td>"
						+ "<td>" + ehdokas.get(2) + "</td>"
						+ "<td>" + ehdokas.get(3) + "</td>"
						+ "<td>" + ehdokas.get(4) + "</td>"
						+ "<td>" + ehdokas.get(5) + "</td>"
						+ "<td>" + ehdokas.get(6) + "</td>"
						+ "<td>" + ehdokas.get(7) + "</td>"
						+ "<td>" + ehdokas.get(8) + "</td>"
						+ "<td><input type=\"submit\" name=\"btn\" value=\"Edit " + i + "\"></td>"
						+ "<td><input type=\"submit\" name=\"btn\" value=\"Delete " + i + "\"></td>"
						+ "</form>"
						+ "</tr>"
						);
			}
		}
		
		// Ehdokkaan lisäys alimpana
		out.println("<tr>"
				+ "<form action=\"/buttonAction\" method=\"GET\">"
				+ "<td>ID</td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addsukunimi\" placeholder=\"sukunimi\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addetunimi\" placeholder=\"etunimi\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addpuolue\" placeholder=\"puolue\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addkotipaikkakunta\" placeholder=\"kotipaikkakunta\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addika\" placeholder=\"ikä\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addmiksieduskuntaan\" placeholder=\"miksi haluat eduskuntaan?\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"24\" name=\"addmitaedistaa\" placeholder=\"mitä asioita haluat edistää?\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addammatti\" placeholder=\"ammatti\"></textarea></td>"
				+ "<td><input type=\"submit\" name=\"btn\" value=\"Submit new candidate\"></td>"
				+ "</form>"
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
