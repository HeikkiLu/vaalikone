package adminpages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EhdokkaatDao;
import dao.KysymyksetDao;
import persist.*;
import rest.KysymyksetService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deleteId=request.getParameter("deleteId");
		PrintWriter out=response.getWriter();

		HttpSession session = request.getSession(false);

		if (session != null) {
			// response.getWriter().print("Tervetuloa!");
		} else {
			response.getWriter().print("Kirjaudu ensin sis��n!");
			response.getWriter().close();
		}
	
		// Ohjaa JSP tiedostoon
		//RequestDispatcher view = request.getRequestDispatcher("MainPage.jsp");
		//view.forward(request, response);
		
		if (EhdokkaatDao.event == 'H') {
			response.sendRedirect(request.getContextPath() + "/ModifyPage.jsp");
		} else if (EhdokkaatDao.event == 'S') {
			response.sendRedirect(request.getContextPath() + "/AddPage.jsp");
		} else if (EhdokkaatDao.event == 'Y') {
			response.sendRedirect(request.getContextPath() + "/ModifyPage.jsp");
		} else if (EhdokkaatDao.event == 'Q') {
			response.sendRedirect(request.getContextPath() + "/AddQuestionPage.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/MainPage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
