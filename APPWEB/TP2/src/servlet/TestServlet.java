package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
	    String title = "bonjour jeff";

        out.println("<html>");
        
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>" + title + " big boss " + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
