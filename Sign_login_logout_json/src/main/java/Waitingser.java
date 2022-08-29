import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/wait")
public class Waitingser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		HttpSession session = request.getSession();
		long startTime = System.nanoTime();
		long endTime,totalTime;
		while (true) {
			
			if(session.getAttribute("123key123")==null) {
				   
			     endTime   = System.nanoTime();
				 totalTime = TimeUnit.NANOSECONDS.toSeconds(endTime - startTime);
			    
			if(totalTime>10) {
				session.removeAttribute("k");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();		
				RequestDispatcher rld = request.getRequestDispatcher("login.jsp");
		        out.println("<font color=red>Link is expired!!!</font>");
		        rld.include(request, response);
				out.close();
				break;
			}
			}
			else {
				response.sendRedirect("Wel.jsp");
				break;
			}
			
		}
		 
		 
	 }

}
