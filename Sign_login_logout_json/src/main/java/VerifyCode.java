
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Code")
public class VerifyCode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String str= session.getAttribute("authcode").toString();
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            String code = request.getParameter("authcode");
            
            if(code.equals(str)){
            	
            	 String name= session.getAttribute("name").toString();
            	 String pwd= session.getAttribute("pass").toString();
            	 String gen= session.getAttribute("gen").toString();
            	 String city= session.getAttribute("city").toString();
            	
            	 user e=new user();
            	 e.setName(name);
         		 e.setPassword(pwd);
         		 e.setGender(gen);
         		 e.setCity(city);
            	 Jos.add(e);
            	 request.getSession(false).invalidate();
            	 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                 out.println("<font color=green>Verification Done</font>");
                 rd.include(request, response);
                
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("vf.jsp");
                out.println("<font color=red>Incorrect verification code</font>");
                rd.include(request, response);
            }
            
        }
    }
    
    
    }



    