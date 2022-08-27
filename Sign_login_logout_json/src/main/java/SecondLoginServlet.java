import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
@WebServlet("/Sec")
public class SecondLoginServlet  extends HttpServlet {  
  



	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
{
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession();
        String k=(String) session.getAttribute("k");
        String ke1=request.getParameter("key"); 
        if(ke1.equals(k)) {
		session.setAttribute("123key123", ke1);
        	response.sendRedirect("Wel.jsp");
        }
        else {
    		session.removeAttribute("user");
    		session.removeAttribute("k");
    		session.invalidate();
            out.println("<font color=red>Invalid Key</font>");
            response.sendRedirect("login.jsp");
            out.close();
        }
 
}

  
}  
