package adminpages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.Ehdokkaat;

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

		Ehdokkaat e;
		PrintWriter out = response.getWriter();
		
		// Luo taulukon rakenteen
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		// Head
		out.println("<head>");
		out.println("<title>Admin Control Panel</title>");
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
		for (int i = 1; i < 20; i++) {
			e = new Ehdokkaat(i);
			out.println("<tr>"
					+ "<td>" + i + "</td>"
					+ "<td>" + e.getSukunimi() + "</td>"
					+ "<td>" + e.getEtunimi() + "</td>"
					+ "<td>" + e.getPuolue() + "</td>"
					+ "<td>" + e.getKotipaikkakunta() + "</td>"
					+ "<td>" + e.getIka() + "</td>"
					+ "<td>" + e.getMiksiEduskuntaan() + "</td>"
					+ "<td>" + e.getMitaAsioitaHaluatEdistaa() + "</td>"
					+ "<td>" + e.getAmmatti() + "</td>"
					+ "<td><button type=\"button\" class=\"btnedit\">Edit</button></td>"
					+ "<td><button type=\"button\" class=\"btndelete\">Delete</button></td>"
					+ "</tr>"
					);

		}
		
		// Ehdokkaan lisäys alimpana
		out.println("<tr class=\"add\">"
				+ "<td><button type\"button\" class=\"btnadd\">Add new candidate</button></td>"
				+ "<td><input type\"text\" name=\"sukunimi\" placeholder=\"sukunimi\"></td>"
				+ "<td><input type\"text\" name=\"etunimi\" placeholder=\"etunimi\"></td>"
				+ "<td><input type\"text\" name=\"puolue\" placeholder=\"puolue\"></td>"
				+ "<td><input type\"text\" name=\"kotipaikkakunta\" placeholder=\"kotipaikkakunta\"></td>"
				+ "<td><input type\"text\" name=\"ika\" placeholder=\"ikä\"></td>"
				+ "<td><input type\"text\" name=\"miksieduskuntaan\" placeholder=\"miksi eduskuntaan\"></td>"
				+ "<td><input type\"text\" name=\"mitaedistaa\" placeholder=\"mitä edistää\"></td>"
				+ "<td><input type\"text\" name=\"ammatti\" placeholder=\"ammatti\"></td>"
				+ "</tr>");
		
		// Päättää html koodin
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
