package adminpages;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
    name = "KirjauduUlos",
    urlPatterns = {"/kirjauduUlos"}
)
public class KirjauduUlos extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	
	response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    HttpSession session=request.getSession();  
    session.invalidate();  
    response.getWriter().print("Kirjauduit ulos onnistuneesti!");
    
    }
}