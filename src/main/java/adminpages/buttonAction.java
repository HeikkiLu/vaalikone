package adminpages;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EhdokkaatDao;

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
		
		EhdokkaatDao conn = new EhdokkaatDao();
		
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
			ika = Integer.parseInt(request.getParameter("ika"));
		} catch (Exception e) {
			ika = -1;
		}
		
		try {
			ehdokasnumero = Integer.parseInt(request.getParameter("ehdokasnumero"));
		} catch (Exception e) {
			ehdokasnumero = -1;
		}
		
		
		// Tämä määrittää mitä nappulaa painettiin
		conn.event = request.getParameter("btn").charAt(0);
		conn.ehdokas = ehdokasnumero;

		if (conn.event == 'C') {
			conn.deleteEhdokas();
			EhdokkaatDao.confirmDelete = true;
		}
		
		if (conn.event == 'Y') {
			conn.UpdateEhdokas(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti, ehdokasnumero);
			EhdokkaatDao.confirmEdit = true;
		}
		
		if (conn.event == 'Q') {
			EhdokkaatDao.confirmAddQuestion = true;
		}
		
		if (conn.event == 'S') {
			conn.AddEhdokas(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti, ehdokasnumero);
			EhdokkaatDao.confirmAdd = true;
		}
		
		response.sendRedirect("/AdminControlPanel");
	}

}
