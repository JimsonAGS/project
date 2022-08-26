

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Random;




@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		String gen=request.getParameter("gender");
		String city=request.getParameter("city");
		String ran =Sendmail.getKey();
		user e=new user();
		e.setName(name);
		e.setPassword(pwd);
		e.setGender(gen);
		e.setCity(city);
		e.setCode(ran);
		int s=Jos.save(e);
		if(s==0) {
			
			boolean test=Sendmail.send(name,ran);
			if(test){
	               HttpSession session  = request.getSession();
	               session.setAttribute("authcode", ran);
	               session.setAttribute("name", name);
	               session.setAttribute("pass", pwd);
	               session.setAttribute("gen", gen);
	               session.setAttribute("city", city);
	               response.sendRedirect("vf.jsp");
	               
	           }else{
	      		  out.println("Failed to send verification email");
	      	   }
			
		
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
	        out.println("<font color=red>User already exist!!!</font>");
	        rd.include(request, response);
	        out.close();
		}
		out.close();
	}

}
