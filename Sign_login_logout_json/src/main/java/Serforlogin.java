import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
@WebServlet("/login")
public class Serforlogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       JSONParser parser=new JSONParser();
       
       JSONArray a = null;
       
	try {
		a = (JSONArray)parser.parse(new FileReader("C:\\Users\\Lenova\\jos.json"));
	} catch (IOException | ParseException e)
	{
		
		e.printStackTrace();
	}
       
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
  
        

        String user = request.getParameter("usName");
        String password = request.getParameter("usPass");
 
        for(Object o: a){
        	JSONObject person = (JSONObject) o;

            String namejs = (String) person.get("name");
            String passjs = (String) person.get("password");
            
        	
            if(user.equals(namejs) && password.equals(passjs)){
            	
            	String key=Sendmail.getKey();
            	
                Sendmail.sendlogin(namejs, key);
               // out.println("<font color=#001f3f>Check your Gmail inbox for secure link to login...waiting page</font>");
              
                HttpSession session = request.getSession();
            	session.setAttribute("user", user);
            	session.setAttribute("k", key);
                //out.println("<a href='Sec?key="+key+"'>Login</a>");
                try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                session.removeAttribute("k");
                RequestDispatcher r = request.getRequestDispatcher("login.jsp");
                out.println("<font <font color=#001f3f>The link is expired</font>");
                r.include(request, response);
                out.close();
                break;
            }
            	
            
        }
        RequestDispatcher rld = request.getRequestDispatcher("login.jsp");
        out.println("<font color=red>Password or UserName is wrong</font>");
        rld.include(request, response);
        out.close();
    }
}


