<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<%
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
   if(session.getAttribute("123key123")==null){
        session.removeAttribute("user");
    	response.sendRedirect("login.jsp");
    }
%>
	<form action="Wel" method="get">

		<h2>
			
			<%
			
			String str=(String)session.getAttribute("user");
			out.println("Hello !!! "+str);
			
			%>
		</h2>
		

		<br> <input type="submit" value="Logout" />
	</form>
	
</body>
</html>
