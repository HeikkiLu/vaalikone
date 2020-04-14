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
		
		Connector action = new Connector();
		
		// Tämä määrittää minkä rivin edit-nappulaa painettiin
		Connector.buttonAction = request.getParameter("btn");
		char event = request.getParameter("btn").charAt(0);
		
		if (event == 'E') {
		}
		
		if (event == 'D') {
			try {
				action.DeleteTableData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event == 'Y') {
			// lisää tähän kutsu editTable-metodiin
		}
		
		if (event == 'N') {
			// resetoi arvot että editointi perutaan
		}
		
		if (event == 'S') {
			// lisää tähän kutsu addCandidate-metodiin
		}
		
		// Lähettää vaan takas AdminControlPanel servlettiin
		response.sendRedirect("/AdminControlPanel");
	}

}
