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
			  response.getWriter().print("Kirjaudu ensin sis狎n!"); 
			  response.getWriter().close();
		  }

	
		Connector conn = new Connector();
		List ehdokkaat = conn.GetTableData();
		PrintWriter out = response.getWriter();
		
		// Luo taulukon rakenteen
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		// Head
		out.println("<head>");
			out.println("<title>Admin Control Panel</title>");
			out.println("<meta charset=\"UTF-8\">");
			// CSS
			out.println("<style>");
			
				out.println(".edit {");
				out.println("background-color: #8cff2e;");
				out.println("padding: 5px;");
				out.println("}");
				
				out.println(".editButton {");
				out.println("background-color: #8cff2e;");
				out.println("padding: 5px;");
				out.println("display: block;");
				out.println("margin-left: auto;");
				out.println("margin-right: auto;");
				out.println("margin-top: auto;");
				out.println("margin-bottom: 3px;");
				out.println("width: 100%;");
				out.println("}");
				
				out.println(".deleteButton {");
				out.println("background-color: #ff3c2e;");
				out.println("color: white;");
				out.println("padding: 5px;");
				out.println("display: block;");
				out.println("margin-left: auto;");
				out.println("margin-right: auto;");
				out.println("margin-top: 3px;");
				out.println("margin-bottom: auto;");
				out.println("width: 100%;");
				out.println("}");
				
				out.println(".editButtonCell {");
				out.println("width: 75px;");
				out.println("}");
				
				out.println("td {");
				out.println("background-color: #f5f5f5;");
				out.println("}");
				
				out.println("th { text-align: left}쨈; }");
				
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
						out.println("<th>Ik채</th>");
						out.println("<th>Miksi eduskuntaan</th>");
						out.println("<th>Mit채 edist채t</th>");
						out.println("<th>Ammatti</th>");
					out.println("</tr>");

		
		// Ehdokkaiden tiedot
		for (int i = 0; i < ehdokkaat.size(); i++) {
			
			// Joka loopilla haetaan yksitt채inen sisennetty ArrayList ehdokkaat-listasta joka sis채lt채채 ehdokkaan tiedot
			ArrayList ehdokas = (ArrayList) ehdokkaat.get(i);
			
			// Jos currentID on sama kuin ehdokas-arrayn ID niin tulostellaan muokattava rivi
			if (conn.currentID == Integer.parseInt((String) ehdokas.get(0)) && conn.event == 'E') {
				out.println("<tr>"
						+ "<form action=\"/buttonAction\" method=\"GET\">"
						+ "<td class=\"edit\">" + ehdokas.get(0) + "<input type=\"hidden\" name=\"currentID\" value=\"" + ehdokas.get(0) + "\"></td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editsukunimi\">" 		+ ehdokas.get(1) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editetunimi\">" 		+ ehdokas.get(2) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editpuolue\">" 			+ ehdokas.get(3) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editkotipaikkakunta\">" + ehdokas.get(4) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editika\">" 			+ ehdokas.get(5) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editmiksieduskuntaan\">" + ehdokas.get(6) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"24\" name=\"editmitaedistaa\">" 	+ ehdokas.get(7) + "</textarea></td>"
						+ "<td class=\"edit\"><textarea rows=\"10\" cols=\"21\" name=\"editammatti\">" 		+ ehdokas.get(8) + "</textarea></td>"
						+ "<td>Apply changes?</td>"
						+ "<td class=\"editButtonCell\"><input type=\"submit\" class=\"editButton\" name=\"btn\" value=\"Yes\">"
						+ "<input type=\"submit\" class=\"deleteButton\" name=\"btn\" value=\"No\"></td>"
						+ "</form>"
						+ "</tr>"
						);
			}	
			else {
				out.println("<tr>"
						+ "<form action=\"/buttonAction\">"
						+ "<td>" + ehdokas.get(0) + "<input type=\"hidden\" name=\"currentID\" value=\"" + ehdokas.get(0) + "\"></td>" // haetaan ehdokas arraysta indeksin mukaan tieto
						+ "<td>" + ehdokas.get(1) + "</td>"
						+ "<td>" + ehdokas.get(2) + "</td>"
						+ "<td>" + ehdokas.get(3) + "</td>"
						+ "<td>" + ehdokas.get(4) + "</td>"
						+ "<td>" + ehdokas.get(5) + "</td>"
						+ "<td>" + ehdokas.get(6) + "</td>"
						+ "<td>" + ehdokas.get(7) + "</td>"
						+ "<td>" + ehdokas.get(8) + "</td>"
						);
				
				if (conn.currentID == Integer.parseInt((String) ehdokas.get(0)) && conn.event == 'D') {
					out.println("<td>Delete candidate?</td>"
							+ "<td class=\"editButtonCell\"><input type=\"submit\" class=\"editButton\" name=\"btn\" value=\"Confirm\">"
							+ "<input type=\"submit\" class=\"deleteButton\" name=\"btn\" value=\"Undo\"></td>");
				} else {
					out.println("<td><input type=\"submit\" name=\"btn\" value=\"Edit\"></td>"
						+ "<td><input type=\"submit\" name=\"btn\" value=\"Delete\"></td>"
						+ "</form>"
						+ "</tr>");
				}
			}
		}
		
		// Ehdokkaan lis채ys alimpana
		out.println("<tr>"
				+ "<form action=\"/buttonAction\" method=\"GET\">"
				+ "<td>ID</td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addsukunimi\" placeholder=\"sukunimi\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addetunimi\" placeholder=\"etunimi\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addpuolue\" placeholder=\"puolue\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addkotipaikkakunta\" placeholder=\"kotipaikkakunta\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addika\" placeholder=\"ik채\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addmiksieduskuntaan\" placeholder=\"miksi haluat eduskuntaan?\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"24\" name=\"addmitaedistaa\" placeholder=\"mit채 asioita haluat edist채채?\"></textarea></td>"
				+ "<td><textarea rows=\"10\" cols=\"21\" name=\"addammatti\" placeholder=\"ammatti\"></textarea></td>"
				+ "<td><input type=\"submit\" name=\"btn\" value=\"Submit\"></td>"
				+ "<td>Current ID: " + conn.currentID + "</td>"
				+ "</form>"
				+ "</tr>");
		
		// P채채tt채채 html koodin
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		
		// Varmistetaan ettei arvot j채채 voimaan
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
