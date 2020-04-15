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
    name = "Kirjaudu",
    urlPatterns = {"/kirjaudu"}
)
public class Kirjaudu extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	
	response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    String un = request.getParameter("username");
    String upw = request.getParameter("password");
    String uun = "admin";
    String pw = "admin";
    String passmd5 = crypt(pw);
    String upassmd5 = crypt(upw);
    response.setContentType("text/html;charset=UTF-8");
    try {

    	if(passmd5.contentEquals(upassmd5) && un.contentEquals(uun)) {
    		
    		HttpSession session=request.getSession();
    		session.setAttribute("name", uun);
    		response.sendRedirect("/AdminControlPanel");
    		
    		
    	} else {
    		response.getWriter().println("V‰‰r‰ salasana tai k‰ytt‰j‰nimi");
    	}
    } catch(Exception e) {
    
    }

  }
	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");

            digester.update(str.getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}