import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Wel")
public class Serforlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//PrintWriter out = response.getWriter();

		
		//response.setContentType("text/html");

		
		System.out.println("Session before invalidate: "+ request.getSession(false));

		
		request.getSession(false).invalidate();

		System.out.println("Session after invalidate: "+ request.getSession(false));
		
		HttpSession session = request.getSession();
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		//out.println("Thank you! You are successfully logged out.");
		if(session.getAttribute("user")==null){
	    	response.sendRedirect("login.jsp");
	    }
		//out.close();
	}

}
