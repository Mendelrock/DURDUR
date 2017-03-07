package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*import javax.servlet.annotation.WebServlet;

@WebServlet("/AuthServlet")*/
@SuppressWarnings("serial")
public class Authentification extends HttpServlet {
	private data.User user;
	private HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		
		session = request.getSession(true);
		
		session.setAttribute(arg0, arg1);
        
		response.setContentType("text/html");
		
		
		
    }
}
